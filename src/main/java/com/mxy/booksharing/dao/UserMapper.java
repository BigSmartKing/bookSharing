package com.mxy.booksharing.dao;

import com.mxy.booksharing.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {

    //注册
    @Insert("INSERT INTO users(user_name,user_pwd,user_tell,user_category,user_sex) VALUES(#{userName},#{userPwd},#{userTell},#{userCategory},#{userSex})")
    int userRegister(String userName,String userPwd,String userTell,int userCategory,int userSex);

    //登录
    @Results({
            @Result(property = "userId", column = "user_id"),
            @Result(property = "userName", column = "user_name"),
            @Result(property = "userPwd", column = "user_pwd"),
            @Result(property = "userTell", column = "user_tell"),
            @Result(property = "userCategory", column = "user_category"),
            @Result(property = "userSex", column = "user_sex"),
            @Result(property = "userCredit", column = "user_credit"),
            @Result(property = "userRole", column = "user_role")
    })
    @Select("SELECT * FROM users WHERE user_name =#{userName} AND user_pwd =#{userPwd} AND user_credit = 1")
    User userLogin(String userName,String userPwd);

    /**
     * 用户列表
     * @return
     */
    @Results({
            @Result(property = "userId", column = "user_id"),
            @Result(property = "userName", column = "user_name"),
            @Result(property = "userPwd", column = "user_pwd"),
            @Result(property = "userTell", column = "user_tell"),
            @Result(property = "userCategory", column = "user_category"),
            @Result(property = "userSex", column = "user_sex"),
            @Result(property = "userCredit", column = "user_credit"),
            @Result(property = "userRole", column = "user_role")
    })
    @Select("SELECT * FROM users")
    List<User> userList();
    /**
     * 违章用户
     */
    @Results({
            @Result(property = "userId", column = "user_id"),
            @Result(property = "userName", column = "user_name"),
            @Result(property = "userPwd", column = "user_pwd"),
            @Result(property = "userTell", column = "user_tell"),
            @Result(property = "userCategory", column = "user_category"),
            @Result(property = "userSex", column = "user_sex"),
            @Result(property = "userCredit", column = "user_credit"),
            @Result(property = "userRole", column = "user_role")
    })
    @Select("SELECT * FROM users WHERE user_credit =0")
    List<User> userListByCredit();

    @Delete("DELETE FROM users WHERE user_id = #{userId}")
    int deleteUser(int userId);

    @Update("UPDATE users SET user_name=#{userName},user_pwd=#{userPwd},user_tell = #{userTell},user_category=#{userCategory} WHERE user_id=#{userId}")
    int updateUserInfo(String userName,String userPwd,String userTell,int userCategory,int userId);


    @Results({
            @Result(property = "userId", column = "user_id"),
            @Result(property = "userName", column = "user_name"),
            @Result(property = "userPwd", column = "user_pwd"),
            @Result(property = "userTell", column = "user_tell"),
            @Result(property = "userCategory", column = "user_category"),
            @Result(property = "userSex", column = "user_sex"),
            @Result(property = "userCredit", column = "user_credit"),
            @Result(property = "userRole", column = "user_role")
    })
    @Select("SELECT * FROM users WHERE user_name=#{userName}")
    List<User> userListByUserName(String userName);

    @Update("UPDATE users SET user_credit = 0 WHERE user_id = #{userId}")
    int prohibitUser(int userId);

    @Update("UPDATE users SET user_credit = 1 WHERE user_id = #{userId}")
    int prohibitUserOff(int userId);


    @Update("UPDATE users SET user_name = #{userName},user_pwd=#{userPwd},user_tell=#{userTell} WHERE user_id = #{userId}")
    int updateUserInfoHead(String userName,String userPwd,String userTell,int userId);
}