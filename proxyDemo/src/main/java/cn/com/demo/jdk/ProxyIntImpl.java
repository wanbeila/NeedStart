package cn.com.demo.jdk;

public class ProxyIntImpl implements ProxyInt {
    @Override
    public String saySomething() {
        System.out.println("the implemention of Proxy interface");
        return "impl";
    }
}
