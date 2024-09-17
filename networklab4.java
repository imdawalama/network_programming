import java.io.IOException;
import java.net.*;

public class networklab4 {
    
    public static void main(String[] args) throws URISyntaxException, IOException {
        String baseUrl = "https://www.javatpoint.com/java-tutorial";
        URI uri = new URI(baseUrl);
        URL url = uri.toURL();
        Object content = url.openConnection().getContent();
        System.out.println(content);
    }
}
