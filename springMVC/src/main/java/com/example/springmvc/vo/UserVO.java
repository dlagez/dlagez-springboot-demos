package com.example.springmvc.vo;

public class UserVO {
    private Integer id;
    private String username;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public UserVO(Integer id, String username) {
        this.id = id;
        this.username = username;
    }
}
