package com.roc.mapstruct;

import com.roc.mapstruct.bo.UserBO;
import com.roc.mapstruct.bo.UserDetailBO;
import com.roc.mapstruct.convert.UserConvert;
import com.roc.mapstruct.dataobject.UserDO;

public class UserDetailTest {
    public static void main(String[] args) {
        UserDO roczhang = new UserDO().setId(1).setUsername("roczhang").setPassword("123");
        UserDetailBO detailBO = UserConvert.INSTANCE.convertDetail(roczhang);

        System.out.println(detailBO.getUserId());
    }
}
