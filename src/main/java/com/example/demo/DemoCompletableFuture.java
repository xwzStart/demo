package com.example.demo;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * 外派一个可能阻塞的任务，另外执行，自己先执行其他任务，后面再get回任务结果
 */
public class DemoCompletableFuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//没有返回值的runAsync 异步回调
        CompletableFuture<Void> completableFuture1 = CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ".runAsync==>void");
        });
        System.out.println("11111");
        CompletableFuture.allOf(completableFuture1).get();//获取阻塞执行结果
    }
}
