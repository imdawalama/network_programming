import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.net.URISyntaxException;


public class networklab5 {
    public static void main(String[] args) throws IOException, URISyntaxException {
        URI uri = new URI("http://www.w3schools.com/HTML");
        URI seconduri = new URI("http://www.w3schools.com");
         URL secondurl = seconduri.toURL();
         URL url = uri.toURL();
    //   URLConnection ins = url.openConnection();
    //   System.out.println("getcontent is type is: "+ ins.getContentType());
    //   System.out.println("connection timeout is :"+ ins.getConnectTimeout());
    //   System.out.println("Scheme is: "+ uri.getScheme());
    //   System.out.println("authority "+ uri.getAuthority());
    //   URLConnection secins = secondurl.openConnection();
    //   System.out.println(" content is:"+ secins.getInputStream());
        BufferedReader brd = new BufferedReader(new InputStreamReader(url.openStream()));
        String inputl;
        while((inputl = brd.readLine())!= null){
            System.out.println(inputl);
            brd.close();
        }
    }
}
