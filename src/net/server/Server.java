package net.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(1234)){
            System.out.println("Server started!");
            while (true){
                try {
                    Socket socket = server.accept();

                    if(socket.isConnected()){
                        System.out.println("is Connected +");
                    }

                    receiveFile(socket);

                    System.out.println("\n--------------------------------------------------------------\n");
                }
                catch (NullPointerException e){
                    e.printStackTrace();
                }
            }
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    public static void receiveFile(Socket socket) {
        byte[] inputByte = null;
        int length = 0;
        DataInputStream dis = null;
        FileOutputStream fos = null;
        Long timeName=System.currentTimeMillis();
        try {
            try {
                dis = new DataInputStream(socket.getInputStream());
                fos = new FileOutputStream(new File("/Users/karmikfeels/IdeaProjects/tpzrp1/src/net/server/"
                                                    +timeName+".jpeg"));
                inputByte = new byte[1024];
                System.out.println ("Loading...");
                while ((length = dis.read(inputByte, 0, inputByte.length)) > 0) {
                    System.out.println(length);
                    fos.write(inputByte, 0, length);
                    fos.flush();
                }
                System.out.println ("Finish");
            } finally {
                if (fos != null)
                    fos.close();
                if (dis != null)
                    dis.close();
                if (socket != null)
                    socket.close();
            }
        } catch (Exception e) {
        }
    }

}
