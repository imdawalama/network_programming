
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * PostMethodToServer
 */
public class networklab8{
 

    public static void main(String[] args) throws URISyntaxException {
        String urlString = "http://spm.com.np/";
        String urlParameters = "param1=value1&param2=value2";

        try {
            // Create URL object
            URI uri = new URI(urlString);
            URL urls= uri.toURL();  
         

            // Open connection
            HttpURLConnection connection = (HttpURLConnection) urls.openConnection();

            // Set request method to POST
            connection.setRequestMethod("POST");

            // Set request properties
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            connection.setRequestProperty("Content-Length", Integer.toString(urlParameters.getBytes().length));
            connection.setRequestProperty("Content-Language", "en-US");

            // Enable input and output streams
            connection.setDoOutput(true);

            // Write POST data to output stream
            try (DataOutputStream wr = new DataOutputStream(connection.getOutputStream())) {
                wr.writeBytes(urlParameters);
                wr.flush();
            }

            // Get response code
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            // Read the response from input stream
            try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream())))
             {
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }

                // Print the response
                System.out.println("Response: " + response.toString());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
