package com.example.swaggerbase.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel  // 添加在 POJO 类，声明 POJO 类的信息。而在 Swagger 中，把这种 POJO 类称为 Model 类。
public class UserVO {
    // 添加在 Model 类的成员变量上，声明每个成员变量的信息。
    @ApiModelProperty(value = "用户编号", required = true, example = "1024")
    private Integer id;
    @ApiModelProperty(value = "账号", required = true, example = "dlage")
    private String username;

    public Integer getId() {
        return id;
    }

    public UserVO setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserVO setUsername(String username) {
        this.username = username;
        return this;
    }
}
