import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import org.testng.annotations.Test;
public class APITestCase6 {
    @Test
    //Verify that you cannot create a duplicate book.
    public void Testcase6() throws Exception{
        try {
            URL url0 = new URL("http://www.mocky.io/v2/5d1badaa340000540000090e");
            HttpURLConnection conn0 = (HttpURLConnection) url0.openConnection();
            conn0.setRequestMethod("PUT");
            conn0.setDoOutput(true);
            conn0.setRequestProperty("Content-Type", "application/json");
            conn0.setRequestProperty("Accept", "application/json");
            OutputStreamWriter osw = new OutputStreamWriter(conn0.getOutputStream());
            System.out.println(conn0.getResponseCode());
            osw.write(String.format("{\"author\":\"author 62\",\"title\":\"title 62\"}"));
            osw.flush();
            osw.close();
            Scanner scan0 = new Scanner(url0.openStream());
            String entireResponse0 = new String();
            while (scan0.hasNext())
                entireResponse0 += scan0.nextLine();
            System.out.println("RESPONSE_PUT:"+entireResponse0);
            scan0.close();
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
