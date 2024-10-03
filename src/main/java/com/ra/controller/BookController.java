package com.ra.controller;

import com.ra.model.entity.Book;
import com.ra.model.service.book.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String add(){
        return "book/add";
    }
    @PostMapping("/add")
    public String create(
            @RequestParam("title") String title,
            @RequestParam("author") String author,
            @RequestParam("price") double price,
            @RequestParam("description") String description
    ){
        Book book = new Book();
        book.setTitle(title);
        book.setAuthor(author);
        book.setDescription(description);
        book.setPrice(price);
        if(bookService.create(book)){
            return "redirect:/book";
        }
        return "book/add";
    }
}
