package com.mxy.booksharing.contorller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mxy.booksharing.pojo.BookAndUser;
import com.mxy.booksharing.pojo.Statistics;
import com.mxy.booksharing.pojo.User;
import com.mxy.booksharing.service.BookService;
import com.mxy.booksharing.service.StatisticsService;
import com.mxy.booksharing.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.mxy.booksharing.pojo.Categories;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Calendar;
import java.util.List;

@Controller
public class UserController {
    @Resource
    private UserService userService;
    @Resource
    private BookService bookService;

    @Resource
    private StatisticsService statisticsService;

    /**
     * 注册
     */
    @ResponseBody
    @RequestMapping("/register")
    public int userRegister(@RequestParam("userName") String userName,
                            @RequestParam("userTell") String userTell,
                            @RequestParam("userSex") int userSex,
                            @RequestParam("userPwd") String userPwd,
                            @RequestParam("userCategory") int userCategory
    ) {
        int status = userService.userRegister(userName, userPwd, userTell, userCategory, userSex);
        return 1;
    }

    /**
     * 登录
     * 登录时 在session中留下 图书类别名称
     */
    @RequestMapping("/login")
    public String userLogin(@RequestParam("userName") String userName, @RequestParam("userPwd") String userPwd
            , HttpServletRequest request, Model model
    ) {
        User currentUser = userService.userLogin(userName, userPwd);
        // 图书分类列表信息
        List<Categories> categoryList = bookService.categoryList();
        HttpSession session = request.getSession();
        session.setAttribute("categoryList", categoryList);
        model.addAttribute("categoryList", categoryList);
        //用户信息
        session.setAttribute("currentUser", currentUser);
        model.addAttribute("currentUser", currentUser);

        if (currentUser != null) {
            /**
             * 管理员
             * 登录后 数据分析
             */
            if (currentUser.getUserRole() == 0) {
                java.util.Date currTime = new java.util.Date();
                String year = String.valueOf(currTime.getYear());//年
                String month = String.valueOf(currTime.getMonth() + 1);//月
                String day = String.valueOf(currTime.getDate());//日

                String staDate = year + '-' + month + '-' + day;

                int[] staUserCount = new int[7];
                List<Statistics> statisticsList = statisticsService.statistics();
                for (int i = 0; i < statisticsList.size(); i++) {
                    System.out.println(statisticsList.get(i).getStaUserCount());
                    staUserCount[i] = statisticsList.get(i).getStaUserCount();
                }
                // 用户总数
                int userCount = statisticsService.userCount();
                model.addAttribute("userCount", userCount);
                // 租赁总数
                int rentCount = statisticsService.rentCount();
                model.addAttribute("rentCount", rentCount);
                // 注册人数
                int userAddCount_0 = staUserCount[0];
                int userAddCount_1 = staUserCount[1];
                int userAddCount_2 = staUserCount[2];
                int userAddCount_3 = staUserCount[3];
                int userAddCount_4 = staUserCount[4];
                int userAddCount_5 = staUserCount[5];
                int userAddCount_6 = staUserCount[6];
                model.addAttribute("userAddCount_0", userAddCount_0);
                model.addAttribute("userAddCount_1", userAddCount_1);
                model.addAttribute("userAddCount_2", userAddCount_2);
                model.addAttribute("userAddCount_3", userAddCount_3);
                model.addAttribute("userAddCount_4", userAddCount_4);
                model.addAttribute("userAddCount_5", userAddCount_5);
                model.addAttribute("userAddCount_6", userAddCount_6);
                // 图书租赁数量
                int[] staRentCount = new int[7];
                for (int i = 0; i < statisticsList.size(); i++) {
                    staRentCount[i] = statisticsList.get(i).getStaRentCount();
                }
                int rentBookAddCount_0 = staRentCount[0];
                int rentBookAddCount_1 = staRentCount[1];
                int rentBookAddCount_2 = staRentCount[2];
                int rentBookAddCount_3 = staRentCount[3];
                int rentBookAddCount_4 = staRentCount[4];
                int rentBookAddCount_5 = staRentCount[5];
                int rentBookAddCount_6 = staRentCount[6];

                model.addAttribute("rentBookAddCount_0", rentBookAddCount_0);
                model.addAttribute("rentBookAddCount_1", rentBookAddCount_1);
                model.addAttribute("rentBookAddCount_2", rentBookAddCount_2);
                model.addAttribute("rentBookAddCount_3", rentBookAddCount_3);
                model.addAttribute("rentBookAddCount_4", rentBookAddCount_4);
                model.addAttribute("rentBookAddCount_5", rentBookAddCount_5);
                model.addAttribute("rentBookAddCount_6", rentBookAddCount_6);

                // 今日注册人数
                int registerUserCount = statisticsList.get(6).getStaUserCount();
                model.addAttribute("registerUserCount", registerUserCount);

                // 新增图书上传
                int addBookCount = statisticsList.get(6).getStaBookCount();
                model.addAttribute("addBookCount", addBookCount);
                // 放到Session的两个
                int sessionRegisterCount = statisticsList.get(6).getStaUserCount();
                int sessionAddBookCount = statisticsList.get(6).getStaBookCount();
                session.setAttribute("sessionRegisterCount", sessionRegisterCount);
                session.setAttribute("sessionAddBookCount", sessionAddBookCount);

                List<Statistics> statisticsList1 = statisticsService.statistics();
                if (statisticsList1.size() == 0) {
                    //今日数据为空
                    // 暂时注释掉，影响数据
                    int x = statisticsService.InsertStaByDate(0, 0, 0);
                }
                return "admin/admin_index";
            } else if (currentUser.getUserRole() == 1) {
                return "user/user_index";
            } else {
                model.addAttribute("msg", "用户名或密码错误...");
                return "error";
            }
        } else {
            model.addAttribute("msg", "登录身份失效，请重新登录...");
            return "error";
        }
    }

    /**
     * userList
     * 用户列表
     */
    @RequestMapping("userList")
    public String userList(Model model, @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum) {

        PageHelper.startPage(pageNum, 7);
        List<User> lists = userService.userList();
        PageInfo<User> pageInfo = new PageInfo<User>(lists);
        model.addAttribute("pageInfo", pageInfo);
        return "admin/admin_user/userList";
    }

    /**
     * 删除用户
     *
     * @param userId
     * @return
     */
    @ResponseBody
    @RequestMapping("deleteUserByAdmin")
    public int deleteUserByAdmin(@RequestParam(value = "userId") Integer userId) {
        int x = userService.deleteUser(userId);
        return 1;
    }

    @RequestMapping("selectUserByUserName")
    public String selectUserByUserName(@RequestParam("userName") String userName, Model model, @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum) {

        PageHelper.startPage(pageNum, 7);
        List<User> lists = userService.userListByUserName(userName);
        PageInfo<User> pageInfo = new PageInfo<User>(lists);
        model.addAttribute("pageInfo", pageInfo);

        return "admin/admin_user/userListByUserName";
    }

    /**
     * 共享禁用
     */
    @ResponseBody
    @RequestMapping("/prohibitUser")
    public int prohibitUser(@RequestParam(value = "userId") Integer userId) {
        int x = userService.prohibitUser(userId);
        return 1;
    }

    @ResponseBody
    @RequestMapping("/prohibitUserOff")
    public int prohibitUserOff(@RequestParam(value = "userId") Integer userId) {
        int x = userService.prohibitUserOff(userId);
        return 1;
    }

    /**
     * 个人信息修改
     */
    @RequestMapping("/updateUserInfo")
    public String updateUserInfo(@RequestParam String userName,
                                 @RequestParam String userTell,
                                 @RequestParam("userPwd") String userPwd,
                                 HttpServletRequest request) {
        HttpSession session = request.getSession();
        User users = (User) session.getAttribute("currentUser");
        int userId = users.getUserId();
        int x = userService.updateUserInfoHead(userName, userPwd ,userTell , userId);
        return "redirect:/";
    }

    /**
     * 退出登录
     */
    @RequestMapping("/logout")
    public  String logout(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.invalidate();
        return  "redirect:/";
    }

}

