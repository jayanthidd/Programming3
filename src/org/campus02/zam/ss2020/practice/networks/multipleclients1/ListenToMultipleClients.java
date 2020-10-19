package org.campus02.zam.ss2020.practice.networks.multipleclients1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.concurrent.TimeoutException;

public class ListenToMultipleClients {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket connection = null;

        ArrayList<Thread> threads = new ArrayList<>(); // this is declared outside the try catch block, so that we can access all the threads to join them.
        try {
            serverSocket = new ServerSocket(9090);
            serverSocket.setSoTimeout(30000);
            while (true) {
                try {
                    connection = serverSocket.accept();
                    CommunicationTask communicationTask = new CommunicationTask(connection);

                    // Multiple clients can communicate with Multithreading.  This means that multiple threads should be created
                    Thread t = new Thread(communicationTask);
                    t.start();
                    threads.add(t);
                } catch (SocketTimeoutException ex){// this exception needs to be caught mannually to help break from the loop
                    System.out.println("Server has timed out");
                    break;// this break command is important
                }
            }
            for(Thread t : threads){  // we want to wait for all threads to complete.
                try {
                    t.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Server connection closed");// this message is printed only when all communication channels are ended

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                serverSocket.close();
                connection.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
