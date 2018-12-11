package com.design.factory.func;

import com.design.factory.Milk;
import com.design.factory.Telunsu;

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
