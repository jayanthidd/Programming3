package org.campus02.zam.ss2020.practice.networks.multipleclients;

import java.io.*;
import java.net.Socket;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class CommunicationTask implements Runnable{
    Socket connectionToClient;

    public CommunicationTask(Socket connectionToClient) {
        this.connectionToClient = connectionToClient;
    }

    @Override
    public void run() {
        Thread.currentThread().setName("Client Port : " + connectionToClient.getPort());

        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;

        try {
            bufferedReader = new BufferedReader(new InputStreamReader(connectionToClient.getInputStream()));
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(connectionToClient.getOutputStream()));

            bufferedWriter.write("Hello from : " + connectionToClient.getPort());
            bufferedWriter.newLine();
            bufferedWriter.flush();

            String line;
            while ((line = bufferedReader.readLine())!=null){
                if (line.equals("TIME")){
                    Date d = new Date();
                    bufferedWriter.write(d.toString());
                    bufferedWriter.newLine();
                    bufferedWriter.flush();
                } else if (line.equals("END")){
                    bufferedWriter.write("Bye");
                    bufferedWriter.newLine();
                    bufferedWriter.flush();
                    break;
                }
                Thread.sleep(1000);
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
