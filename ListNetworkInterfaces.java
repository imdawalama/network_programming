import java.net.*;
import java.util.*;

public class ListNetworkInterfaces {
    public static void main(String[] args) {
        try {
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
            while (interfaces.hasMoreElements()) {
                NetworkInterface networkInterface = interfaces.nextElement();
                System.out.println("Name: " + networkInterface.getName());
                System.out.println("Display Name: " + networkInterface.getDisplayName());
                
                byte[] mac = networkInterface.getHardwareAddress();
                if (mac != null) {
                    System.out.print("MAC Address: ");
                    for (int i = 0; i < mac.length; i++) {
                        System.out.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : "");
                    }
                    System.out.println();
                }
                
                System.out.println("MTU: " + networkInterface.getMTU());
                System.out.println("Up: " + networkInterface.isUp());
                System.out.println("Loopback: " + networkInterface.isLoopback());
                System.out.println("PointToPoint: " + networkInterface.isPointToPoint());
                System.out.println("Virtual: " + networkInterface.isVirtual());
                System.out.println("Supports Multicast: " + networkInterface.supportsMulticast());
                System.out.println();
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }
}
