package com.zkzong.jdoc.controller;

import com.zkzong.jdoc.form.PageForm;
import com.zkzong.jdoc.result.ApiResult;
import com.zkzong.jdoc.result.book.BookDetailVO;
import com.zkzong.jdoc.result.book.BookVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 图书接口
 *
 * @author yeguozhong yedaxia.github.com
 */
@RequestMapping("/api/book/")
@RestController
public class BookController {

    /**
     * 图书列表
     * @param pageForm
     * @return
     */
    @GetMapping("list")
    public ApiResult<result.PageResult<BookVO>> getBookList(PageForm pageForm){
        return null;
    }

    /**
     * 图书详情
     * @param id 图书ID
     * @return
     */
    @GetMapping("book-detail")
    public ApiResult<BookDetailVO> getBookDetail(@RequestParam Long id){
        return null;
    }

    /**
     * 删除图书
     * @param bookId 图书ID
     * @return
     */
    @GetMapping("del-book")
    public ApiResult<BookVO> delBook(@RequestParam  Long bookId){
        return null;
    }
}
