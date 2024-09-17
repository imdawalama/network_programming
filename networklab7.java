
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.net.URLDecoder;

public class networklab7 {
    public static void main(String[] args) throws IOException, URISyntaxException , UnsupportedEncodingException{
        // String aws = "simple text !@#$";
        // String encodedaws = URLEncoder.encode(aws,"utf-8");
        
        // System.out.println(encodedaws);
    String aws = "simple+text+%21%40%23%24";
    String decodedaws = URLDecoder.decode(aws, "utf-8");

    System.out.println(decodedaws);
}
}
