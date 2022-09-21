package org.example.mg.mapper;

import org.example.mg.entity.Book;
import org.example.mg.entity.BookExample;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Author: zong
 * @Date: 2020/1/17
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class BookMapperTest {

    @Autowired
    private BookMapper bookMapper;

    @Test
    public void selectByExample() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = dateFormat.parse("2019-01-01");
        Date date2 = dateFormat.parse("2021-01-01");
        BookExample bookExample = new BookExample();
        bookExample.createCriteria().andCreateTimeBetween(date1, date2);
        List<Book> books = bookMapper.selectByExample(bookExample);
        System.out.println(books);
    }
}