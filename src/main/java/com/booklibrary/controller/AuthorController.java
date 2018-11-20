package com.booklibrary.controller;

import com.booklibrary.model.Author;
import com.booklibrary.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class AuthorController {
    @Autowired
    AuthorService authorService;


    @RequestMapping("/addAuthor")
    public String addAuthor(String aName, Model model){
        List<Author> author = authorService.findAuthor(new Author(null, aName));

        if (author.size()>0){
            model.addAttribute("message","添加失败");

        }else{
                boolean flag = authorService.addAuthor(new Author(null, aName));

                if (!flag){
                    model.addAttribute("message","添加失败");

                }else{
                    model.addAttribute("message","添加成功");
                }
        }
        return "Author";
    }


    @RequestMapping("/index")
    public String index(HttpServletRequest request, HttpServletResponse response){
        String userName =(String) request.getSession().getAttribute("userName");
        if(userName!=null){
            System.out.println(userName);
        }
        return "index";
    }
    @RequestMapping("/Author")
    public String Author(){
        return "Author";
    }

}

