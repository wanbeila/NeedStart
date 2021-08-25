package cn.com.beila.code.proxy;

import java.io.IOException;
import java.net.*;

/**
 * @author wanbeila
 * @date 2021-08-20-13:01
 * @desc
 */
public class LFProxy {

    public static void main(String[] args) {
        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("10.43.93.163", 1080));
        try {
            URLConnection httpCon = new URL("http://www.baidu.com").openConnection(proxy);
            httpCon.setConnectTimeout(5000);
            httpCon.setReadTimeout(5000);
            int code = ((HttpURLConnection)httpCon).getResponseCode();
            System.out.println(code);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
