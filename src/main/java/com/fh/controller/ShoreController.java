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
    private ResponseData getshore(){
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
    private  ResponseData saveshore(ShoreXian shore){
         if(shore==null){
             return ResponseData.error(400,"pid没有值");
         }
         shore.setIsDel(0);
         shore.setCreateDate(new Date());
         shoreser.saveshore(shore);
         return ResponseData.success(null);
     }
}
