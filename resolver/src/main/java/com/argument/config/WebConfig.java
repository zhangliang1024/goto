package com.argument.config;

import com.argument.resolver.ArgumentResolver;
import com.argument.resolver.HMArgumentResolver;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

/**
 * @Auther: colin
 * @Date: 2018/12/11 17:16
 * @Description:
 * @Version: V1.0
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private HMArgumentResolver hmArgumentResolver;
    @Autowired
    private ArgumentResolver argumentResolver;
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> list) {
        list.add(argumentResolver);
    }
}
