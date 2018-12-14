package com.design.single.learn.method;

/**
 * @Auther: colin
 * @Date: 2018/12/13 17:24
 * @Description:
 * @Version: V1.0
 */
public class LaySingle {

    private LaySingle(){}

    private static LaySingle ls = null;

    /**
     * 懒汉式 单例模式存在线程安全问题：所以这里加 synchronized来控制
     * @return
     */
    public static synchronized LaySingle getInstance(){
        if(ls == null){
            ls = new LaySingle();
        }
        return  ls;
    }
}

class LayTwoSingle {

    private LayTwoSingle(){}

    /**
     *  volatile 保证多线程之间的可见性
     *           被其所修饰的变量的值不会被本地线程缓存，
     *           所有对该变量的读写都是直接操作共享内存来实现，从而确保多个线程能正确的处理该变量。
     */

    private static volatile LayTwoSingle ls = null;

    /**
     * 懒汉式 synchronized来控制,锁的粒度太大，性能不是很好。
     *       使用双重锁机制来实现：锁的粒度更细，性能更好
     */
    public static LayTwoSingle getInstance(){
        if(ls == null){
            synchronized(LayTwoSingle.class){
                if(ls == null){
                    ls = new LayTwoSingle();
                }
            }
        }
        return  ls;
    }
}
