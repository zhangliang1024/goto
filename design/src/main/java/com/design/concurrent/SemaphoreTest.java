package com.design.concurrent;

import java.util.concurrent.Semaphore;

/**
 * @Auther: colin
 * @Date: 2018/12/14 10:18
 * @Description:
 * @Version: V1.0
 */
public class SemaphoreTest {

    /**
     * Semaphore: 翻译 信号量；
     *            可以控制同时访问的线程个数，通过acquire()获取一个许可，如果没有就等待。
     *            通过release()释放一个许可
     *★ Semaphore的构造函数：
     *public Semaphore(int permits) {//参数permits表示许可数目，即同时可以允许多少线程进行访问
     *     sync = new NonfairSync(permits);
     * }
     * public Semaphore(int permits, boolean fair) {//这个多了一个参数fair表示是否是公平的，即等待时间越久的越先获取许可
     *     sync = (fair)? new FairSync(permits) : new NonfairSync(permits);
     * }
     * ★ Semaphor 比较重要的几个方法：
     *      public void acquire() throws InterruptedException {  }     //获取一个许可
     *      public void acquire(int permits) throws InterruptedException { }    //获取permits个许可
     *      public void release() { }          //释放一个许可
     *      public void release(int permits) { }    //释放permits个许可
     *  acquire()用来获取一个许可，若无许可获得，则一直等待，直到获取许可
     *  release()用来释放许可；在许可释放之前必须先获得许可
     *
     * ★ Semaphore的构造函数：
     *      public boolean tryAcquire() { };    //尝试获取一个许可，若获取成功，则立即返回true，若获取失败，则立即返回false
     *      public boolean tryAcquire(long timeout, TimeUnit unit) throws InterruptedException { };  //尝试获取一个许可，若在指定的时间内获取成功，则立即返回true，否则则立即返回false
     *      public boolean tryAcquire(int permits) { }; //尝试获取permits个许可，若获取成功，则立即返回true，若获取失败，则立即返回false
     *      public boolean tryAcquire(int permits, long timeout, TimeUnit unit) throws InterruptedException { }; //尝试获取permits个许可，若在指定的时间内获取成功，则立即返回true，否则则立即返回false
     */
    // 示例：一个工厂有5台机器，8个工人。一台机器同时只能有一个工人使用，使用完了。其它人才可以继续使用
    public static void main(String[] args) {
        int count = 8;
        Semaphore semaphore = new Semaphore(5);
        System.out.println("当前许可个数："+semaphore.availablePermits());
        for (int i = 0; i < count; i++) {
            new Worker(i,semaphore).start();
        }
    }

    static class Worker extends Thread{
        private int num;
        private Semaphore semaphore;

        public Worker(int num,Semaphore semaphore){
            this.num = num;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();
                System.out.println("工人"+this.num+"占用一个机器生产...");
                Thread.sleep(2000);
                System.out.println("工人"+this.num+"释放出机器");
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
