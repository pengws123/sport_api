package com.fh.controller;

import com.fh.entity.po.ShoreXian;
import com.fh.entity.vo.ResponseData;
import com.fh.service.Shoreser;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/xian")
public class ShoreController {
    @Resource
    private Shoreser shoreser;
     /*1    查询用户权限的方法
    路径   localhost:8080/api/xian/getshore

    get请求

            参数

    返回值   {"code":200,"inif":"提示",data:[{*}]}*/
     @GetMapping("getshore")
     public ResponseData getshore(){
         List<ShoreXian> list=shoreser.getshore();
         return ResponseData.success(list);
     }
      /*1    新增用户权限的方法
    路径   localhost:8080/api/xian/saveshore

    post请求

        Shoexian  对象    参数

    返回值   无
    */
     @PostMapping("saveshore")
     public  ResponseData saveshore(ShoreXian shore){
         if(shore==null){
             return ResponseData.error(400,"shore没有值");
         }
         shore.setIsDel(0);
         shore.setCreateDate(new Date());
         shoreser.saveshore(shore);
         return ResponseData.success(null);
     }
      /*1    删除用户权限的方法
    路径   localhost:8080/api/xian/deleteshore

    post请求

        id      参数

    返回值   无
    */
      @PostMapping("deleteshore")
      public ResponseData deleteshore(Integer id){
          if(id==null){
              return ResponseData.error(400,"id没有值");
          }
          shoreser.deleteshore(id);
          return ResponseData.success(null);
      }
          /*1    根据Id查询用户权限的方法
    路径   localhost:8080/api/xian/queryshoreId

    post请求

        id      参数

    返回值   {"code":200,"inif":"提示",data:[{*}]}
    */
    @PostMapping("queryshoreId")
    public ResponseData queryshoreId(Integer id){
        if(id==null){
            return ResponseData.error(400,"id没有值");
        }
        ShoreXian shor=shoreser.queryshoreId(id);
        return ResponseData.success(shor);
    }
          /*    修改用户权限的方法
    路径   localhost:8080/api/xian/updateshore

    post请求

        Shoexian    对象   参数

    返回值   {"code":200,"inif":"提示",data:[{*}]}
    */
    @PostMapping("updateshore")
    public ResponseData updateshore(ShoreXian shore){
        if(shore==null){
            return ResponseData.error(400,"shore没有值");
        }
        shore.setUpdateDate(new Date());
        shoreser.updateshore(shore);
        return ResponseData.success(null);
    }
}
