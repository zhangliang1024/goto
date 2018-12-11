package com.design.factory.learn.func;

import com.design.factory.learn.domian.Milk;
import com.design.factory.learn.domian.YiLi;

/**
 * @Auther: colin
 * @Date: 2018/12/11 10:52
 * @Description:
 * @Version: V1.0
 */
public class YiliFactory implements Factory {

    @Override
    public Milk getMilk() {
        return new YiLi();
    }
}
