package effective.java.chp10.divide.conquer;


public class SystemUtil {
    public static void setHttpProxy() {
        System.setProperty("http.proxyHost", "localhost");
        System.setProperty("http.proxyPort", "3128");
        System.setProperty("https.proxyHost", "localhost");
        System.setProperty("https.proxyPort", "3128");
    }
}
