package Nexus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {
//        System.out.println("Hello, HTTP NexusServer!");
//        try {
//            ServerSocket serverSocket = new ServerSocket(8080);
//            while (true)
//            {
//                Socket socket = serverSocket.accept();
//                InputStream inputReader = socket.getInputStream();
//                BufferedReader reader = new BufferedReader(new InputStreamReader(inputReader));
//                //Parsing the HTTP request
//                System.out.println(reader.readLine().split(" "));
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
        NexusServer server = new NexusServerImpl();
        server.start();
    }
}
