import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;



// Sets up an HttpServer instance that listens on port 8000.
// Defines a StaticFileHandler class to serve static files from the specified directory.
// Defines an ApiHandler class to handle API requests (GET and POST).
// Starts the server and listens for incoming connections.
    
public class FullFledgedHttpServer {
    public static void main(String[] args) throws IOException {
        // Define the port to listen on
        int port = 8000;

        // Create the HttpServer instance
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);

        // Create contexts for handling different requests
        server.createContext("/", new StaticFileHandler("."));
        server.createContext("/api", new ApiHandler());

        // Start the server
        server.setExecutor(null); // Use the default executor
        server.start();

        System.out.println("Server started on port " + port);
    }
}
class StaticFileHandler implements HttpHandler {
    private final Path basePath;

    public StaticFileHandler(String directoryToServe) {
        this.basePath = Paths.get(directoryToServe).toAbsolutePath();
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String requestPath = exchange.getRequestURI().getPath();
        Path filePath = basePath.resolve(requestPath.substring(1)).normalize();

        if (!filePath.startsWith(basePath)) {
            exchange.sendResponseHeaders(403, -1); // 403 Forbidden
            return;
        }

        if (Files.exists(filePath) && !Files.isDirectory(filePath)) {
            byte[] fileBytes = Files.readAllBytes(filePath);
            exchange.getResponseHeaders().add("Content-Type", Files.probeContentType(filePath));
            exchange.sendResponseHeaders(200, fileBytes.length);
            OutputStream os = exchange.getResponseBody();
            os.write(fileBytes);
            os.close();
        } else {
            String response = "404 (Not Found)\n";
            exchange.sendResponseHeaders(404, response.length());
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }
}
class ApiHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        if ("GET".equals(exchange.getRequestMethod())) {
            handleGetRequest(exchange);
        } else if ("POST".equals(exchange.getRequestMethod())) {
            handlePostRequest(exchange);
        } else {
            exchange.sendResponseHeaders(405, -1); // 405 Method Not Allowed
        }
    }

    private void handleGetRequest(HttpExchange exchange) throws IOException {
        String response = "This is a GET response";
        exchange.getResponseHeaders().add("Content-Type", "application/json");
        exchange.sendResponseHeaders(200, response.length());
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }

    private void handlePostRequest(HttpExchange exchange) throws IOException {
        String response = "This is a POST response";
        exchange.getResponseHeaders().add("Content-Type", "application/json");
        exchange.sendResponseHeaders(200, response.length());
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }
}

