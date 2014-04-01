package effective.java.chp10.divide.conquer;

import java.io.*;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;


public abstract class AbstractNAV {


    public static Map<String, Integer> readTickers() throws IOException {
        InputStream stocksFile = AbstractNAV.class.getResourceAsStream("/stocks.txt");
        final BufferedReader reader = new BufferedReader(new InputStreamReader(stocksFile));

        final Map<String, Integer> stocks = new HashMap<String, Integer>();

        String stockInfo = null;
        while( (stockInfo = reader.readLine()) != null){
            final String[] stockInfoData = stockInfo.split(",");
            final String stockTicker = stockInfoData[0];
            final Integer quantity = Integer.valueOf(stockInfoData[1]);

            stocks.put(stockTicker, quantity);
        }

        return stocks;
    }

    public void timeAndComputeValue() throws IOException, ExecutionException, InterruptedException {
        final long start =System.nanoTime();

        final Map<String, Integer> stocks = readTickers();
        final double nav = computeNetAssetValues(stocks);

        final long end = System.nanoTime();

        final String value = new DecimalFormat("$##,##0.00").format(nav);
        System.out.println("Your net asset value is " + value);
        System.out.println("Time (seconds) taken " + (end -start)/1.0e9);

    }

    protected abstract double computeNetAssetValues(final Map<String, Integer> stocks) throws IOException, InterruptedException, ExecutionException;
}
