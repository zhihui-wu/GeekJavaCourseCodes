package C02nio.t5;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer01 {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8801);
        while (true) {
            try{
                Socket socket = serverSocket.accept();
                service(socket);
            }catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private static void service(Socket socket) {
        System.out.println("HTTP: receive request");
        try {
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
            printWriter.println("HTTP/1.1 200 OK");
            printWriter.println("Content-Type:text/html;charset=utf-8");
            String body = "hello, nio1";
            printWriter.println("Context-Length:" + body.getBytes().length);
            printWriter.println("Connection:keep-alive");
            printWriter.println();
            printWriter.println(body);
            printWriter.println();
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
