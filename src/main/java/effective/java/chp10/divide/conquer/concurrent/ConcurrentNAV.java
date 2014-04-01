package effective.java.chp10.divide.conquer.concurrent;

import effective.java.chp10.divide.conquer.AbstractNAV;
import effective.java.chp10.divide.conquer.SystemUtil;
import effective.java.chp10.divide.conquer.YahooFinance;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

public class ConcurrentNAV extends AbstractNAV{

    @Override
    public double computeNetAssetValues(final Map<String, Integer> stocks) throws IOException, InterruptedException, ExecutionException {
        final int numberOfCores = Runtime.getRuntime().availableProcessors();
        final double blockingCoefficient = 0.9;
        final int poolSize = (int)(numberOfCores / (1 - blockingCoefficient));

        System.out.println("Number of Cores available is " + numberOfCores);
        System.out.println("Pool size is " + poolSize);

        //Declare list of Callable tasks, our tasks are going to return a result, hence, Callable
        final List<Callable<Double>> partitions = new ArrayList<Callable<Double>>();

        for(final String ticker : stocks.keySet()){
            partitions.add(new Callable<Double>() {    // Double is the data type of the result
                @Override
                public Double call() throws Exception {
                    return stocks.get(ticker) * YahooFinance.getPrice(ticker);
                }
            });
        }

        //use static factory to return instance of ThreadPoolExecutor
        final ExecutorService executorPool = Executors.newFixedThreadPool(poolSize);
        //invokeAll  - invokes all of the Callable objects passed to it in the partitions collection
        //tasks are not executed in order
        final List<Future<Double>> valueOfStocks = executorPool.invokeAll(partitions, 10000, TimeUnit.SECONDS);

        //Note, InvokeAny - does not return a future
        //Submit(runnable), Submit(Callable)

        double netAssetValue = 0.0;

        //Compute the total asset value of all my stocks
        for (final Future<Double> valueOfAStock : valueOfStocks){
            netAssetValue += valueOfAStock.get();
            //result can only be retrieved using the 'get' method when the computation has completed,
            //blocking if necessary until it is ready
        }

        executorPool.shutdown();
        return netAssetValue;
    }

    public static void main (String [] args) throws InterruptedException, ExecutionException, IOException {
        SystemUtil.setHttpProxy();
        new ConcurrentNAV().timeAndComputeValue();
    }


}
