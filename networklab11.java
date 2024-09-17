import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class networklab11 {
    public static void main(String[] args) throws IOException {
        String resource = "http://facebook.com/";
        URL url = new URL(resource);

        URLConnection conn= url.openConnection();
        Map <String , List<String>> headerFields = conn.getHeaderFields();
        
        Set<String> keys = headerFields.keySet();

        for(String key : keys){
            List<String> values = headerFields.get(key);
            System.out.print(key +":");

        for (String value : values){
            System.out.print(value + "\t"); 
        }
        System.out.println();
        }
        
    }
}
