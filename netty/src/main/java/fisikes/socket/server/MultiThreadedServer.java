package fisikes.socket.server;

import java.io.*;
import java.net.*;
import java.util.concurrent.ConcurrentHashMap;

public class MultiThreadedServer {
    private static ConcurrentHashMap<String, Socket> clients = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(12345)) {
            System.out.println("服务端已启动，等待客户端连接...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                new ClientHandler(clientSocket).start();
            }
        } catch (IOException e) {
            System.err.println("服务端异常: " + e.getMessage());
        }
    }

    private static class ClientHandler extends Thread {
        private Socket clientSocket;
        private String clientName;

        public ClientHandler(Socket socket) {
            this.clientSocket = socket;
        }

        public void run() {
            try (PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                 BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

                // 读取客户端名称
                clientName = in.readLine();
                if (clientName == null || clientName.isEmpty()) {
                    clientName = "未知客户端";
                }
                System.out.println("客户端连接: " + clientName);
                clients.put(clientName, clientSocket);

                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    System.out.println("接收到 " + clientName + " 的消息: " + inputLine);
                    out.println("服务端响应: " + inputLine);
                }
            } catch (IOException e) {
                System.err.println("客户端处理异常: " + e.getMessage());
            } finally {
                try {
                    clientSocket.close();
                    clients.remove(clientName);
                    System.out.println("客户端断开: " + clientName);
                } catch (IOException e) {
                    System.err.println("无法关闭客户端连接: " + e.getMessage());
                }
            }
        }
    }
}
