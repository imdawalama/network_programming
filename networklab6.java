import java.io.IOException;
import java.net.URISyntaxException;

import java.net.*;

;

public class networklab6 {
    public static void main(String[] args) throws IOException,URISyntaxException {
        

        URI newuri = new URI("http","www.google.com","search1");
        System.out.println("getScheme is:" + newuri.getScheme());
        System.out.println("get specified part is " +newuri.getSchemeSpecificPart());

        System.out.println("fragment part is:" + newuri.getFragment());
        System.out.println( newuri.getHost());
        System.out.println( newuri.getAuthority());
        System.out.println( newuri.getUserInfo());





        
    }
}
