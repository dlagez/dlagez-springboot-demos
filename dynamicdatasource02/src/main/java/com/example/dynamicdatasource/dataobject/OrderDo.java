package com.example.dynamicdatasource.dataobject;

public class OrderDo {

    private Integer id;

    private Integer userId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "OrderDo{" +
                "id=" + id +
                ", userId=" + userId +
                '}';
    }
}
