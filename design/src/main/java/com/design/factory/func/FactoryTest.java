package com.design.factory.func;

/**
 * @Auther: colin
 * @Date: 2018/12/11 10:54
 * @Description:
 * @Version: V1.0
 */
public class FactoryTest {

    public static void main(String[] args) {
        Factory factory = new YiliFactory();
        Factory factory1 = new MengniuFactory();
        System.out.println(factory.getMilk().getName());
        System.out.println(factory1.getMilk().getName());
    }
}
