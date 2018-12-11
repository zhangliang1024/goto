package com.design.factory.learn.abstr;

import com.design.factory.learn.domian.Mengniu;
import com.design.factory.learn.domian.Milk;
import com.design.factory.learn.domian.Telunsu;
import com.design.factory.learn.domian.YiLi;

/**
 * @Auther: colin
 * @Date: 2018/12/11 11:07
 * @Description: 统一工厂
 * @Version: V1.0
 */
public class MilkFactory extends AbstractFactory {

    @Override
    public Milk getYili() {
        return new YiLi();
    }

    @Override
    public Milk getMengniu() {
        return new Mengniu();
    }

    @Override
    public Milk getTelunsu() {
        return new Telunsu();
    }
}
