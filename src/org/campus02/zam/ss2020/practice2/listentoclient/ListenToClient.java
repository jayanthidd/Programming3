package org.campus02.zam.ss2020.practice2.listentoclient;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class ListenToClient {

    public static void main(String[] args) {
        ServerSocket server = null;
        Socket connection = null;
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;

        try {
            server = new ServerSocket(9090);
            connection = server.accept();

            bufferedWriter = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream()));
            bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            bufferedWriter.write("Hello, what would you like to do?");
            bufferedWriter.newLine();
            bufferedWriter.flush();

            String input;

            while ((input = bufferedReader.readLine())!=null){
                if (input.equals("TIME")){
                    Date d = new Date();
                    bufferedWriter.write(d.toString());
                    bufferedWriter.newLine();
                    bufferedWriter.flush();
                } else if (input.equals("PORT")){
                    bufferedWriter.write("Port number is : " + connection.getPort());
                    bufferedWriter.newLine();
                    bufferedWriter.flush();
                } else if (input.equals("END")){
                    bufferedWriter.write("Bye");
                    bufferedWriter.newLine();
                    bufferedWriter.flush();
                    break;
                } else {
                    bufferedWriter.write("Invalid Entry! TRy again!");
                    bufferedWriter.newLine();
                    bufferedWriter.flush();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedWriter.close();
                bufferedReader.close();
                server.close();
                connection.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
