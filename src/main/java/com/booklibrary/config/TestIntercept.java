package com.booklibrary.config;

import com.booklibrary.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.logging.Handler;

@Configuration
public class TestIntercept implements WebMvcConfigurer {
    @Bean
    MyHandler myHandler() {
        return new MyHandler();
    }

    public void addInterceptors(InterceptorRegistry registry) {
        //注册拦截器 interceptor
        InterceptorRegistration interceptor = registry.addInterceptor(myHandler());
        //拦截器interceptor 不拦截这些模式的url
        interceptor.excludePathPatterns("/login*");
        interceptor.excludePathPatterns("/regist*");
        interceptor.excludePathPatterns("/error");
        //拦截器interceptor 拦截这些模式的url
        interceptor.addPathPatterns("/*");
    }

    private class MyHandler extends HandlerInterceptorAdapter {
        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
            //从session域中取出当前权限,并检查是否拥有操作此动作的权限
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");

            if (user != null) {
                System.out.println("拦截器页面user"+user);
                return true;
            } else {
                //没有此权限就转向
                String url = "/login";
                response.sendRedirect(url);
            }



           return false;


    }
}
}
