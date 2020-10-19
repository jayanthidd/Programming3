package org.campus02.zam.ss2020.practice.networks;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class ListenToClient {
    public static void main(String[] args) {
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        ServerSocket serverSocket = null; // server side.  1st to be initiated
        Socket connectionToClient = null; // client side

        try {
            serverSocket = new ServerSocket(9090); // server has created a socket in port number 9090 and is waiting for the client to accept it
            connectionToClient = serverSocket.accept(); // client has accepted the connection

            bufferedReader = new BufferedReader(new InputStreamReader(connectionToClient.getInputStream()));
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(connectionToClient.getOutputStream()));

            bufferedWriter.write("Hello");
            bufferedWriter.newLine();
            bufferedWriter.flush();

            String read;
            while ((read = bufferedReader.readLine())!=null){
                if (read.equals("TIME")){
                    Date d = new Date();
                    bufferedWriter.write(d.toString());
                    bufferedWriter.newLine();
                    bufferedWriter.flush();
                } else if (read.equals("PORT")){
                    bufferedWriter.write(connectionToClient.getPort());
                    bufferedWriter.newLine();
                    bufferedWriter.flush();
                }
                else if (read.equals("END")){
                    bufferedWriter.write("Bye");
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
                connectionToClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
