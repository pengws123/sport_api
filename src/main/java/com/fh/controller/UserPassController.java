package com.fh.controller;

import com.fh.entity.po.UserParss;
import com.fh.entity.vo.ResponseData;
import com.fh.entity.vo.UserParams;
import com.fh.service.UserSer;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("api/user")
public class UserPassController {

    @Resource
    private UserSer userser;
    /*
     * 用户登录
     * 路径： http://localhost:8080/api/user/loginuser
     * 请求方式 post
     * 参数  user
     * 返回值
     *  code  info   date:{mags}
     *
     * */

    @PostMapping("loginuser")
    public ResponseData loginuser(UserParss user){
        if (user==null){
            return ResponseData.error(400,"spo没有值");
        }
        Map map= userser.loginuser(user);
        return ResponseData.success(map);
    }
     /*  新增用户

    路径    http://localhost:8080/api/user/saveuser

    post请求

    参数    user

    返回值   */
     @PostMapping("saveuser")
     public ResponseData saveuser(UserParss user){
         if (user==null){
             return ResponseData.error(400,"spo没有值");
         }
         Map map=userser.saveuser(user);
         return ResponseData.success(map);
     }
}
