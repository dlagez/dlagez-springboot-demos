package com.example.springmvc2.controller;

import com.example.springmvc2.constants.ServiceExceptionEnum;
import com.example.springmvc2.core.exception.ServiceException;
import com.example.springmvc2.core.vo.CommonResult;
import com.example.springmvc2.vo.UserVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;


@RestController
@RequestMapping("/users")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    // 测试全局统一返回
    @GetMapping("/get")
    public UserVO get(@RequestParam("id") Integer id) {
        return new UserVO(id, UUID.randomUUID().toString());
    }

    @GetMapping("/get2")
    public CommonResult<UserVO> get2(@RequestParam("id") Integer id) {
        UserVO user = new UserVO(id, UUID.randomUUID().toString());
        return CommonResult.success(user);
    }

    /**
     * 测试空指针异常
     * @return
     */
    @GetMapping("/exception01")
    public UserVO exception01() {
        throw new NullPointerException("没有粗面鱼丸");
    }

    /**
     * 测试抛出 ServiceException 异常
     * @return
     */
    @GetMapping("/exception02")
    public UserVO exception02() {
        throw new ServiceException(ServiceExceptionEnum.USER_NOT_FOUND);
    }


    /**
     * 测试拦截器链
     */
    @GetMapping("/do_someThing")
    public void doSomething() {
        logger.info("[doSomething]");
    }

    /**
     * 测试第二个拦截器
     * @return
     */
    @GetMapping("/current_user")
    public UserVO currentUser() {
        logger.info("[currentUser]");
        return new UserVO(10, UUID.randomUUID().toString());
    }

    /**
     * 测试第三个拦截器 它在postHandler抛出了异常
     */
    @GetMapping("/exception03")
    public void exception03() {
        logger.info("[exception03]");
        throw new ServiceException(ServiceExceptionEnum.USER_NOT_FOUND);
    }
}
