package com.booklibrary.dao;

import com.booklibrary.model.User;
import org.apache.ibatis.annotations.*;
import org.omg.CORBA.CODESET_INCOMPATIBLE;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface UserMapper {
    @Insert("insert into user (username,userpassword) values(#{userName},#{userPassword})")
    int insertUser(User user);

    @Results({
            @Result(column = "id",property = "id" ,id =true),
            @Result(column = "username" ,property = "userName"),
            @Result(column = "userpassword", property = "userPassword")
    })
    @Select("select * from user where username=#{userName}&& userpassword=#{userPassword}")
    User selectUserByLogin(User user);

    @Update("update `user` Set userpassword=#{userPassword} where id=#{id}")
    int updateUser(User user);
}
