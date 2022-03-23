package com.mxy.booksharing.contorller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mxy.booksharing.pojo.BookAndUser;
import com.mxy.booksharing.pojo.Notice;
import com.mxy.booksharing.service.NoticeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class NoticeController {
    @Resource
    private NoticeService noticeService;

    /**
     * 公告列表
     * @param model
     * @param pageNum
     * @return
     */
    @RequestMapping("/adminNoticeList")
    public String adminNotice(Model model, @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum) {
        PageHelper.startPage(pageNum, 7);
        List<Notice> lists = noticeService.noticeList();
        PageInfo<Notice> pageInfo = new PageInfo<Notice>(lists);
        model.addAttribute("pageInfo",pageInfo);

        return "notice/noticeList";
    }
    @RequestMapping("/userNoticeList")
    public String userNoticeList(Model model, @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum) {
        PageHelper.startPage(pageNum, 7);
        List<Notice> lists = noticeService.noticeList();
        PageInfo<Notice> pageInfo = new PageInfo<Notice>(lists);
        model.addAttribute("pageInfo",pageInfo);
        return "notice/userNoticeList";
    }
    @ResponseBody
    @RequestMapping("/addNotice")
    public int addNotice(@RequestParam("noticeContent") String noticeContent,@RequestParam("noticeTitle") String noticeTitle){
        int x= noticeService.addNotice(noticeTitle,noticeContent);
        return 1;
    }


    @ResponseBody
    @RequestMapping("/deleteNotice")
    public int deleteNotice(@RequestParam("noticeId") int noticeId){
        int x = noticeService.deleteNotice(noticeId);
        return 1;
    }
    /**
     *
     * 公告详情
     */
    @RequestMapping("noticeDetail")
    public String  noticeDetail(@RequestParam("noticeId") int noticeId,  Model model){

        Notice notice = noticeService.noticeListById(noticeId);
        model.addAttribute("notice",notice);

        return "notice/noticeDeatil";
    }
}
