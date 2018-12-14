package com.design.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @Auther: colin
 * @Date: 2018/12/13 20:13
 * @Description:
 * @Version: V1.0
 */
public class CyclicBarrierTestTwo {

    /**
     * CyclicBarrier: 回环栅栏
     *                它可以实现让一组线程等待至某个状态后在全部同时执行。它在所有等待线程释放后，可以重用；
     * CyclicBarrier有2个构造函数:
     * public CyclicBarrier(int parties, Runnable barrierAction) {
     * } //参数barrierAction 为当这些线程都达到barrier状态时会执行的内容
     * public CyclicBarrier(int parties) {
     * } //参数parties指让多少个线程或者任务等待至barrier状态
     *
     * CyclicBarrier有2个await()方法:
     * public int await() throws InterruptedException, BrokenBarrierException { };
     * public int await(long timeout, TimeUnit unit)throws InterruptedException,BrokenBarrierException,TimeoutException { };
     * 第一个版本比较常用，用来挂起当前线程，直至所有线程都到达barrier状态再同时执行后续任务；
     * 第二个版本是让这些线程等待至一定的时间，如果还有线程没有到达barrier状态就直接让到达barrier的线程执行后续任务。
     */

    public static void main(String[] args) {
        int count = 4;
        CyclicBarrier barrier = new CyclicBarrier(count);

        for (int i = 0; i < count; i++) {
            if(i < count -1){
                new Writer(barrier).start();
            }else{
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                new Writer(barrier).start();
            }
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
                barrier.await(2000, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch(BrokenBarrierException e){
                e.printStackTrace();
            } catch (TimeoutException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"线程写入完毕，继续执行其它任务...");
        }
    }
}
