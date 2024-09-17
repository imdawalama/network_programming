import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;




public class networklab9 {
    public static void main(String[] args) throws IOException, URISyntaxException {
        String name = "http://spm.com.np/";
        URI uri = new URI(name);
        URL url = uri.toURL();
        URLConnection conn = url.openConnection();
        String content = conn.getContentType();
        int length = conn.getContentLength();
        long date = conn.getDate();
          Date date1= new Date(date);
        System.out.println("contenttype =" + content);
        System.out.println("length =" + length);
        System.out.println("date =" + date1);


    }
}
