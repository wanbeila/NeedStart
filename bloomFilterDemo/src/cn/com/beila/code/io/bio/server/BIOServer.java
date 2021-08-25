package cn.com.beila.code.io.bio.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author wanbeila
 * @date 2021-08-20-9:27
 * @desc
 */
public class BIOServer extends Thread {

    public BIOServer() {
        super();
    }

    public static void main(String[] args) throws IOException {
        Map<String, BIOHandler> clientMap = new ConcurrentHashMap<>();
        ServerSocket serverSocket = new ServerSocket(12345);
        while (true) {
            Socket accept = serverSocket.accept();
            String threadName = "bio-client-" + new Date();
            BIOHandler bioHandler = new BIOHandler(accept);
            clientMap.put(threadName, bioHandler);
            new Thread(bioHandler).start();
        }
    }
}
