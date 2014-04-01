package effective.java.chp10.divide.conquer.sequential;


import effective.java.chp10.divide.conquer.AbstractNAV;
import effective.java.chp10.divide.conquer.SystemUtil;
import effective.java.chp10.divide.conquer.YahooFinance;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class SequentialNAV extends AbstractNAV {

    @Override
    public double computeNetAssetValues(Map<String, Integer> stocks) throws IOException {
        double netAssetValue = 0.0;
        for (String ticker : stocks.keySet()){
            netAssetValue += stocks.get(ticker) * YahooFinance.getPrice(ticker);
        }

        return netAssetValue;
    }

    public static void main (final String[] args) throws IOException, ExecutionException, InterruptedException {
        SystemUtil.setHttpProxy();
        new SequentialNAV().timeAndComputeValue();
    }
}
