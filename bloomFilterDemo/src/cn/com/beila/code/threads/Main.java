package cn.com.beila.code.threads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author wanbeila
 * @date 2021-09-16-9:57
 * @desc
 */
public class Main {

    static class Demo implements Callable {

        @Override
        public Object call() throws Exception {
            return "demo callable";
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable callable = new Demo();
        FutureTask futureTask = new FutureTask<>(callable);
        Thread thread = new Thread(futureTask);
        thread.start();
        System.out.println(futureTask.get());
    }
}
