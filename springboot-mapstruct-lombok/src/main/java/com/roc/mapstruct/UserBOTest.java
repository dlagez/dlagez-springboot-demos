package com.roc.mapstruct;

import com.roc.mapstruct.bo.UserBO;
import com.roc.mapstruct.convert.UserConvert;
import com.roc.mapstruct.dataobject.UserDO;

public class UserBOTest {
    public static void main(String[] args) {
        UserDO roczhang = new UserDO().setId(1).setUsername("roczhang").setPassword("123");

        UserBO bo = UserConvert.INSTANCE.convert(roczhang);

        System.out.println(bo.getId());
        System.out.println(bo.getUsername());
        System.out.println(bo.getPassword());
    }
}
