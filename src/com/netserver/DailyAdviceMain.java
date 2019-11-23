package com.netserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class DailyAdviceMain {

    public void go(){
        try {
            Socket socket = new Socket("127.0.0.1", 4242);

            InputStreamReader streamReader = new InputStreamReader(socket.getInputStream());
            BufferedReader br = new BufferedReader(streamReader);

            String advice = br.readLine();
            System.out.println("Today u need to " + advice);
            br.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new DailyAdviceMain().go();
        DailyAdviceServer d = new DailyAdviceServer();
        d.go();


    }
}
