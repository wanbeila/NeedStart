package com.beila;

import java.util.Scanner;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Main implements Runnable {

    private static final AtomicInteger poolNumber = new AtomicInteger(1);

    private String clientId = null;

    public Main(String clientId) {
        this.clientId = clientId;
    }

    public static void main(String[] args) {
        BlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(10000);
        ExecutorService executorService = new ThreadPoolExecutor(20, 20, 0L, TimeUnit.MILLISECONDS, queue, new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r, "test-thread-" + poolNumber.getAndAdd(1));
            }
        });
        Scanner scanner = new Scanner(System.in);
        for (int i = 0;i < 20;i ++) {
            String clientId;
            clientId = scanner.next();
            executorService.submit(new Main(clientId));
        }
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(Thread.currentThread().getName() +  "    clientId: " + clientId);
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }



}
