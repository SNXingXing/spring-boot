package com.booklibrary.controller;

import com.booklibrary.model.User;
import com.booklibrary.service.UserService;
import com.booklibrary.utils.UserList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {
    @Autowired
    UserService userService;

    @GetMapping("/login")
    public String login(Model model, HttpSession session) {
        //如果这不新建一个User对象 传过去, 前台thymeleaf 模板不会认识这个对象
        User user = new User();
        model.addAttribute("User", user);
        return "login";
    }

    @GetMapping("/regist")
    public String regist(Model model) {
        //如果这不新建一个User对象 传过去, 前台thymeleaf 模板不会认识这个对象
        User user = new User();
        model.addAttribute("User", user);
        return "regist";
    }

    @PostMapping(value = "/loginHandler", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String loginHandler(@ModelAttribute(value = "User") User user, HttpSession session) {
        System.out.println("传过来的user" + user);
        User users = userService.findUserByLogin(user);
        if (users != null) {
            System.out.println("处理页面user:" + users);
            session.setAttribute("user", users);
            return "登录成功!" + "<a herf=\"index.html\"></a>";

        }
        return "账号或密码错误!";
    }

    /**
     * @ModelAttribute(value = "User")表示从页面收到的对象
     * @param user
     * @param request
     * @return
     */
    @PostMapping("/registHandler")
    @ResponseBody
    public String registHandler(@ModelAttribute(value = "User") User user, HttpServletRequest request) {

        String password2 = request.getParameter("password2");

        if (password2.equals(user.getUserPassword())) {
            if (userService.addUser(user)) {
                return "注册成功";
            }
        } else {
            return "两次密码输入不同";
        }
        return "注册失败";
    }

    @GetMapping("/userUpdate")
    public String userUpdate(HttpSession session, Model model) {
        //如果这不新建一个User对象 传过去, 前台thymeleaf 模板不会认识这个对象
        User user = (User) session.getAttribute("user");
        model.addAttribute("User", user);
        return "userUpdate";
    }

    @PostMapping("/userUpdateHandler")
    @ResponseBody
    public String userUpdateHandler(@ModelAttribute(value = "user") User user, HttpServletRequest request) {
        //获取新密码
        String newPassword = request.getParameter("newPassword");
        //获取修改前用户信息
        User user1 = (User) request.getSession().getAttribute("user");
        //比较输入的旧密码是否和修改前的密码相等
        if (user1.getUserPassword().equals(user.getUserPassword())) {
            //把用户原用户密码在前端修改
            user1.setUserPassword(newPassword);
            //通过业务逻辑层给数据库修改
            if (userService.modifUser(user1)) {
                //把修改了的用户信息重新存入session
                request.getSession().setAttribute("user",user1);
                return "修改成功";
            }
        }else{
            return "旧密码错误";
        }

        return "修改失败";
    }


    @RequestMapping("/userList")
    public String userList(Model model){
        Map<String,User> users= UserList.users;
        model.addAttribute("userList",users);
        return "userList";
    }

}
