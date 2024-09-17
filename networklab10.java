import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;

public class networklab10 {
    public static void main(String[] args) throws URISyntaxException, IOException {
        String name = "http://spm.com.np/";
        URI uri = new URI(name);
        URL url = uri.toURL();

        URLConnection conn = url.openConnection();
        String ct = conn.getHeaderField("Content-type");
        String lm =conn.getHeaderField("Last-Modified");
        String cl =conn.getHeaderField("Content-length");
        String date =conn.getHeaderField("Date");
        System.out.println("content type = " + ct);
        System.out.println("last-modified = " + lm);
        System.out.println("content-length ="+ cl);
        System.out.println("date:" +date);

    }
}
