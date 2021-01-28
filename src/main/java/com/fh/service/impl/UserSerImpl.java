package com.fh.service.impl;

import com.fh.dao.UserDao;
import com.fh.entity.po.UserParss;
import com.fh.service.UserSer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserSerImpl implements UserSer {

    @Resource
    private UserDao userDao;

    @Override
    public Map loginuser(UserParss user) {

        Map map = new HashMap();

       UserParss us= userDao.loginuser(user.getRealName());
       if(us!=null){
           if(us.getPassword().equals(user.getPassword())){
               //登录成功
               map.put("mags",1);
           }
           else {
               //密码不对登录失败
               map.put("mags",2);
           }
       }else{
           //账号不存在
           map.put("mags",3);
       }
        return map;
    }

    @Override
    public Map saveuser(UserParss user) {
        Map map = new HashMap();

        UserParss us= userDao.loginuser(user.getRealName());
        if(us==null){
            //用户不存在 可以注册
                map.put("mags",1);
            userDao.saveuser(user);
        }else{
            //用户已存在  不可以注册
            map.put("mags",2);
        }
        return map;
    }
}
