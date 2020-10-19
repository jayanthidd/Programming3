package org.campus02.zam.ss2020.networks.readingfromurl;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class ListenToClient {
    public static void main(String[] args) {
        BufferedReader br = null;
        BufferedWriter bw = null;
        ServerSocket serverSocket = null;
        Socket connectionToClient = null;

        try {
            System.out.println("Waiting for incoming connection...");
            serverSocket = new ServerSocket(9090);
            connectionToClient = serverSocket.accept();

            br = new BufferedReader(new InputStreamReader(connectionToClient.getInputStream()));

            bw = new BufferedWriter(new OutputStreamWriter(connectionToClient.getOutputStream()));

            bw.write("Hello");
            bw.newLine();
            bw.flush();

            String line;
            while((line = br.readLine())!=null) {
                if (line.equals("TIME")){
                    Date d = new Date();
                    bw.write(d.toString());
                    bw.newLine();
                    bw.flush();
                } else if (line.equals("PORT")){
                    bw.write("Port : " + connectionToClient.getPort());
                    bw.newLine();
                    bw.flush();
                }
                else if(line.equals("END")){
                    bw.write("Bye");
                    bw.newLine();
                    bw.flush();
                    break;
                } else {
                    bw.write("Unknown Command");
                    bw.newLine();
                    bw.flush();
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            try {
                br.close();
                bw.close();
                connectionToClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
