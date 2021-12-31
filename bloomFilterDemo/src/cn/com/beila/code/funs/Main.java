package cn.com.beila.code.funs;

import java.util.function.Function;

/**
 * @author wanbeila
 * @date 2021-09-10-16:02
 * @desc
 */
public class Main {

    public static void main(String[] args) {
        String a = "123";
        Function<String, Object> function = b -> b + "1";
        function.apply(a);
    }
}
