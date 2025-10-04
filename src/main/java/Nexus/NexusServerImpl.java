package Nexus;

import Nexus.NexusLogger.NexusLogger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class NexusServerImpl implements NexusServer{
    private static NexusLogger LOGGER = NexusLogger.getNexusLogger();
    private int port;
    public NexusServerImpl() {
        this.port = 8080;
    }
    public NexusServerImpl(int port) {
        this.port = port;
    }
    @Override
    public void start() {
        // Createing Server Socket and listening on the port
        try {
            ServerSocket nexusServerSocket = new ServerSocket(this.port);
            LOGGER.log("Nexus Server started on port: " + this.port);
            while (true)
            {
                //Accepting the incomming client connection
                Socket nexusClientSocket = nexusServerSocket.accept();
                LOGGER.log("Nexus Server accepted connection from: " + nexusClientSocket.getInetAddress());
                // Fetching the input stream
                InputStream inputStream = nexusClientSocket.getInputStream();
                // Converting to Buffered Reader
                BufferedReader httpRequestReader = new BufferedReader(new InputStreamReader(inputStream));
                //Parsing the HTTP request
                LOGGER.log(httpRequestReader.readLine());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
