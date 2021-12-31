package cn.com.demo.jdk;

import sun.misc.ProxyGenerator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Main {

    public static void main(String[] args) throws IOException {
        final ProxyInt proxy = (ProxyInt) Proxy.newProxyInstance(Main.class.getClassLoader(), new Class[]{ProxyInt.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                ProxyIntImpl im = new ProxyIntImpl();
                final Object value = method.invoke(im, args);
                return value;
            }
        });
        proxy.saySomething();


        // jdk 代理的核心方法，生成代理类
        byte[] proxyClassFile = ProxyGenerator.generateProxyClass(
                "ProxyIntImpl", new Class[]{ProxyInt.class});
        File proxyClass = new File("ProxyIntImpl.class");
        FileOutputStream fos = new FileOutputStream(proxyClass);
        fos.write(proxyClassFile);
        fos.close();
    }
}
