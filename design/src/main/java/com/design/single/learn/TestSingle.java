package com.design.single.learn;

import com.design.single.learn.method.EnumSingle;
import com.design.single.learn.method.HunSingle;
import com.design.single.learn.method.LaySingle;
import com.design.single.learn.method.Seriable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.concurrent.CountDownLatch;

/**
 * @Auther: colin
 * @Date: 2018/12/13 17:22
 * @Description:
 * @Version: V1.0
 */
public class TestSingle {

    /**
     * CountDownLatch ： 发令枪 计数器
     */
    public static void main(String[] args) {
        //testTime();
        testHugSingle();
        //testSeriable();
    }

    private static void testTime() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 200000000;i ++) {
            Object obj = HunSingle.getInstance();
        }
        long end = System.currentTimeMillis();
        System.out.println("总耗时：" + (end - start));
    }

    private static void testHugSingle() {
        int count = 500;
        CountDownLatch latch = new CountDownLatch(count);
        long start = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            new Thread(){
                @Override
                public void run() {
                    Object instance = LaySingle.getInstance();
                    System.out.println(System.currentTimeMillis()+":"+instance);
                    latch.countDown();
                }
            }.start();
            latch.countDown();
        }
        try {
            latch.await();
            System.out.println("开始计算总耗时");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("总耗时: "+ (end - start));

    }

    private static void testSeriable() {
        Seriable s1 = null;
        Seriable s2 = Seriable.getInstance();
        try{
            FileOutputStream fos = new FileOutputStream("json.obj");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(s2);
            oos.flush();
            oos.close();;

            FileInputStream fis = new FileInputStream("json.obj");
            ObjectInputStream ois = new ObjectInputStream(fis);
            s1 = (Seriable) ois.readObject();
            ois.close();

            System.out.println(s1 == s2);

        }catch (Exception e){
        
        }
    }
}
