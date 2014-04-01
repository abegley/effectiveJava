package effective.java.chp10.adyen.report.retrieval.concurrent;


import effective.java.chp10.adyen.report.retrieval.MerchantReport;
import effective.java.chp10.adyen.report.retrieval.UrlResource;
import effective.java.chp10.divide.conquer.SystemUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ConcurrentRT extends MerchantReport {

    @Override
    public void retrieveReports(final Map<String, String> reports) {
        final int numberOfCores = Runtime.getRuntime().availableProcessors();
        final double blockingCoefficient = 0.9;
        final int poolSize = (int)(numberOfCores / (1 - blockingCoefficient));

        System.out.println("Number of Cores available is " + numberOfCores);
        System.out.println("Pool size is " + poolSize);

        final UrlResource urlResource = new UrlResource();

        final ExecutorService executorPool = Executors.newFixedThreadPool(poolSize);

        //Store the future object returned from executorPool.submit
        final List<Future> futures = new ArrayList<Future>();

        for(final String reportName : reports.keySet()){
            futures.add(executorPool.submit(new Runnable() {
                @Override
                public void run() {
                    urlResource.connect((String) reportName, (String) reports.get(reportName));
                }
            }));
        }

        for(Future future : futures){
            try {
                future.get(); //wait for task to complete
            } catch (InterruptedException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            } catch (ExecutionException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }

        executorPool.shutdown();
    }

    public static void main (String [] args){
        SystemUtil.setHttpProxy();
        new ConcurrentRT().start();

    }
}
