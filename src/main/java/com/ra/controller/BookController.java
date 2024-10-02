package com.ra.controller;

import com.ra.model.entity.Book;
import com.ra.model.service.book.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;
    @GetMapping
    public String index(Model model){
        List<Book> books = bookService.findAll();
        model.addAttribute("books",books);
        return "book/index";
    }
    @GetMapping("/add")
    public String add(){
        //trả về form thêm mới
        return "book/add";
    }
    @PostMapping("/add")
    public String create(){
        // lấy dữ liệu ừ form
        // gọi đến service thêm mới
    }
    @GetMapping("/edit/{id}")
    public String edit(){
        //trả về form thêm mới
        return "book/add";
    }
    @PostMapping("/edit/{id}")
    public String update(){
        // lấy dữ liệu ừ form
        // gọi đến service thêm mới
        return "book/add";
    }
}
