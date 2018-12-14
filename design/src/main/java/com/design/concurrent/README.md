在java 1.5中，提供了一些非常有用的辅助类来帮助我们进行并发编程，
比如CountDownLatch，CyclicBarrier和Semaphore                  
[Java并发编程：CountDownLatch、CyclicBarrier和 Semaphore](http://www.importnew.com/21889.html)

以下是本文目录大纲：
一.CountDownLatch用法
二.CyclicBarrier用法
三.Semaphore用法

CountDownLatch类位于java.util.concurrent包下，利用它可以实现类似计数器的功能。
比如有一个任务A，它要等待其他4个任务执行完毕之后才能执行，此时就可以利用CountDownLatch来实现这种功能了。

```properties
CountDownLatch类只提供了一个构造器：
public CountDownLatch(int count) {  };  //参数count为计数值
然后下面这3个方法是CountDownLatch类中最重要的方法：

public void await() throws InterruptedException { };   
//调用await()方法的线程会被挂起，它会等待直到count值为0才继续执行
public boolean await(long timeout, TimeUnit unit) throws InterruptedException { };  
//和await()类似，只不过等待一定的时间后count值还没变为0的话就会继续执行
public void countDown() { };  //将count值减1
```

```properties
public Semaphore(int permits) {          //参数permits表示许可数目，即同时可以允许多少线程进行访问
    sync = new NonfairSync(permits);
}
public Semaphore(int permits, boolean fair) {    //这个多了一个参数fair表示是否是公平的，即等待时间越久的越先获取许可
    sync = (fair)? new FairSync(permits) : new NonfairSync(permits);
}
```

### 总结
> CountDownLatch和CyclicBarrier 都可以实现线程之间的等待，只不过他们侧重点不同               
> CountDowanLatch 一般用于某个线程A 等待若干个其它线程执行完后，才执行                     
> CyclicBarrier 一组线程相互等待至某个状态， 然后这一组线程再同时执行                 
> CountDownLatch 是不可以重用的，CyclicBarrier是可以重用的；                
> Semaphore 其实和锁有点类似，一般用于控制对某组资源的权限                 