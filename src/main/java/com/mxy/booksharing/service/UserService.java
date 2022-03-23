package com.mxy.booksharing.service;

import com.mxy.booksharing.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserService {
    //注册
    int userRegister(String userName,String userPwd,String userTell,int userCategory,int userSex);
    //登录
    User userLogin(String userName,String userPwd);

    @Select("SELECT * FROM users")
    List<User> userList();
    /**
     * 违章用户
     */
    List<User> userListByCredit();
    int deleteUser(int userId);
    int updateUserInfo(String userName,String userPwd,String userTell,int userCategory,int userId);
    List<User> userListByUserName(String userName);
    int prohibitUser(int userId);
    int prohibitUserOff(int userId);
    int updateUserInfoHead(String userName,String userPwd,String userTell,int userId);
}
