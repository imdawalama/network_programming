import java.io.IOException;
import java.net.*;
public class network {
    public static void main(String[] args)  {
        try
        {
       InetAddress add = InetAddress.getByName("www.youtube.com");
        add.getHostAddress();
        add.getCanonicalHostName();
        add.getClass();
        add.hashCode();
        add.getHostName();
        add.isAnyLocalAddress();
      System.out.println(add);
      System.out.println("Hostname =" + add.getHostAddress());
     System.out.println("CanonicalHostName =" + add.getCanonicalHostName());
     System.out.println("Class =" + add.getClass());
     System.out.println("HashCode=" +add.hashCode());
     System.out.println(add.isAnyLocalAddress());



     }
    // InetAddress[] add = InetAddress.getAllByName("www.google.com");
    // add.getClass();
    // System.out.println(add);
    // System.out.println("Class="+add.getClass());
    
    // }
    catch (IOException e) 
    {
      System.out.println(e);
    }



}
}