import java.io.IOException;
import java.net.*;
public class network1 {
    public static void main(String[] args)  {
        try
        {
    InetAddress address= InetAddress.getByName("www.facebook.com");
    if (address.isAnyLocalAddress()) {
        
    System.out.println("bibek is bitch");
    }
    else{
        System.out.println("bitch is bibek");
    }
    }
    catch (IOException e) {
      System.out.println(e);
    }


}
}
