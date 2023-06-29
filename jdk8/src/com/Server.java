package com;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(9000);
        while(true){
            Socket server = serverSocket.accept();
            InputStream inputStream = server.getInputStream();
            OutputStream outputStream = server.getOutputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            String s ;
            while((s = br.readLine())!=null){
                if("CLOSE".equals(s)){
                    outputStream.write("连接已经断开".getBytes());
                    return;
                }else{
                    String[] split = s.split("\\|");
                    System.out.println(split[1]+split[2]);
                }
            }
        }


    }

}
