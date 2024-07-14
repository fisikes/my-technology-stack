package fisikes.socket;

import java.io.*;
import java.net.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SocketServ {

  private static final Logger log = LoggerFactory.getLogger(SocketServ.class);

  public static void main(String[] args) {
    try {
      // Create a server socket listening on port 9999
      final ServerSocket serverSocket = new ServerSocket(9999);

      log.info("Server listening on port 9999");

      // Wait for a client to connect
      final Socket clientSocket = serverSocket.accept();
      log.info("Client connected");

      // Create input and output streams for the client socket
      final BufferedReader input = new BufferedReader(
          new InputStreamReader(clientSocket.getInputStream()));
      final PrintWriter output = new PrintWriter(clientSocket.getOutputStream(), true);

      // Read from and write to the client
      String line;
      while ((line = input.readLine()) != null) {
        log.info("Client: {}", line);

        output.println("Server echo:" + line);
      }

      // Close the connections
      input.close();
      output.close();
      clientSocket.close();
      serverSocket.close();

    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
