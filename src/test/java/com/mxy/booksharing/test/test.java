package com.mxy.booksharing.test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mxy.booksharing.pojo.RentAndBook;
import com.mxy.booksharing.pojo.User;
import com.mxy.booksharing.service.BookRentService;
import org.junit.jupiter.api.Test;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class test {
    @Resource
    private BookRentService bookRentService;

    @Test
    @RequestMapping("/violation")
    public String violation(Model model, @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum, HttpServletRequest request){

        PageHelper.startPage(pageNum, 7);
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("currentUser");
        int userId = user.getUserId();
        List<RentAndBook> lists = bookRentService.myRentList(userId);
        PageInfo<RentAndBook> pageInfo = new PageInfo<RentAndBook>(lists);
        model.addAttribute("pageInfo",pageInfo);
        System.out.println("违约日期：*--*-*-*---*-------*--*---*-**-*");
        return "user/violation";
    }
}
