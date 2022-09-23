package net.client;

import net.utils.Noise;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    public static void main(String[] args){
        DataOutputStream dos = null;
        FileInputStream fis = null;
        Socket socket = null;
        try {
            try {
                socket = new Socket(InetAddress.getLocalHost(), 1234);

                dos = new DataOutputStream(socket.getOutputStream());
                Noise.addNoise("/Users/karmikfeels/IdeaProjects/tpzrp1/src/net/client/baji.jpeg",
                            "/Users/karmikfeels/IdeaProjects/tpzrp1/src/net/client/noise.jpeg");
                File file = new File("/Users/karmikfeels/IdeaProjects/tpzrp1/src/net/client/noise.jpeg");
                fis = new FileInputStream(file);

                byte[] sendBytes = new byte[1024];
                int length = 0;

                while ((length = fis.read(sendBytes, 0, sendBytes.length)) > 0) {
                    dos.write(sendBytes, 0, length);
                    dos.flush();
                }
            }
            finally {
                if (dos != null)
                    dos.close();
                if (fis != null)
                    fis.close();
                if (socket != null)
                    socket.close();
            }
        }
        catch(NullPointerException | IOException e){
                e.printStackTrace();
            }
        }
    }