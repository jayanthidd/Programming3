package org.campus02.zam.ss2020.practice.networks.multipleclients;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.ArrayList;

public class ListenToMultipleClients {
    public static void main(String[] args) {

        ServerSocket serverSocket = null;
        Socket connectionToClient = null;

        ArrayList<Thread> clients = new ArrayList<>();

        try {
            System.out.println("Server has started");
            serverSocket = new ServerSocket(9090);

            serverSocket.setSoTimeout(30000);

            while (true){
                try {
                    connectionToClient = serverSocket.accept();
                    CommunicationTask communicationTask = new CommunicationTask(connectionToClient);

                    Thread t = new Thread(communicationTask);
                    t.start();

                    clients.add(t);

                } catch (SocketTimeoutException ex){
                    System.out.println("Timeout");
                    break;
                }
            }
            for (Thread t : clients){
                t.join();
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            try {
                serverSocket.close();
                connectionToClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Server has closed connection");
    }
}
