package org.campus02.zam.ss2020.practice2.listentoclient;

import java.io.BufferedWriter;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.ArrayList;

public class ListenToMultipleClients {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket connection = null;

        try {
            serverSocket = new ServerSocket(9090);
            serverSocket.setSoTimeout(30000);
            ArrayList<Thread> threads = new ArrayList<>();
            System.out.println("Server has started");

            while (true) {
                try{
                    connection = serverSocket.accept();
                    CommunicationTask communicationTask = new CommunicationTask(connection);
                    Thread t = new Thread(communicationTask);
                    t.start();
                    threads.add(t);
                } catch (SocketTimeoutException ex){
                    System.out.println("Server has timed out!");
                    break;
                }
            }
            for (Thread t : threads){
                t.join();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            try {
                if (serverSocket!=null) {
                    serverSocket.close();
                }
                if (connection!=null) {
                    connection.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("All communication tasks have completed");
    }
}
