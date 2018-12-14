package com.design.single.learn.method;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Auther: colin
 * @Date: 2018/12/13 19:21
 * @Description:  注册登记方式
 * @Version: V1.0
 */
public class RegisterMap {

    /**
     * 注册登记式: 是spring中IOC的 实现方式
     */
    private RegisterMap(){}

    private static Map<String,Object> register = new ConcurrentHashMap<>();

    public static RegisterMap getInstance(String name){
        if(name == null){
            name = RegisterMap.class.getName();
        }
        if(register.get(name) == null){
            try{
                register.put(name,new RegisterMap());
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return (RegisterMap) register.get(name);
    }

}
