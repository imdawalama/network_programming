import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;
import java.net.InetSocketAddress;


// Sets up an HttpServer instance that listens on port 8000.
// Defines a RedirectHandler class that handles HTTP requests and redirects them to a specified URL.
// Starts the server and listens for incoming connections.
public class SimpleRedirector {
    public static void main(String[] args) throws IOException {
        // Define the port to listen on
        int port = 8000;

        // Create the HttpServer instance
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);

        // Create a context for handling requests to the root
        server.createContext("/", new RedirectHandler());

        // Start the server
        server.setExecutor(null); // Use the default executor
        server.start();

        System.out.println("Redirector server started on port " + port);
    }
}
class RedirectHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        // Define the new location to redirect to
        String newLocation = "http://example.com";

        // Send a 301 Moved Permanently response with the new location
        exchange.getResponseHeaders().set("Location", newLocation);
        exchange.sendResponseHeaders(301, -1); // -1 means no response body
        exchange.close();
    }
}

