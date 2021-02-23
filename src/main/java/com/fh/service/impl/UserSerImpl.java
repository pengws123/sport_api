package com.fh.service.impl;

import com.fh.dao.JueseDao;
import com.fh.dao.UserDao;
import com.fh.entity.po.Juese;
import com.fh.entity.po.UserParss;
import com.fh.entity.vo.Paramss;
import com.fh.service.UserSer;
import com.fh.utils.JWT;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserSerImpl implements UserSer {

    @Resource
    private UserDao userDao;

    @Resource
    private JueseDao jueseDao;
    @Override
    public Map loginuser(String realName,String password) {

        Map map = new HashMap();

       UserParss us= userDao.loginuser(realName);
       if(us!=null){
           if(us.getPassword().equals(password)){
               //登录成功

               Map user=new HashMap();
               user.put("realName",realName);
               user.put("password",password);
               String token = JWT.sign(user, 600*30);
               map.put("mags",1);
               map.put("data",token);
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

    @Override
    public Map queryuser(Paramss param) {
        Map rs =new HashMap();
        Integer count=userDao.querycount(param);
        rs.put("count",count);
        List<UserParss> list = userDao.queryuser(param);
        rs.put("list",list);
        return rs;
    }

    @Override
    public void deleteuser(Integer id) {
        userDao.deleteuser(id);
    }

    @Override
    public UserParss selectuser(Integer id) {
        UserParss user =userDao.selectuser(id);
        return user;
    }

    @Override
    public void updateuser(UserParss user) {
        userDao.updateuser(user);
    }

    @Override
    public List<Juese> queryuserjue(Integer uid) {
        List<Juese> list=jueseDao.queryuserjue(uid);
        return list;
    }

    @Override
    public void saveuserjue(Integer uid,String rid) {
    List<Juese> list = new ArrayList<>();
        jueseDao.deletejuese(uid);
        String[] split = rid.split(",");
        for (int i = 0; i <split.length ; i++) {
            Juese ro=new Juese();
            ro.setUid(uid);
            ro.setRid(Integer.parseInt(split[i]));
            list.add(ro);
        }
        jueseDao.saveuserjue(list);
    }
}
