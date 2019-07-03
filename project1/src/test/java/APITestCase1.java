import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import org.testng.annotations.Test;
public class APITestCase1
{
    @Test
    //Verify that the API starts with an empty store.
    public void Testcase1() throws Exception
    {
        try {
            URL url0 = new URL("https://5d19c557b3b6a100148d22d6.mockapi.io/api/books/41");
            //id 41 book taken
            URL url1 = new URL("https://5d19c557b3b6a100148d22d6.mockapi.io/api/empty/") ;
            //all list taken, if booklist empty, empty list return
            HttpURLConnection conn0 = (HttpURLConnection) url0.openConnection();
            HttpURLConnection conn1 = (HttpURLConnection) url1.openConnection();
            conn0.setRequestMethod("GET");
            conn1.setRequestMethod("GET");
            //if (conn.getResponseCode() != 200)
                //throw new RuntimeException(" HTTP ERROR CODE"+ conn.getResponseCode());
            Scanner scan0 = new Scanner(url0.openStream());
            Scanner scan1= new Scanner(url1.openStream());
            String entireResponse0 = new String();
            String entireResponse1= new String();
            System.out.println(conn0.getResponseCode());
            while (scan0.hasNext())
                entireResponse0 += scan0.nextLine();
            System.out.println("RESPONSE0"+entireResponse0);
            scan0.close();
            System.out.println(conn1.getResponseCode());
            while (scan1.hasNext())
            entireResponse1 += scan1.nextLine();
            System.out.println("RESPONSE1"+entireResponse1);
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