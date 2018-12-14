package com.design.single.learn.method;

/**
 * @Auther: colin
 * @Date: 2018/12/13 17:53
 * @Description:
 * @Version: V1.0
 */
public class InSingle {

    /**
     * 饿汉式：在系统初始化时。就会完成对象的实例化；占用内存会多
     * 懒汉式：在需要使用到对象的时候才实例化对象。但懒汉式存在线程安全问题，需要使用Double+check来保证线程安全
     * 静态内部类：静态内部类与外部类没有从属关系。只有在发生调用的时候才会加载，加载的时候会进行实例化(有效实现懒加载)
     *            同步问题: 采用和饿汉式相同的 静态初始化器。借助JVM来实现线程安全。
     */
    private InSingle(){}

    private static class InInType{
        private static InSingle is = new InSingle();
    }

    /**
     * static使单例的空间共享，final保证这个方法不会被重写 覆盖
     */
    public static final InSingle getInstance(){
        return InInType.is;
    }
}
