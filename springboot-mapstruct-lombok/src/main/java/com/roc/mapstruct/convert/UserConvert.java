package com.roc.mapstruct.convert;

import com.roc.mapstruct.bo.UserBO;
import com.roc.mapstruct.bo.UserDetailBO;
import com.roc.mapstruct.dataobject.UserDO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;


@Mapper
public interface UserConvert {
    UserConvert INSTANCE = Mappers.getMapper(UserConvert.class);

    UserBO convert(UserDO userDO);

    @Mappings({
            @Mapping(source = "id", target = "userId")
    })
    UserDetailBO convertDetail(UserDO userDO);

}
