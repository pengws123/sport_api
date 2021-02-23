package com.fh.controller;

import com.fh.entity.po.SportType;
import com.fh.entity.vo.ResponseData;
import com.fh.service.SpoSer;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("api/type")
public class SpoContro {
    @Resource
    private SpoSer sposer;

    /*1    查询所有的分类数据
    路径   localhost:8080/api/type/getData

    get请求

            参数

    返回值   {"code":200,"inif":"提示",data:[{*}]}*/
     @GetMapping("getData")
    public ResponseData getData(){

         List<SportType> spor= sposer.getData();
         return ResponseData.success(spor);
     }
   /* 查询指定pid的数据

    路径    localhost:8080/api/type/getDataByPid

    get请求

    参数    Pid

    返回值   {"code":200,"inif":"提示",data:[{*}]}*/
   @GetMapping("getDataByPid")
    public  ResponseData getDataByPid(Integer pid){
       if (pid==null){
           return ResponseData.error(400,"pid没有值");
       }
       List<SportType> spor= sposer.getDataByPid(pid);
       return ResponseData.success(spor);
   }

    /*  新增分类

    路径    localhost:8080/api/type/add

    post请求

    参数    pid    name

    返回值    {code:"",inif:"",data:新增的id}*/
    @PostMapping("add")
    public ResponseData add(SportType spo){
        if (spo==null){
            return ResponseData.error(400,"spo没有值");
        }
        spo.setCreateDate(new Date());
        spo.setIsDel(0);
        Integer spor= sposer.add(spo);
        return ResponseData.success(spor);
    }
   /* 修改通过id进行查询

    路径    localhost:8080/api/type/updateById

    post请求

    参数   id （必传）     pid   name  isDel

    返回值     {code:"",inif:"",data:}*/
   @PostMapping("updateById")
   public ResponseData updateById(Integer id){
       if (id==null){
           return ResponseData.error(400,"id没有值");
       }
       SportType spor= sposer.updateById(id);
       return ResponseData.success(spor);
   }
   /* 修改

    路径    localhost:8080/api/type/update

    post请求

    参数   id （必传）        name

    返回值     {code:"",inif:""}*/
   @PostMapping("update")
   public ResponseData update(SportType spo){
       if (spo==null){
           return ResponseData.error(400,"id没有值");
       }
       spo.setUpdateDate(new Date());
        sposer.update(spo);
       return ResponseData.success(null);
   }
   /* 删除

    路径    localhost:8080/api/type/updateById

    post请求

    参数   id （必传）     pid   name  isDel

    返回值     {code:"",inif:"",data:}*/
   @PostMapping("delsorp")
    public ResponseData delsorp(Integer id){
       if (id==null){
           return ResponseData.error(400,"id没有值");
       }
       sposer.delsorp(id);
       return ResponseData.success(null);
   }
}
