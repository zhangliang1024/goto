package com.argument.constant;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @Auther: colin
 * @Date: 2018/12/11 17:09
 * @Description:
 * @Version: V1.0
 */
public enum DateFormatPattern {

    YYYY_MM_DD("yyyy-MM-dd"),
    YYYY_MM_DD_HH_MM_SS("yyyy-MM-dd hh:mm:ss");

    private String value;

    DateFormatPattern(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
