import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.net.InetSocketAddress;


//Creates an HttpServer instance that listens on port 8000.
// Defines a FileHandler class that handles HTTP requests. It serves files from the specified directory.
// Starts the server and listens for incoming connections.

public class SimpleFileServer {
    public static void main(String[] args) throws IOException {
        // Set the directory you want to serve
        String directoryToServe = "."; // Current directory

        // Create an HttpServer instance listening on port 8000
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);

        // Create a context to handle requests to the root directory
        server.createContext("/", new FileHandler(directoryToServe));

        // Start the server
        server.setExecutor(null); // Use the default executor
        server.start();

        System.out.println("Server started on port 8000. Serving files from " + directoryToServe);
    }

    static class FileHandler implements HttpHandler {
        private final Path basePath;

        public FileHandler(String directoryToServe) {
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
}
