package com.example.springmvc2.core.web;

import com.example.springmvc2.constants.ServiceExceptionEnum;
import com.example.springmvc2.core.exception.ServiceException;
import com.example.springmvc2.core.vo.CommonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

// 全局异常处理器
@ControllerAdvice(basePackages = "com.example.springmvc2.controller")
public class GlobalExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 处理serviceException 异常
     * @param request
     * @param exception
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = ServiceException.class)
    public CommonResult serviceExceptionHandler(HttpServletRequest request, ServiceException exception) {
        logger.debug("[serviceExceptionHandler]", exception);
        return CommonResult.error(exception.getCode(), exception.getMessage());
    }

    /**
     * SpringMVC 参数不正确
     * @param request
     * @param ex
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = MissingServletRequestParameterException.class)
    public CommonResult missingServletRequestParameterException(HttpServletRequest request,
                                                                MissingServletRequestParameterException ex) {
        logger.debug("[missingServletRequestParameterException]", ex);
        return CommonResult.error(ServiceExceptionEnum.MISSING_REQUEST_PARAM_ERROR.getCode(),
                ServiceExceptionEnum.MISSING_REQUEST_PARAM_ERROR.getMessage());
    }

    /**
     * 处理其他 Exception 这是一个兜底的异常处理，避免有一些其它异常，
     * 我们没有在 GlobalExceptionHandler 中，提供自定义的处理方式。
     * @param request
     * @param e
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public CommonResult exceptionHandler(HttpServletRequest request, Exception e) {
        logger.error("[exceptionHandler]", e);
        return CommonResult.error(ServiceExceptionEnum.SYS_ERROR.getCode(),
                ServiceExceptionEnum.SYS_ERROR.getMessage());
    }

}
