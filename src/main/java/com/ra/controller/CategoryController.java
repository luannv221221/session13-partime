package com.ra.controller;

import com.ra.model.dao.book.BookDAO;
import com.ra.model.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CategoryController {

    @RequestMapping("/category")
    public String index(Model model){
        List<Category> categories = new ArrayList<>();
        categories.add(new Category(1,"Hoa Quả",true));
        categories.add(new Category(2,"Rau xanh",true));
        categories.add(new Category(3,"Mỹ Phẩm",true));
        categories.add(new Category(4,"FullSnack",false));
        model.addAttribute("categories",categories);
        return "category/index";
    }
//    @RequestMapping(value = "/add-category",method = RequestMethod.GET)
    @GetMapping("/add-category")
    public String add(){
        return "category/add";
    }
//    @RequestMapping(value = "/add-category",method = RequestMethod.POST)
    @PostMapping("/add-category")
    public String creat(HttpServletRequest request){
        String name = request.getParameter("name");
        System.out.println(name);
        return "category/add";
    }
//    @RequestMapping("/edit")
//    public String edit(HttpServletRequest httpServletRequest){
//        int id = Integer.parseInt(httpServletRequest.getParameter("id"));
//        return "category/edit";
//    }
//    @RequestMapping("/edit")
//    public String edit(@RequestParam("id") int id){
//        System.out.println(id);
//        return "category/edit";
//    }
    @RequestMapping("/edit/{id}")
        public String edit(@PathVariable("id") int id){
        System.out.println(id);
        return "category/edit";
    }
}
