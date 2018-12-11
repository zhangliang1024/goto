package com.design.factory.learn.abstr;

/**
 * @Auther: colin
 * @Date: 2018/12/11 11:08
 * @Description:
 * @Version: V1.0
 */
public class AbstractFactoryTest {

    public static void main(String[] args) {
        // 对调用者而言，只有选择的权力，保证了程序的健壮性
        MilkFactory factory = new MilkFactory();
        System.out.println(factory.getMengniu().getName());


    }
}
