import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class network2 {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress ip = InetAddress.getByName("www.javatpoint.com");
        InetAddress ip1= InetAddress.getByName("www.javatpoint.com");
        byte addr[]= {72,3,2,12};
        System.out.println("ip:" +ip);
        System.out.println("\n ip:" +ip1);

        InetAddress ip2 = InetAddress.getByAddress(addr);
        System.out.println("\n ip address is" + ip2);
        System.out.println(" \n Address:" + Arrays.toString(ip.getAddress()));
        System.out.println(" \nHostName:" +ip.getHostAddress());
        System.out.println("\nAnyLocalAddress:" +ip.isAnyLocalAddress());
        System.out.println("\nisLinkLocalAddress:" +ip.isLinkLocalAddress());
        System.out.println("\nisLoopbackAddress:" +ip.isLoopbackAddress());
        System.out.println("\nisMCGlobal:" +ip.isMCGlobal());
        System.out.println("\nMCOrgLocal:" +ip.isMCOrgLocal());
        System.out.println("\nisMCSiteLocal" +ip.isMCSiteLocal());
        System.out.println("\nisMulticastaddress:" +ip.isMulticastAddress());
        System.out.println("\nissitelocaladdress:" +ip.isSiteLocalAddress());
        System.out.println("\nhashcode:" +ip.hashCode());
        System.out.println(" \n Is ip1 == ip2"+ ip.equals(ip1));










        
    }
}
