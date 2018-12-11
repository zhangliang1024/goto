package com.design.factory.learn.func;

import com.design.factory.learn.domian.Milk;
import com.design.factory.learn.domian.Telunsu;

/**
 * @Auther: colin
 * @Date: 2018/12/11 10:53
 * @Description:
 * @Version: V1.0
 */
public class TelunsuFactory implements Factory{

    @Override
    public Milk getMilk() {
        return new Telunsu();
    }
}
