package com.ra.controller;

import com.ra.model.entity.Book;
import com.ra.model.service.book.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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
    public String add(Model model){
        Book book = new Book();
        model.addAttribute("book",book);
        return "book/add";
    }
    @PostMapping("/add")
    public String create(@ModelAttribute Book book){

        if(bookService.create(book)){
            return "redirect:/book";
        }
        return "book/add";
    }
}
