package com.design.factory.abstr;

import com.design.factory.Milk;

/**
 * @Auther: colin
 * @Date: 2018/12/11 11:04
 * @Description: 抽象工厂
 *               抽象工厂是用户的主入口，是Spirng中应用最广泛的一种设计模式
 * @Version: V1.0
 */
public abstract class AbstractFactory {

    // 抽象工厂可以加入公共的逻辑，方便统一管理

    public abstract Milk getYili();


    public abstract Milk getMengniu();


    public abstract Milk getTelunsu();

}
