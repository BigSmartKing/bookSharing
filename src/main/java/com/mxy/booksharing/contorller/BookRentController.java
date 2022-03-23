package com.mxy.booksharing.contorller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mxy.booksharing.pojo.Book;
import com.mxy.booksharing.pojo.RentAndBook;
import com.mxy.booksharing.pojo.User;
import com.mxy.booksharing.service.BookRentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class BookRentController {
    @Resource
    private BookRentService bookRentService;

    /**
     *currentUserId：租书人
     * @param userId 提供图书的人
     * @return
     * 图书租赁
     */
    @ResponseBody
    @RequestMapping("/bookRent")
    public int bookRent(HttpServletRequest request,
                        @RequestParam("userId")int userId,
                        @RequestParam("rentBeginDate")String rentBeginDate,
                        @RequestParam("rentFinishDate")String rentFinishDate,
                        @RequestParam("bookId")int bookId
                        ){
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("currentUser");
        int currentUserId = user.getUserId();
        int x = bookRentService.rentBook(userId,currentUserId,rentBeginDate,rentFinishDate,bookId);
        //租赁过后要将状态置为已租赁
        int y = bookRentService.SetBookStatue(bookId);

        return 1;
    }

    /**
     * 我的租赁列表
     */
    @RequestMapping("myRentList")
    public String myRentList(Model model, @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum, HttpServletRequest request) {
        PageHelper.startPage(pageNum, 7);
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("currentUser");
        int userId = user.getUserId();
        List<RentAndBook> lists = bookRentService.myRentList(userId);
        PageInfo<RentAndBook> pageInfo = new PageInfo<RentAndBook>(lists);
        model.addAttribute("pageInfo",pageInfo);

        return "user/myRentBookList";
    }

    @ResponseBody
    @RequestMapping("/bookReturn")
    public int bookReturn(Model model, @RequestParam("bookId") int bookId, @RequestParam("rentId") int rentId,HttpServletRequest request){
    // 租赁状态置为1，代表租赁归还提交
    int x= bookRentService.SetRentStatue(rentId);
   //int y =bookRentService.SetBookStatueYes(bookId);
        return 1;
    }

    /**
     * 归还图书的列表，可以进行确认收到操作
     * @param model
     * @param pageNum
     * @param request
     * @return
     */
    @RequestMapping("renturnBookList")
    public String renturnBookList(Model model, @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum, HttpServletRequest request) {
        PageHelper.startPage(pageNum, 7);
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("currentUser");
        int userId = user.getUserId();
        List<RentAndBook> lists = bookRentService.returnBookList(userId);
        PageInfo<RentAndBook> pageInfo = new PageInfo<RentAndBook>(lists);
        model.addAttribute("pageInfo",pageInfo);

        return "user/returnBookList";
    }

    /**
     * 归还无误
     * @return
     */
    @ResponseBody
    @RequestMapping("/bookReturnAgree")
    public int bookReturnAgree(Model model, @RequestParam("bookId") int bookId, @RequestParam("rentId") int rentId,HttpServletRequest request){
        int  x = bookRentService.SetRentStatueTo0(rentId);
        int y= bookRentService.SetBookStatueYes(bookId);
        int z = bookRentService.DeleteRentByRentId(rentId);
        return 1;
    }
    /**
     * 归还有问题，暂时不知道怎么办，先打回
     */
    @ResponseBody
    @RequestMapping("/bookReturnRefuse")
    public int bookReturnRefuse(Model model, @RequestParam("bookId") int bookId, @RequestParam("rentId") int rentId,HttpServletRequest request){
        int x= bookRentService.SetRentStatueTo0(rentId);
        return 1;
    }

    /**
     * 违章信息
     *  在RentAndBook中加一个 违约天数
     */
    @RequestMapping("/violation")
    public String violation(Model model, @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum, HttpServletRequest request){

        PageHelper.startPage(pageNum, 7);
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("currentUser");
        int userId = user.getUserId();
        List<RentAndBook> lists = bookRentService.violationINFO(userId);
        PageInfo<RentAndBook> pageInfo = new PageInfo<RentAndBook>(lists);
        model.addAttribute("pageInfo",pageInfo);


        System.out.println("违约日期：*--*-*-*---*-------*--*---*-**-*");
        return "user/violation";
    }

    /**
     * bookReturnInViolation
     * 违章还书
     * 1、租赁状态置为1，代表租赁归还提交（普通还书一致）
     * 2、rent表的惩罚信息转换（处罚的钱要给图书提供者而不是管理员）
     * 3、抛给用户审查图书归还
     */
    @ResponseBody
    @RequestMapping("/bookReturnInViolation")
    public int bookReturnInViolation(Model model, @RequestParam("bookId") int bookId, @RequestParam("rentId") int rentId,HttpServletRequest request){
        // 租赁状态置为1，代表租赁归还提交
        int x= bookRentService.SetRentStatue(rentId);
        //int y =bookRentService.SetBookStatueYes(bookId);
        //处罚状态转换
        int y = bookRentService.bookReturnInViolation(rentId);
        return 1;
    }

    /**
     * 逾期监测
     */
    @ResponseBody
    @RequestMapping("/bookReturnInViolationLicense")
    public int bookReturnInViolationLicense(Model model, @RequestParam("rentId") int rentId){
        //处罚状态转换
        int y = bookRentService.bookReturnInViolation(rentId);
        return 1;
    }
    /**
     *
     * 管理员查看租赁信息
     */
    @RequestMapping("/userRentList")
    public String userRentList(Model model, @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum, HttpServletRequest request) {
        PageHelper.startPage(pageNum, 7);
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("currentUser");
        int userId = user.getUserId();
        List<RentAndBook> lists = bookRentService.bookRentList();
        PageInfo<RentAndBook> pageInfo = new PageInfo<RentAndBook>(lists);
        model.addAttribute("pageInfo", pageInfo);

        return "admin/admin_book/bookRentBookList";
    }

}
