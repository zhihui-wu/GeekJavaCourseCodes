package C02nio.t5;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer02 {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8802);
        while (true) {
            try{
                Socket socket = serverSocket.accept();
                new Thread(()->{
                    service(socket);
                }).start();
            }catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private static void service(Socket socket) {
        try {
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
            printWriter.println("HTTP/1.1 200 OK");
            printWriter.println("Content-Type:text/html;charset=utf-8");
            String body = "hello, nio2";
            printWriter.println("Context-Length:" + body.getBytes().length);
            printWriter.println();
            printWriter.println(body);
            printWriter.println();
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
