package com.design.factory.learn.domian;

import lombok.Data;

/**
 * @Auther: colin
 * @Date: 2018/12/11 10:37
 * @Description:
 * @Version: V1.0
 */
public class Telunsu implements Milk {

    @Override
    public String getName() {
        return "特仑苏";
    }
}
