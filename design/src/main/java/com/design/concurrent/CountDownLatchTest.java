package com.design.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * @Auther: colin
 * @Date: 2018/12/13 19:57
 * @Description:
 * @Version: V1.0
 */
public class CountDownLatchTest {


    /**
     * CountDownLatch
     *
     */
    public static void main(String[] args) {
        int count  = 2;
        final CountDownLatch latch = new CountDownLatch(count);

        new Thread("A"){
            public void run() {
                try {
                    System.out.println("子线程"+Thread.currentThread().getName()+"正在执行");
                    Thread.sleep(3000);
                    System.out.println("子线程"+Thread.currentThread().getName()+"执行完毕");
                    latch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };
        }.start();

        new Thread("B"){
            public void run() {
                try {
                    System.out.println("子线程"+Thread.currentThread().getName()+"正在执行");
                    Thread.sleep(3000);
                    System.out.println("子线程"+Thread.currentThread().getName()+"执行完毕");
                    latch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };
        }.start();

        try {
            System.out.println("等待2个子线程执行完毕...");
            latch.await();
            System.out.println("2个子线程已经执行完毕");
            System.out.println("继续执行主线程");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

}
