package effective.java.chp10.adyen.report.retrieval;




import org.apache.commons.codec.binary.Base64;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class UrlResource {

    public void connect( String reportName, String reportUrl){
        String authString = "report_481292@Company.Cybersource" + ":" + "jb7>]8EZ=^SExt9Iz-b\\UEJMP";
        byte[] authEncBytes = Base64.encodeBase64((authString.getBytes()));
        String authStringEnc = new String(authEncBytes);

        try {
            URL url = new URL(reportUrl);
            System.out.println("Getting report: " + reportUrl);
            URLConnection urlConnection = url.openConnection();
            urlConnection.setRequestProperty("Authorization", "Basic " + authStringEnc);
            InputStream is = urlConnection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(is);

            int numCharsRead;
            char[] charArray = new char[1024];
            StringBuffer sb = new StringBuffer();
            while((numCharsRead = inputStreamReader.read(charArray)) > 0) {
                sb.append(charArray, 0, numCharsRead);
            }

            System.out.println(reportName + " retrieved.");

        } catch (MalformedURLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

}
