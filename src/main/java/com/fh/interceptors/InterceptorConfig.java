package com.fh.interceptors;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration//声明是配置类
public class InterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //释放跨域的拦截器
        InterceptorRegistration kuayu = registry.addInterceptor(new KuaYuInterceptors());
        //设置拦截路径
        kuayu.addPathPatterns("/**");
        //登录的拦截器
        InterceptorRegistration login = registry.addInterceptor(new LoginInterceptors());
        //设置拦截的路径
        login.addPathPatterns("/**");
        login.excludePathPatterns("/api/user/loginuser");//所有路径都被拦截
    }
}
