package com.fh.interceptors;

import com.alibaba.fastjson.JSONObject;
import com.fh.utils.JWT;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LoginInterceptors implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        String token = request.getParameter("token");
        if (token==null){
            Map rs= new HashMap();
            rs.put("code",500);
            rs.put("message","que shao  token");
            response.getWriter().write(JSONObject.toJSONString(rs));
            return  false;
        }
        Map map = JWT.unsign(token, Map.class);
        if (map==null){
            Map rs= new HashMap();
            rs.put("code",400);
            rs.put("message","reeor  token");
            response.getWriter().write(JSONObject.toJSONString(rs));
            return  false;
        }
        return true;
    }
}
