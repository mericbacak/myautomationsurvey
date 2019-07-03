import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.testng.annotations.Test;
public class APITestCase4 {

    @Test
    //Verify that the id field is read−only.
    public void Testcase4() throws Exception
    {
        try {
            URL url4 = new URL("http://www.mocky.io/v2/5d1bac883400004c00000906");
            HttpURLConnection conn4 = (HttpURLConnection) url4.openConnection();
            conn4.setRequestMethod("PUT");
            conn4.setDoOutput(true);
            conn4.setRequestProperty("Content-Type", "application/json");
            conn4.setRequestProperty("Accept", "application/json");
            OutputStreamWriter osw = new OutputStreamWriter(conn4.getOutputStream());
            osw.write(String.format("{\"id\":41,\"author\":\"author\",\"title\":\"test\"}"));
            osw.flush();
            osw.close();
            System.err.println(conn4.getResponseCode());
            Scanner scan4 = new Scanner(url4.openStream());
            String entireResponse4 = new String();
            while (scan4.hasNext())
                entireResponse4 += scan4.nextLine();
            System.out.println("RESPONSE4");
            System.out.println(entireResponse4);
            scan4.close();
        }
        catch (MalformedURLException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
