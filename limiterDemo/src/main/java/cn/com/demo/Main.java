package cn.com.demo;

import com.google.common.util.concurrent.RateLimiter;

public class Main implements Runnable {

    static RateLimiter rateLimiter = RateLimiter.create(10000);

    static int count = 0;

    public static void main(String[] args) {
        for (int i = 0;i < 500000;i ++) {
            new Thread(new Main()).start();
        }
    }

    @Override
    public void run() {
//            boolean b = rateLimiter.tryAcquire(1);
//            while (!b) {
//                b = rateLimiter.tryAcquire(1);
//            }

            System.out.print("bbb " + Thread.currentThread().getName() + ": ");
            count ++;
            System.out.println(count);
    }
}
