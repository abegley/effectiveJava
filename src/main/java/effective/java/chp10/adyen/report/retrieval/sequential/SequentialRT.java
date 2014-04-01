package effective.java.chp10.adyen.report.retrieval.sequential;


import effective.java.chp10.adyen.report.retrieval.MerchantReport;
import effective.java.chp10.adyen.report.retrieval.UrlResource;
import effective.java.chp10.divide.conquer.SystemUtil;

import java.util.Iterator;
import java.util.Map;

public class SequentialRT extends MerchantReport {

    @Override
    public void retrieveReports(Map<String, String> reports) {

        UrlResource url = new UrlResource();
        Iterator iterator = reports.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry reportEntry = (Map.Entry)iterator.next();
            url.connect((String)reportEntry.getKey(), (String)reportEntry.getValue());
        }

    }

    public static void main(String [] args){
         SystemUtil.setHttpProxy();
         new SequentialRT().start();
    }
}
