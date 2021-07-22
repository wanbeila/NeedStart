package cn.com.beila.code;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        // 往内存中不断写入
        List<Object> list = new ArrayList<>();
        while (true) {
            char[] tmp = new char[1024];
            list.add(tmp);
            Thread.sleep(5);
        }
    }
}
