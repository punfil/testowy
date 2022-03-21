package pl.edu.pg.student.testowy;

import java.net.*;
import java.io.*;

public class Server {
    public static void main(String[] args) throws IOException {
        int portNumber = 4444;

        try (ServerSocket serverSocket = new ServerSocket(portNumber)) {
            while (true) {
                new Thread(new ServerThread(serverSocket.accept())).start();
            }
        } catch (IOException e) {
            System.err.println("Could not listen on port " + portNumber);
            System.exit(-1);
        }
    }
}
