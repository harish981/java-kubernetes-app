package com.example;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

public class App {
    public static void main(String[] args) throws Exception {
        // Create an HTTP server listening on port 8080
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

        // Create a context for the root path ("/")
        server.createContext("/", new MyHandler());

        // Set the executor to null (use default executor)
        server.setExecutor(null);

        // Start the server
        server.start();
        System.out.println("Server started on port 8080");
    }

    // Handler for the root path
    static class MyHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange t) throws IOException {
            // Define the response message
            String response = "Hello from Java Kubernetes App!";

            // Send HTTP headers
            t.sendResponseHeaders(200, response.length());

            // Write the response to the output stream
            OutputStream os = t.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }
}
