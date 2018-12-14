package com.design.concurrent;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Auther: colin
 * @Date: 2018/12/13 19:55
 * @Description:
 * @Version: V1.0
 */
public class TestConcurrentHashMap {

    /**
     * counter.put(“stock1″, counter.get(“stock1″) + 1)并不是原子操作，
     * 并发容器保证的是单步操作的线程安全特性，这一点往往初级程序员特别容易忽视。
     */
    static Map<String, Integer> counter = new ConcurrentHashMap();

    public static void main(String[] args) throws InterruptedException {
        counter.put("stock1", 0);
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        CountDownLatch countDownLatch = new CountDownLatch(100);
        for (int i = 0; i < 100; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    counter.put("stock1", counter.get("stock1") + 1);
                    countDownLatch.countDown();
                }
            });
        }
        countDownLatch.await();
        System.out.println("result is " + counter.get("stock1"));
    }

}
