package org.campus02.zam.ss2020.practice2.listentoclient;

import java.io.*;
import java.net.Socket;
import java.util.Date;

public class CommunicationTask implements Runnable {
    private Socket connection;

    public CommunicationTask(Socket connection) {
        this.connection = connection;
    }

    @Override
    public void run() {
        BufferedWriter bufferedWriter = null;
        BufferedReader br = null;

        try {
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream()));
            br = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            bufferedWriter.write("Hello from Port no. : " + connection.getPort());
            bufferedWriter.newLine();
            bufferedWriter.flush();

            String input;
            while ((input = br.readLine())!=null){
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
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedWriter.close();
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
