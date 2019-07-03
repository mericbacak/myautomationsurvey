import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import org.testng.annotations.Test;
public class API_TestCase5 {
    @Test
    //Verify that you can create a new book via PUT.
    public void Testcase5() throws Exception
    {
        try {
            URL url0 = new URL("http://www.mocky.io/v2/5d1ba8663400007dcd0008fe");
            URL url1 = new URL("https://5d19c557b3b6a100148d22d6.mockapi.io/api/books/62") ;
            HttpURLConnection conn0 = (HttpURLConnection) url0.openConnection();
            HttpURLConnection conn1 = (HttpURLConnection) url1.openConnection();
            conn0.setRequestMethod("PUT");
            conn1.setRequestMethod("GET");
            conn0.setDoOutput(true);
            conn0.setRequestProperty("Content-Type", "application/json");
            conn0.setRequestProperty("Accept", "application/json");
            OutputStreamWriter osw = new OutputStreamWriter(conn0.getOutputStream());
            System.out.println(conn0.getResponseCode());
            osw.write(String.format("{\"author\":\"author 62\",\"title\":\"title 62\"}"));
            osw.flush();
            osw.close();
            Scanner scan0 = new Scanner(url0.openStream());
            Scanner scan1= new Scanner(url1.openStream());
            String entireResponse0 = new String();
            String entireResponse1= new String();
            while (scan0.hasNext())
                entireResponse0 += scan0.nextLine();
            System.out.println("RESPONSE_PUT:"+entireResponse0);
            scan0.close();
            System.out.println(conn1.getResponseCode());
            while (scan1.hasNext())
                entireResponse1 += scan1.nextLine();
            System.out.println("RESPONSE_GET:"+entireResponse1);
            scan1.close();
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
