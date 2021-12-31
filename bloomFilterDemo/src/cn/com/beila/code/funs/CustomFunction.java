package cn.com.beila.code.funs;

import java.util.function.Function;

/**
 * @author wanbeila
 * @date 2021-09-10-16:03
 * @desc
 */
public class CustomFunction implements Function<String, Object> {
    @Override
    public Object apply(String s) {
        return s;
    }
}
