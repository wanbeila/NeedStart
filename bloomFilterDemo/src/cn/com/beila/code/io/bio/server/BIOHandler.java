package cn.com.beila.code.io.bio.server;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.nio.ByteBuffer;

/**
 * @author wanbeila
 * @date 2021-08-20-17:12
 * @desc
 */
public class BIOHandler implements Runnable{

    private Socket socket;

    public BIOHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        while (socket != null && !socket.isClosed()) {
            if (socket.isConnected()) {
                try {
                    InputStream inputStream = socket.getInputStream();
                    BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
                    while (bufferedInputStream.available() > 0) {
                        byte[] bytes = new byte[1024];
                        int len = -1;
                        StringBuffer stringBuffer = new StringBuffer();
                        while ((len = bufferedInputStream.read(bytes)) != -1) {
                            stringBuffer.append(new String(bytes, 0 ,len));
                        }
                        System.out.println("received: " + stringBuffer.toString());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
