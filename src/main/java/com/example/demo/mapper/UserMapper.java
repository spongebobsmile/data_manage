package com.example.demo.mapper;

import com.example.demo.model.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {
    @Insert("insert into user (username,password) values(#{username},#{password})")
    void adduser(User user);

    @Select("select * from user where username=#{username}")
    User getuser(String username);

    @Select("select * from user where username=#{username} and password=#{password}")
    User login(String username,String password);

    @Delete("delete from user where username=#{username}")
    void deleteuser(String username);

    @Select("select * from user where username=#{username} and password=#{password}")
    User getuser1(String username,String password);

    @Update("update user set password=#{password} where username=#{username}")
    void updateuser(String username,String password);

    User getuser(java.lang.String username);

    User login(java.lang.String username, java.lang.String password);

    User getuser1(java.lang.String username, java.lang.String password);

    void deleteuser(java.lang.String username);

    void updateuser(java.lang.String username, java.lang.String newpassword);
}
