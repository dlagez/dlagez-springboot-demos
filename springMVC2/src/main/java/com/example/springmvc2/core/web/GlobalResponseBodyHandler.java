package com.example.springmvc2.core.web;

import com.example.springmvc2.core.vo.CommonResult;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

// implements ResponseBodyAdvice 对返回的结果进行修改
// 只拦截 "com.example.springmvc2.controller" 包
@ControllerAdvice(basePackages = "com.example.springmvc2.controller")
public class GlobalResponseBodyHandler implements ResponseBodyAdvice {
    // 返回 true 。表示拦截 Controller 所有 API 接口的返回结果。
    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return true;
    }
    // 当返回的结果不是 CommonResult 类型时，则包装成 CommonResult 类型
    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        // 如果已经是 CommonResult 类型，则直接返回
        if (o instanceof CommonResult) {
            return o;
        }
        // 如果不是，则包装成 CommonResult 类型
        return CommonResult.success(o);
    }
}
