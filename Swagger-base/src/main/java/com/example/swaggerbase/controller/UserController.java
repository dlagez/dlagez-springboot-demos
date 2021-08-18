package com.example.swaggerbase.controller;

import com.example.swaggerbase.vo.UserVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
@Api(tags = "用户 API 接口") // 注解，添加在 Controller 类上，标记它作为 Swagger 文档资源。
public class UserController {

    @GetMapping("/list")
    @ApiOperation(value = "查询用户列表", notes = "测试，返回用户列表") // 添加在 Controller 方法上，标记它是一个 API 操作。
    public List<UserVO> list() {
        List<UserVO> result = new ArrayList<>();
        result.add(new UserVO().setId(1).setUsername("roczhang"));
        result.add(new UserVO().setId(2).setUsername("dlage"));
        return result;
    }

    @GetMapping("/get")
    @ApiOperation("获得指定用户编号的用户")
    @ApiImplicitParam(name = "id", value = "用户编号", paramType = "query",
            dataTypeClass = Integer.class, required = true, example = "1024") // 添加在 Controller 方法上，声明每个请求参数的信息。
    public UserVO get(@RequestParam("id") Integer id) {
        return new UserVO().setId(id).setUsername("roczhang");
    }


}
