package com.design.single.learn.method;

/**
 * @Auther: colin
 * @Date: 2018/12/13 17:23
 * @Description:
 * @Version: V1.0
 */
public class HunSingle {

    /**
     * 饿汉式，在系统初始化时。就会完成对象的实例化；占用内存会多
     *
     * ★ ★ ★ 反序列化时，会导致单例被破坏；
     *
     * 序列化：把内存中的状态通过转换成字节码的形式，从而转换成一个IO流，写入到其它地方(磁盘或者网络IO)，把内存中的状态永久的保存下来
     * 反序列化：将已经持久化的字节码内容，转换为IO流读取，进而将读取的内容转换为java对象，在转换过程中会重新创建对象。
     */
    private HunSingle(){}

    private static final HunSingle INSTANCE = new HunSingle();

    public static HunSingle getInstance(){
        return INSTANCE;
    }


}
