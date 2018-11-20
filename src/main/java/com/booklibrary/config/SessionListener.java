package com.booklibrary.config;


import com.booklibrary.model.User;
import com.booklibrary.utils.UserList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.*;



@WebListener
public class SessionListener implements HttpSessionListener, HttpSessionAttributeListener {
    public static final Logger logger= LoggerFactory.getLogger(SessionListener.class);
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("session创建了");
    }
    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        User user = (User) session.getAttribute("user");
        if (user!=null){
            if (UserList.users.get(user.getUserName())!=null){
                UserList.users.remove(user.getUserName());
            }
        }
        System.out.println("当前用户数量:"+UserList.users.size());
        System.out.println("session销毁了");
    }
    @Override
    public void attributeAdded(HttpSessionBindingEvent se) {
        HttpSession session = se.getSession();
        User user = (User)session.getAttribute("user");
        if (user!=null){
            UserList.users.put(user.getUserName(),user);
        }
        System.out.println("用户数:"+UserList.users.size());

    }
    @Override
    public void attributeRemoved(HttpSessionBindingEvent se) {
        System.out.println("属性删除了");
    }
    @Override
    public void attributeReplaced(HttpSessionBindingEvent se) {
    }
}
