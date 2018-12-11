package com.design.factory.learn.func;

import com.design.factory.learn.domian.Mengniu;
import com.design.factory.learn.domian.Milk;

/**
 * @Auther: colin
 * @Date: 2018/12/11 10:52
 * @Description:
 * @Version: V1.0
 */
public class MengniuFactory implements Factory{

    @Override
    public Milk getMilk() {
        return new Mengniu();
    }
}
