import org.testng.annotations.Test;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
public class APITestCase3
{
    @Test
    //Verify that title and author cannot be empty.
    public void Testcase3_1() throws Exception
    {
        try {
            URL url1 = new URL("http://www.mocky.io/v2/5d1a7a652f00000e00fd76c0");
            HttpURLConnection connection1 = (HttpURLConnection) url1.openConnection();
            connection1.setRequestMethod("PUT");
            connection1.setDoOutput(true);
            connection1.setRequestProperty("Content-Type", "application/json");
            connection1.setRequestProperty("Accept", "application/json");
            OutputStreamWriter osw = new OutputStreamWriter(connection1.getOutputStream());
            osw.write(String.format("{\"author\":\"\",\"title\":\"test\"}"));
            osw.flush();
            osw.close();
            System.err.println(connection1.getResponseCode());
            Scanner scan1 = new Scanner(url1.openStream());
            String entireResponse1 = new String();
            while (scan1.hasNext())
                entireResponse1 += scan1.nextLine();
            System.out.println("RESPONSE_3_1"+entireResponse1);
            scan1.close();
        }
        catch (MalformedURLException e1)
        {
            e1.printStackTrace();
        } catch (IOException e1)
        {
            e1.printStackTrace();
        }
    }
    @Test
    public void Testcase3_2() throws Exception
    {
        try {
            URL url2 = new URL("http://www.mocky.io/v2/5d1a7c192f00004c00fd76d0");
            HttpURLConnection connection2 = (HttpURLConnection) url2.openConnection();
            connection2.setRequestMethod("PUT");
            connection2.setDoOutput(true);
            connection2.setRequestProperty("Content-Type", "application/json");
            connection2.setRequestProperty("Accept", "application/json");
            OutputStreamWriter osw = new OutputStreamWriter(connection2.getOutputStream());
            osw.write(String.format("{\"author\":\"test\",\"title\":\"\"}"));
            osw.flush();
            osw.close();
            System.err.println(connection2.getResponseCode());
            Scanner scan2 = new Scanner(url2.openStream());
            String entireResponse2 = new String();
            while (scan2.hasNext())
                entireResponse2 += scan2.nextLine();
            System.out.println("RESPONSE_3_2"+entireResponse2);
            scan2.close();
        }
        catch (MalformedURLException e2)
        {
            e2.printStackTrace();
        } catch (IOException e2)
        {
            e2.printStackTrace();
        }
    }
    @Test
    public void Testcase3_3() throws Exception
    {
        try {
            URL url3 = new URL("http://www.mocky.io/v2/5d1a7c522f00007a00fd76d4");
            HttpURLConnection connection3 = (HttpURLConnection) url3.openConnection();
            connection3.setRequestMethod("PUT");
            connection3.setDoOutput(true);
            connection3.setRequestProperty("Content-Type", "application/json");
            connection3.setRequestProperty("Accept", "application/json");
            OutputStreamWriter osw = new OutputStreamWriter(connection3.getOutputStream());
            osw.write(String.format("{\"author\":\"\",\"title\":\"\"}"));
            osw.flush();
            osw.close();
            System.err.println(connection3.getResponseCode());
            Scanner scan3 = new Scanner(url3.openStream());
            String entireResponse3 = new String();
            while (scan3.hasNext())
                entireResponse3 += scan3.nextLine();
            System.out.println("RESPONSE_3_3"+entireResponse3);
            scan3.close();
        }
        catch (MalformedURLException e3)
        {
            e3.printStackTrace();
        } catch (IOException e3)
        {
            e3.printStackTrace();
        }
    }
}