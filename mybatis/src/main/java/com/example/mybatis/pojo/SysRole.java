package com.example.mybatis.pojo;

import java.util.Date;

public class SysRole {
    private Long id;
    private String roleName;
    private Integer enabled;
    private Long create_by;
    private Date createTime;

    private SysUser user;

    public SysUser getSysUser() {
        return user;
    }

    public void setSysUser(SysUser sysUser) {
        this.user = sysUser;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

    public Long getCreate_by() {
        return create_by;
    }

    public void setCreate_by(Long create_by) {
        this.create_by = create_by;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "SysRole{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", enabled=" + enabled +
                ", create_by=" + create_by +
                ", createTime=" + createTime +
                '}';
    }
}
