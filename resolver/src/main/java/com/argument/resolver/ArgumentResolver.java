package com.argument.resolver;

import com.argument.annotation.RequestDateParam;
import com.argument.constant.DateFormatPattern;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.annotation.AbstractNamedValueMethodArgumentResolver;

import java.text.SimpleDateFormat;

/**
 * @Auther: colin
 * @Date: 2018/12/11 17:18
 * @Description:
 * @Version: V1.0
 */
@Component
public class ArgumentResolver extends  AbstractNamedValueMethodArgumentResolver {

    //@Override
    //public boolean supportsParameter(MethodParameter parameter) {
    //    RequestDateParam dateParam = (RequestDateParam)parameter.getParameterAnnotation(RequestDateParam.class);
    //    return new NamedValueInfo(dateParam.value(),dateParam.required(),(String)null);
    //}

    //@Override
    //public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
    //    return null;
    //}

    /**
     * 获取当前参数的注解
     * @param parameter 需要被解析的Controller参数
     */
    @Override
    protected NamedValueInfo createNamedValueInfo(MethodParameter parameter) {
        RequestDateParam dateParam = parameter.getParameterAnnotation(RequestDateParam.class);
        return new NamedValueInfo(dateParam.value(),dateParam.required(),(String)null);
    }

    /**
     * 在这里进行参数类型的转换
     * @param s
     * @param parameter  需要被解析的Controller参数
     * @param nativeWebRequest 当前request
     */
    @Override
    protected Object resolveName(String s, MethodParameter parameter, NativeWebRequest nativeWebRequest) throws Exception {
        String value = nativeWebRequest.getParameter(s);
        if(value == null){
            return null;
        }else{
            try {
                RequestDateParam annotation = parameter.getParameterAnnotation(RequestDateParam.class);
                SimpleDateFormat dateFormat = new SimpleDateFormat(annotation.pattern().getValue());
                return dateFormat.parse(value);
            } catch (Exception e) {
                throw new IllegalArgumentException("Date format conversion error", e);
            }
        }
    }

    /**
     * 解析器是否支持当前参数
     * @param parameter
     */
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasMethodAnnotation(RequestDateParam.class);
    }

    /**
     * 当前参数值为空且默认值为空 抛出异常
     * @param name       参数名
     * @param parameter  需要被解析的Controller参数
     */
    @Override
    protected void handleMissingValue(String name, MethodParameter parameter, NativeWebRequest request) throws Exception {
        throw new MissingServletRequestParameterException(name, parameter.getParameterType().getSimpleName());
    }


}
