package cn.com.beila.code;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>(1);
        System.out.println(map.size());
        map.put("test", "1");
        System.out.println(map.size());
    }
}
