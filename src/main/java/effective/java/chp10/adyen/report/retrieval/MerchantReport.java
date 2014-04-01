package effective.java.chp10.adyen.report.retrieval;


import java.util.HashMap;
import java.util.Map;

public abstract class MerchantReport {



    public void start()  {
        final long start =System.nanoTime();

        final Map<String, String> reports = readReports();
        retrieveReports(reports);

        final long end = System.nanoTime();

        System.out.println("Time (seconds) taken " + (end -start)/1.0e9);
    }

    public abstract void retrieveReports(Map<String, String> reports);


    private Map<String, String>  readReports() {
        Map<String, String> reports = new HashMap<String, String>();
        reports.put("exchange_rate_report_2014_01_23.csv", "https://ca-test.adyen.com/reports/download/MerchantAccount/CybersourceCOM/exchange_rate_report_2014_01_23.csv");
        reports.put("exchange_rate_report_2014_01_23.xml", "https://ca-test.adyen.com/reports/download/MerchantAccount/CybersourceCOM/exchange_rate_report_2014_01_23.xml");
        reports.put("exchange_rate_report_2014_01_22.csv", "https://ca-test.adyen.com/reports/download/MerchantAccount/CybersourceCOM/exchange_rate_report_2014_01_22.csv");
        reports.put("exchange_rate_report_2014_01_22.xml", "https://ca-test.adyen.com/reports/download/MerchantAccount/CybersourceCOM/exchange_rate_report_2014_01_22.xml");
        reports.put("exchange_rate_report_2014_01_20.csv", "https://ca-test.adyen.com/reports/download/MerchantAccount/CybersourceCOM/exchange_rate_report_2014_01_20.csv");
        reports.put("exchange_rate_report_2014_01_19.xml", "https://ca-test.adyen.com/reports/download/MerchantAccount/CybersourceCOM/exchange_rate_report_2014_01_19.xml");
        reports.put("exchange_rate_report_2014_01_19.csv", "https://ca-test.adyen.com/reports/download/MerchantAccount/CybersourceCOM/exchange_rate_report_2014_01_19.csv");
        reports.put("exchange_rate_report_2014_01_18.xml", "https://ca-test.adyen.com/reports/download/MerchantAccount/CybersourceCOM/exchange_rate_report_2014_01_18.xml");
        reports.put("exchange_rate_report_2014_01_18.csv", "https://ca-test.adyen.com/reports/download/MerchantAccount/CybersourceCOM/exchange_rate_report_2014_01_18.csv");
        reports.put("exchange_rate_report_2014_01_17.xml", "https://ca-test.adyen.com/reports/download/MerchantAccount/CybersourceCOM/exchange_rate_report_2014_01_17.xml");
        reports.put("exchange_rate_report_2014_01_17.csv", "https://ca-test.adyen.com/reports/download/MerchantAccount/CybersourceCOM/exchange_rate_report_2014_01_17.csv");
        reports.put("exchange_rate_report_2014_01_16.xml", "https://ca-test.adyen.com/reports/download/MerchantAccount/CybersourceCOM/exchange_rate_report_2014_01_16.xml");
        reports.put("exchange_rate_report_2014_01_16.csv", "https://ca-test.adyen.com/reports/download/MerchantAccount/CybersourceCOM/exchange_rate_report_2014_01_16.csv");
        reports.put("exchange_rate_report_2014_01_15.xml", "https://ca-test.adyen.com/reports/download/MerchantAccount/CybersourceCOM/exchange_rate_report_2014_01_15.xml");
        reports.put("exchange_rate_report_2014_01_15.csv", "https://ca-test.adyen.com/reports/download/MerchantAccount/CybersourceCOM/exchange_rate_report_2014_01_15.csv");
        reports.put("exchange_rate_report_2014_01_14.xml", "https://ca-test.adyen.com/reports/download/MerchantAccount/CybersourceCOM/exchange_rate_report_2014_01_14.xml");
        reports.put("exchange_rate_report_2014_01_14.csv", "https://ca-test.adyen.com/reports/download/MerchantAccount/CybersourceCOM/exchange_rate_report_2014_01_14.csv");
        reports.put("exchange_rate_report_2014_01_13.xml", "https://ca-test.adyen.com/reports/download/MerchantAccount/CybersourceCOM/exchange_rate_report_2014_01_13.xml");
        reports.put("exchange_rate_report_2014_01_13.csv", "https://ca-test.adyen.com/reports/download/MerchantAccount/CybersourceCOM/exchange_rate_report_2014_01_13.csv");
        reports.put("exchange_rate_report_2014_01_12.csv", "https://ca-test.adyen.com/reports/download/MerchantAccount/CybersourceCOM/exchange_rate_report_2014_01_12.csv");
        reports.put("exchange_rate_report_2014_01_12.xml", "https://ca-test.adyen.com/reports/download/MerchantAccount/CybersourceCOM/exchange_rate_report_2014_01_12.xml");
        reports.put("exchange_rate_report_2014_01_11.csv", "https://ca-test.adyen.com/reports/download/MerchantAccount/CybersourceCOM/exchange_rate_report_2014_01_11.csv");
        reports.put("exchange_rate_report_2014_01_11.xml", "https://ca-test.adyen.com/reports/download/MerchantAccount/CybersourceCOM/exchange_rate_report_2014_01_11.xml");
        reports.put("exchange_rate_report_2014_01_10.xml", "https://ca-test.adyen.com/reports/download/MerchantAccount/CybersourceCOM/exchange_rate_report_2014_01_10.xml");
        reports.put("exchange_rate_report_2014_01_10.csv", "https://ca-test.adyen.com/reports/download/MerchantAccount/CybersourceCOM/exchange_rate_report_2014_01_10.csv");
        reports.put("exchange_rate_report_2014_01_09.xml", "https://ca-test.adyen.com/reports/download/MerchantAccount/CybersourceCOM/exchange_rate_report_2014_01_09.xml");
        reports.put("exchange_rate_report_2014_01_09.csv", "https://ca-test.adyen.com/reports/download/MerchantAccount/CybersourceCOM/exchange_rate_report_2014_01_09.csv");
        reports.put("exchange_rate_report_2014_01_08.csv", "https://ca-test.adyen.com/reports/download/MerchantAccount/CybersourceCOM/exchange_rate_report_2014_01_08.csv");
        reports.put("exchange_rate_report_2014_01_08.xml", "https://ca-test.adyen.com/reports/download/MerchantAccount/CybersourceCOM/exchange_rate_report_2014_01_08.xml");
        reports.put("exchange_rate_report_2014_01_07.csv", "https://ca-test.adyen.com/reports/download/MerchantAccount/CybersourceCOM/exchange_rate_report_2014_01_07.csv");
        reports.put("exchange_rate_report_2014_01_07.xml", "https://ca-test.adyen.com/reports/download/MerchantAccount/CybersourceCOM/exchange_rate_report_2014_01_07.xml");
        reports.put("exchange_rate_report_2014_01_06.csv", "https://ca-test.adyen.com/reports/download/MerchantAccount/CybersourceCOM/exchange_rate_report_2014_01_06.csv");
        reports.put("exchange_rate_report_2014_01_06.xml", "https://ca-test.adyen.com/reports/download/MerchantAccount/CybersourceCOM/exchange_rate_report_2014_01_06.xml");
        reports.put("exchange_rate_report_2014_01_05.xml", "https://ca-test.adyen.com/reports/download/MerchantAccount/CybersourceCOM/exchange_rate_report_2014_01_05.xml");
        reports.put("exchange_rate_report_2014_01_05.csv", "https://ca-test.adyen.com/reports/download/MerchantAccount/CybersourceCOM/exchange_rate_report_2014_01_05.csv");
        reports.put("exchange_rate_report_2014_01_04.csv", "https://ca-test.adyen.com/reports/download/MerchantAccount/CybersourceCOM/exchange_rate_report_2014_01_04.csv");
        reports.put("exchange_rate_report_2014_01_04.xml", "https://ca-test.adyen.com/reports/download/MerchantAccount/CybersourceCOM/exchange_rate_report_2014_01_04.xml");
        reports.put("exchange_rate_report_2014_01_03.xml", "https://ca-test.adyen.com/reports/download/MerchantAccount/CybersourceCOM/exchange_rate_report_2014_01_03.xml");
        reports.put("exchange_rate_report_2014_01_03.csv", "https://ca-test.adyen.com/reports/download/MerchantAccount/CybersourceCOM/exchange_rate_report_2014_01_03.csv");
        reports.put("exchange_rate_report_2014_01_02.csv", "https://ca-test.adyen.com/reports/download/MerchantAccount/CybersourceCOM/exchange_rate_report_2014_01_02.csv");
        reports.put("exchange_rate_report_2014_01_02.xml", "https://ca-test.adyen.com/reports/download/MerchantAccount/CybersourceCOM/exchange_rate_report_2014_01_02.xml");
        reports.put("exchange_rate_report_2014_01_01.csv", "https://ca-test.adyen.com/reports/download/MerchantAccount/CybersourceCOM/exchange_rate_report_2014_01_01.csv");
        return reports;
    }


}
