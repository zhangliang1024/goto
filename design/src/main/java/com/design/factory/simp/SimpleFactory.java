package com.design.factory.simp;

import com.design.factory.Mengniu;
import com.design.factory.Milk;
import com.design.factory.Telunsu;
import com.design.factory.YiLi;

/**
 * @Auther: colin
 * @Date: 2018/12/11 10:43
 * @Description: 小作坊式的工厂模型
 *                把用户的需求告诉工厂，工厂把创建产品的过程对用户 影藏
 * @Version: V1.0
 */
public class SimpleFactory {

    public Milk getMilk(String name){
        if("伊利".equals(name)){
            return new YiLi();
        }else if("蒙牛".equals(name)){
            return new Mengniu();
        }else if("特仑苏".equals(name)){
            return new Telunsu();
        }else {
            System.out.println("不能生产所需的产品");
            return null;
        }
    }
}
