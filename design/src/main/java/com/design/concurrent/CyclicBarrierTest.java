package com.design.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Auther: colin
 * @Date: 2018/12/13 20:13
 * @Description:
 * @Version: V1.0
 */
public class CyclicBarrierTest {

    /**
     * CyclicBarrier: 回环栅栏
     *                它可以实现让一组线程等待至某个状态后在全部同时执行。它在所有等待线程释放后，可以重用；
     * CyclicBarrier有2个构造函数:
     * public CyclicBarrier(int parties, Runnable barrierAction) {
     * } //参数barrierAction 为当这些线程都达到barrier状态时会执行的内容
     * public CyclicBarrier(int parties) {
     * } //参数parties指让多少个线程或者任务等待至barrier状态
     *
     */

    public static void main(String[] args) {
        int count = 4;
        CyclicBarrier barrier = new CyclicBarrier(count, new Runnable() {
            @Override
            public void run() {
                System.out.println("当前前程"+Thread.currentThread().getName());
            }
        });

        for (int i = 0; i < count; i++) {
            new Writer(barrier).start();
        }
    }

    static class Writer extends Thread{
        private CyclicBarrier barrier;
        public Writer(CyclicBarrier barrier){
            this.barrier = barrier;
        }

        @Override
        public void run() {
            System.out.println("线程"+Thread.currentThread().getName()+"正在写入数据...");
            try {
                Thread.sleep(5000); // 用睡眠来模拟写入操作
                System.out.println("线程"+Thread.currentThread().getName()+"写入数据完毕，等待其他线程写入完毕");
                barrier.await();;
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch(BrokenBarrierException e){
                e.printStackTrace();
            }
            System.out.println("所有线程写入完毕，继续执行其它任务...");
        }
    }
}
