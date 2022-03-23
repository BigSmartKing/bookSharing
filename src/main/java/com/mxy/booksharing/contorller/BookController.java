package com.mxy.booksharing.contorller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mxy.booksharing.pojo.Book;
import com.mxy.booksharing.pojo.BookAndUser;
import com.mxy.booksharing.pojo.User;
import com.mxy.booksharing.service.BookService;
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
public class BookController {
    @Resource
    private BookService bookService;

    /**
     * 插入，即分享图书
     * @return
     */
    @ResponseBody
    @RequestMapping("/shareBook")
    public int bookList(
            @RequestParam("isbn")String isbn,
            @RequestParam("bookName")String bookName,
            @RequestParam("bookAuthor")String bookAuthor,
            @RequestParam("bookLocation")String bookLocation,
            @RequestParam("bookDetail")String bookDetail,
            @RequestParam("bookOwner")int bookOwner,
            @RequestParam("bookCount")int bookCount,
            @RequestParam("bookCategoryId")int bookCategoryId
            ){
        int status = bookService.shareBook(isbn,bookName,bookAuthor,bookLocation,bookDetail,bookOwner,bookCount,bookCategoryId);

        return 1;
    }

    /**
     * 查看图书列表
     */
    @RequestMapping("/selectBookList")
    public String selectBookList(Model model, @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum) {
        PageHelper.startPage(pageNum, 7);
        List<BookAndUser> lists = bookService.bookList();
        PageInfo<BookAndUser> pageInfo = new PageInfo<BookAndUser>(lists);
        model.addAttribute("pageInfo",pageInfo);

        return "book/selectBookList";
    }
    @RequestMapping("/selectBookListByAdmin")
    public String selectBookListByAdmin(Model model, @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum) {
        PageHelper.startPage(pageNum, 7);
        List<BookAndUser> lists = bookService.bookListByAdmin();
        PageInfo<BookAndUser> pageInfo = new PageInfo<BookAndUser>(lists);
        model.addAttribute("pageInfo",pageInfo);

        return "admin/admin_book/selectBookList";
    }
    /**
     * 图书详情
     */
    @RequestMapping("/bookDetail")
    public String bookDetail(Model model, @RequestParam("bookId") int bookId) {
        BookAndUser  book  = bookService.bookDetail(bookId);
        model.addAttribute("book",book);

        return "book/bookDetail";
    }
    @RequestMapping("/bookDetailByAdmin")
    public String bookDetailByAdmin(Model model, @RequestParam("bookId") int bookId) {
        BookAndUser  book  = bookService.bookDetail(bookId);
        model.addAttribute("book",book);

        return "admin/admin_book/bookDetail";
    }

    /**
     * 根据书名查找
     */
    @RequestMapping("/selectByBookName")
    public String selectByBookName(Model model, @RequestParam("bookName")String bookName) {
        List<BookAndUser> lists = bookService.bookListByBookName(bookName);
        model.addAttribute("lists",lists);

        return "book/selectBookByBookName";
    }
    @RequestMapping("/selectByBookNameByAdmin")
    public String selectByBookNameByAdmin(Model model, @RequestParam("bookName")String bookName) {
        List<BookAndUser> lists = bookService.bookListByBookName(bookName);
        model.addAttribute("lists",lists);

        return "admin/admin_book/selectBookByBookName";
    }
    /**
     * 图书按照类别查询
     */
    @RequestMapping("/selectBookByCategory")
    public String selectBookByCategory(Model model, @RequestParam("categoryId")int categoryId) {
        List<BookAndUser> lists = bookService.bookListByCategory(categoryId);
        model.addAttribute("lists",lists);

        return "book/selectBookByBookCategoryId";
    }
    @RequestMapping("/selectBookByCategoryByAdmin")
    public String selectBookByCategoryByAdmin(Model model, @RequestParam("categoryId")int categoryId) {
        List<BookAndUser> lists = bookService.bookListByCategory(categoryId);
        model.addAttribute("lists",lists);

        return "admin/admin_book/selectBookByBookCategoryId";
    }
    /**
     *
     * 我的图书分享列表
     */
    @RequestMapping("/myShareBookList")
    public String myShareBookList(Model model, @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum, HttpServletRequest request) {
        PageHelper.startPage(pageNum, 7);
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("currentUser");
        int userId = user.getUserId();
        List<Book> lists = bookService.myShareBookList(userId);
        PageInfo<Book> pageInfo = new PageInfo<Book>(lists);
        model.addAttribute("pageInfo",pageInfo);

        return "user/myShareBookList";
    }

    /**
     * 我所分享的图书随后点击进如详情，随后修改
     */
    @RequestMapping("/myShareBookListDetail")
    public String myShareBookListDetail(Model model,HttpServletRequest request,@RequestParam("bookId")int bookId){
        Book book = bookService.myShareBookDetail(bookId);
        model.addAttribute("book",book);

        return "user/userShareBookDetail";
    }


    /**
     * 图书修改
     */
    @ResponseBody
    @RequestMapping("/updateBook")
    public int updateBook(
            @RequestParam("isbn")String isbn,
            @RequestParam("bookName")String bookName,
            @RequestParam("bookAuthor")String bookAuthor,
            @RequestParam("bookLocation")String bookLocation,
            @RequestParam("bookDetail")String bookDetail,
            @RequestParam("bookCount")int bookCount,
            @RequestParam("bookCategoryId")int bookCategoryId,
            @RequestParam("bookId")int bookId

    ){
        int x = bookService.updateShareBook(isbn,bookName,bookAuthor,bookLocation,bookDetail,bookCount,bookCategoryId,bookId);

        return 1;
    }

    /**
     * 用户自己删除自己的图书，即取消共享
     *     deleteBookByBookId
     */
    @ResponseBody
    @RequestMapping("/deleteBookByBookId")
    public int deleteBookByBookId(@RequestParam("bookId")int bookId){
        int x = bookService.deleteBookById(bookId);



        return 1;
    }

    /**
     * 删除图书
     */
    @ResponseBody
    @RequestMapping("/deleteBookByBookIdByAdmin")
    public int deleteBookByBookIdByAdmin(@RequestParam("bookId")int bookId){
        int x = bookService.deleteBookById(bookId);
        return 1;
    }

}
