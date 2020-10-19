package org.campus02.zam.ss2020.practice.networks.multipleclients1;

import java.io.*;
import java.net.Socket;
import java.util.Date;

public class CommunicationTask implements Runnable {
    Socket connection;

    public CommunicationTask(Socket connection) {
        this.connection = connection;
    }

    @Override
    public void run() {
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;

        try {
            bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream()));

            bufferedWriter.write("Hello from the other side : " + connection.getPort());
            bufferedWriter.newLine();
            bufferedWriter.flush();

            String line;
            while((line = bufferedReader.readLine())!=null){
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
                } else {
                    bufferedWriter.write("Invalid Entry");
                    bufferedWriter.newLine();
                    bufferedWriter.flush();
                }
//                try {
//                    Thread.sleep(1000);                        // so this apparently did nothing
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }

        } catch (IOException e) {
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
