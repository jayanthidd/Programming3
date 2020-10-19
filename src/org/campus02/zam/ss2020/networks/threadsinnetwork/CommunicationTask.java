package org.campus02.zam.ss2020.networks.threadsinnetwork;

import java.io.*;
import java.net.Socket;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class CommunicationTask implements Runnable {

    Socket connectiontoClient;

    public CommunicationTask(Socket connectiontoClient) {
        this.connectiontoClient = connectiontoClient;
    }

    @Override
    public void run() {
        Thread.currentThread().setName("Client Port : " + connectiontoClient.getPort());

        BufferedWriter bw;
        BufferedReader br;
        try {
            br = new BufferedReader(new InputStreamReader(connectiontoClient.getInputStream()));
            bw = new BufferedWriter(new OutputStreamWriter(connectiontoClient.getOutputStream()));

            bw.write("Hello");
            bw.newLine();
            bw.flush();

            String line;

            while((line = br.readLine())!=null) {
                if (line.equals("TIME")){
                    Calendar calendar = GregorianCalendar.getInstance();
                    bw.write(calendar.get(Calendar.HOUR_OF_DAY));
                    bw.write(" : ");
                    bw.write(calendar.get(Calendar.MINUTE));
                    bw.flush();
                    bw.newLine();
                } else if (line.equals("PORT")){
                    bw.write("Port : " + connectiontoClient.getPort());
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
        }
    }
}
