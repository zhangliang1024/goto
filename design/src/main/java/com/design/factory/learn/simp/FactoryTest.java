package com.design.factory.learn.simp;

/**
 * @Auther: colin
 * @Date: 2018/12/11 10:38
 * @Description:
 * @Version: V1.0
 */
public class FactoryTest {

    public static void main(String[] args) {
        //Milk milk = new YiLi();
        //Milk milk1 = new Mengniu();
        //System.out.println(milk.getName());
        //System.out.println(milk1.getName());

        System.out.println(new SimpleFactory().getMilk("伊利"));

    }
}
