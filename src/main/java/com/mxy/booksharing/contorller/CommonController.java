package com.mxy.booksharing.contorller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommonController {

    public String demo(){
        return null;
    };

    //跳转登录
    @RequestMapping("/")
    public String toLogin(){
        return "login";
    };
    //跳转注册
    @RequestMapping("/toRegister")
    public String toRegister(){
        return "register";
    };

    //跳转用户共享图书：用户左侧，共享图书按钮
    @RequestMapping("/toShareBook")
    public String toShareBook(){
        return "user/shareBook";
    };
    // 读者规则
    @RequestMapping("/regular")
    public String regular(){
        return "regular";
    }

    //测试
    @RequestMapping("/test")
    public String test() {

        return "index";
    }

    @RequestMapping("updateInfoAdmin")
    public String updateInfoAdmin(){
        return "common/personalInformation";
    }

    @RequestMapping("updateInfoUser")
    public String updateInfo(){
        System.out.println("******@@*@*@*@*@");
        return "common/personalInformationUser";
    }

}
