package com.mxy.booksharing.service.serviceIMPL;

import com.mxy.booksharing.dao.UserMapper;
import com.mxy.booksharing.pojo.User;
import com.mxy.booksharing.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceIMPL implements UserService {
    //@Autowired
    @Resource
    private UserMapper userMapper;


    //注册
    @Override
    public int userRegister(String userName, String userPwd, String userTell, int userCategory, int userSex) {
        return userMapper.userRegister(userName,userPwd,userTell,userCategory,userSex);
    }

    @Override
    public User userLogin(String userName, String userPwd) {
        return userMapper.userLogin(userName,userPwd);
    }

    @Override
    public List<User> userList() {
        return userMapper.userList();
    }

    @Override
    public List<User> userListByCredit() {
        return userMapper.userListByCredit();
    }

    @Override
    public int deleteUser(int userId) {
        return userMapper.deleteUser(userId);
    }

    @Override
    public int updateUserInfo(String userName, String userPwd, String userTell, int userCategory, int userId) {
        return userMapper.updateUserInfo(userName,userPwd,userTell,userCategory,userId);
    }

    @Override
    public List<User> userListByUserName(String userName) {
        return userMapper.userListByUserName(userName);
    }

    @Override
    public int prohibitUser(int userId) {
        return userMapper.prohibitUser(userId);
    }

    @Override
    public int prohibitUserOff(int userId) {
        return userMapper.prohibitUserOff(userId);
    }

    @Override
    public int updateUserInfoHead(String userName, String userPwd, String userTell, int userId) {
        return userMapper.updateUserInfoHead(userName,userPwd,userTell,userId);
    }
}
