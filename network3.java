import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
public class network3 {
    public static void main(String[] args) {
       try{
          InetAddress address= InetAddress.getByName("127.0.0.1");
          NetworkInterface ni = NetworkInterface.getByInetAddress(address);
  
                ni.getName();
                ni.getDisplayName();
                ni.getMTU();
                ni.isLoopback();
                ni.isUp();
                ni.isPointToPoint();
                ni.isVirtual();
          System.out.println(ni.getNetworkInterfaces());
          System.out.println(ni.getIndex());
          if(ni ==null)
          {
               System.out.println("no network interface address is found.");}
          
      else{
            System.out.println("network interface is found");
            System.out.println(ni.getName());
            System.out.println(ni.getDisplayName());
            System.out.println(ni.getMTU());
            System.out.println( ni.isLoopback());
            System.out.println(ni.isUp());
            System.out.println( ni.isPointToPoint());
            System.out.println( ni.isVirtual());


          }
        
       }
       catch(SocketException ex){
        System.out.println(ex);
       }
       catch(UnknownHostException e) {
        System.out.println(e);
       }
   
    }
}
