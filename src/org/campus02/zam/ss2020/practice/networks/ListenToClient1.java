package org.campus02.zam.ss2020.practice.networks;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class ListenToClient1 {
    public static void main(String[] args) {
        // establish a connection - done
        // have 2 way communication
        ServerSocket serverSocket = null; //server side creates a socket with a port number
        Socket connection = null; // client side will have to accept the server socket to establish a connection
        BufferedWriter bufferedWriter = null;
        BufferedReader bufferedReader = null;

        try {
            serverSocket = new ServerSocket(9090); // Server socket has been created and the server is listening and waiting for the client to accept
            connection = serverSocket.accept();// client has accepted the server socket and a necooection has been established;

            bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream()));

            bufferedWriter.write("Hello, what would you like to know?");
            bufferedWriter.newLine();
            bufferedWriter.flush();

            String line;
            while ((line = bufferedReader.readLine())!=null){
                if(line.equals("START")){
                    bufferedWriter.write("Yes, we can start");
                    bufferedWriter.newLine();
                    bufferedWriter.flush();
                } else if (line.equals("TIME")){
                    Date d = new Date();
                    bufferedWriter.write(d.toString());
                    bufferedWriter.newLine();
                    bufferedWriter.flush();
                } else if (line.equals("END")){
                    bufferedWriter.write("Bye");
                    bufferedWriter.newLine();
                    bufferedWriter.flush();
                    break;
                } else {
                    bufferedWriter.write("Invalid Entry");
                    bufferedWriter.newLine();
                    bufferedWriter.flush();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
                bufferedWriter.close();
                serverSocket.close();
                connection.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
