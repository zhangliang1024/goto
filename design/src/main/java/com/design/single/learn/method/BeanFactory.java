package com.design.single.learn.method;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Auther: colin
 * @Date: 2018/12/13 19:31
 * @Description: 示例IOC容器的 注册Bean的过程
 * @Version: V1.0
 */
public class BeanFactory {

    private BeanFactory(){}

    private static Map<String,Object> ioc = new ConcurrentHashMap<>();

    public static Object getBean(String name){
        if(!ioc.containsKey(name)){
            Object obj = null;
            try{
                obj = Class.forName(name).newInstance();
                ioc.put(name,obj);
            }catch (Exception e){
                e.printStackTrace();
            }
            return obj;
        }else{
            return ioc.get(name);
        }
    }
}
