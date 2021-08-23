package com.example.mybatisplus.dataobject;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;

@TableName(value = "users") //设置了 UserDO 对应的表名是 users
public class UserDo {

    private Integer id;

    private String username;

    private String password;

    private Date createTime;

    @TableLogic
    private Integer deleted;

    public UserDo(Integer id, String username, String password, Date createTime, Integer deleted) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.createTime = createTime;
        this.deleted = deleted;
    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "UserDo{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", createTime=" + createTime +
                ", deleted=" + deleted +
                '}';
    }

}
