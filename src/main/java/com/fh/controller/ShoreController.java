package com.fh.controller;

import com.fh.entity.po.ShoreXian;
import com.fh.entity.vo.ResponseData;
import com.fh.service.Shoreser;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/xian")
public class ShoreController {
    @Resource
    private Shoreser shoreser;
     /*1    查询所有的分类数据
    路径   localhost:8080/api/xian/getshore

    get请求

            参数

    返回值   {"code":200,"inif":"提示",data:[{*}]}*/
     @GetMapping("getshore")
    private ResponseData getshore(){
         List<ShoreXian> list=shoreser.getshore();
         return ResponseData.success(list);
     }
}
