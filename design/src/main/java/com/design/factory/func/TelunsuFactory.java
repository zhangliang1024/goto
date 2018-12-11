package com.design.factory.func;

import com.design.factory.domian.Milk;
import com.design.factory.domian.Telunsu;

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
