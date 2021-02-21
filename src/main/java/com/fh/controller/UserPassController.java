package com.fh.controller;

import com.fh.entity.po.Juese;
import com.fh.entity.po.UserParss;
import com.fh.entity.vo.Paramss;
import com.fh.entity.vo.ResponseData;
import com.fh.service.UserSer;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
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
         user.setCreateDate(new Date());
         Map map=userser.saveuser(user);
         return ResponseData.success(map);
     }
    /*
     * 查询用户信息
     * 路径： http://localhost:8080/api/user/queryuser
     * 请求方式 get
     *
     * 参数
     *
     *
     *
     * start （当前页）  （必选）
     *
     * size （每页条数） （必选）
     *
     * 返回值
     *  code  info   date:{list  count}
     *
     * */
    @GetMapping("queryuser")
    public ResponseData queryuser (Paramss param){
        if(param.getStart()==null){
            return ResponseData.error(400,"起始小标不能为空");
        }
        if(param.getSize()==null){
            return ResponseData.error(400,"每页条数不能为空");
        }
        Map map = userser.queryuser(param);
        return ResponseData.success(map);
    }
    /*
     * 删除角色信息
     * 路径： http://localhost:8080/api/user/deleteuser
     * 请求方式 get
     *
     * 参数
     * id
     *
     * 返回值
     *  code  info   无
     *
     * */
    @PostMapping("deleteuser")
    public ResponseData deleteuser(Integer id){
        if(id==null){
            return ResponseData.error(400,"id不能为空");
        }
        userser.deleteuser(id);
        return ResponseData.success(null);
    }
    /*
     * 根据id查询角色信息
     * 路径： http://localhost:8080/api/user/selectuser
     * 请求方式 get
     *
     * 参数
     * id
     *
     * 返回值
     *  code  info   无
     *
     * */
    @PostMapping("selectuser")
    public ResponseData selectuser(Integer id){
        if(id==null){
            return ResponseData.error(400,"id不能为空");
        }
        UserParss user=userser.selectuser(id);
        return ResponseData.success(user);
    }
    /*
     *修改用户信息
     * 路径： http://localhost:8080/api/user/updateuser
     * 请求方式 post
     *
     * 参数
     * Userjuese
     *
     * 返回值
     *  code  info   无
     *
     * */
    @PostMapping("updateuser")
    public ResponseData updateuser(UserParss user){
        if(user==null){
            return ResponseData.error(400,"对象不能为空");
        }
        user.setUpdateDate(new Date());
        userser.updateuser(user);
        return ResponseData.success(null);
    }
    /*
     * 查询用户角色信息
     * 路径： http://localhost:8080/api/user/queryuserjue
     * 请求方式 post
     *
     * 参数   uid
     *
     * 返回值
     *  code  info   date:{list  count}
     *
     * */
    @PostMapping("queryuserjue")
    public ResponseData queryuserjue (Integer uid){
        if(uid==null){
            return ResponseData.error(400,"uid不能为空");
        }
        List<Juese> map = userser.queryuserjue(uid);
        return ResponseData.success(map);
    }
    /*
     * 用户授角色信息
     * 路径： http://localhost:8080/api/user/saveuserjue
     * 请求方式 post
     *
     * 参数   Juese
     *
     * 返回值
     *  code  info
     *
     * */
    @PostMapping("saveuserjue")
    public ResponseData saveuserjue(Integer uid,String rid){
        if(uid==null){
            return ResponseData.error(400,"juese不能为空");
        }
        if(rid==null){
            return ResponseData.error(400,"juese不能为空");
        }
          userser.saveuserjue(uid,rid);
        return ResponseData.success(null);
    }
}
