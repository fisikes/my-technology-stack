package fisikes.socket;

import java.io.*;
import java.net.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SocketClient {

  public static void main(String[] args) {
    try {
      // Connect to the server
      final Socket socket = new Socket("localhost", 9999);
      log.info("Connected to server on port 9999.");

      // Create input and output streams for the client socket
      final BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
      PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

      // Send messages to the server
      output.println("Hello from client!");
      output.println("How are you?");

      // Receive responses from the server
      String response;
      while ((response = input.readLine()) != null) {
        System.out.println("Server: " + response);
      }

      // Close the connections
      input.close();
      output.close();
      socket.close();

    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
