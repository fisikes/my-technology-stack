package fisikes.socket.server;

import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        String serverHostname = "localhost";
        int serverPort = 12345;
        String clientName = "客户端1"; // 唯一的客户端名称

        try (Socket socket = new Socket(serverHostname, serverPort);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))) {
            
            System.out.println("已连接到服务端");

            // 发送客户端名称
            out.println(clientName);

            String userInput;
            while ((userInput = stdIn.readLine()) != null) {
                out.println(userInput);
                System.out.println("服务端响应: " + in.readLine());
            }
        } catch (UnknownHostException e) {
            System.err.println("未知主机: " + serverHostname);
        } catch (IOException e) {
            System.err.println("I/O异常: " + e.getMessage());
        }
    }
}
