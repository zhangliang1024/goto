package com.argument.controller;

import com.argument.annotation.RequestDateParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @Auther: colin
 * @Date: 2018/12/11 17:41
 * @Description:
 * @Version: V1.0
 */
@RestController
@RequestMapping("/arg")
public class ArgumentResolverController {

    @RequestMapping(value = "/date",method = RequestMethod.GET)
    public String getDate(@RequestDateParam Date date){
        System.out.println(date);
        return "success value is "+date;
    }

}
