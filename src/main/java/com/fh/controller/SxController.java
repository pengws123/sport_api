package com.fh.controller;

import com.fh.entity.po.SxValue;
import com.fh.entity.vo.ResponseData;
import com.fh.service.SxSer;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("api/sxvalue")
public class SxController {
    @Resource
    private SxSer sxSer;
    /*
     * 查询属性名字信息
     * 路径： http://localhost:8080/api/sxvalue/querysxvalue
     * 请求方式 post
     * 参数  attId
     * 返回值
     *  code  info   date:{list  count}
     *
     * */
    @GetMapping("querysxvalue")
    public ResponseData querysxvalue(Integer attId){

        List<SxValue> sxvalue= sxSer.querysxvalue(attId);
        return ResponseData.success(sxvalue);
    }

 /*  新增分类

    路径    http://localhost:8080/api/sxvalue/savexvalue

    post请求

    参数    pid    name nameCH

    返回值    {code:"",inif:"",data:新增的id}*/
    @PostMapping("savexvalue")
    public  ResponseData savexvalue (SxValue sx){
        if (sx==null){
            return ResponseData.error(400,"spo没有值");
        }
            sx.setIsDel(0);
         sxSer.savexvalue(sx);
        return ResponseData.success(null);
    }

     /* 删除

    路径    http://localhost:8080/api/sxvalue/delxvalue

    post请求

    参数   id （必传）

    返回值     {code:"",inif:"",data:}*/
     @PostMapping("delxvalue")
    public ResponseData delxvalue(Integer id){
         if (id==null){
             return ResponseData.error(400,"id没有值");
         }
         sxSer.delxvalue(id);
         return ResponseData.success(null);
     }

     /* 修改通过id进行查询

    路径    http://localhost:8080/api/sxvalue/selectById

    post请求

    参数   id （必传）

    返回值     {code:"",inif:"",data:}*/
     @PostMapping("selectById")
    public ResponseData selectById(Integer id){
         if (id==null){
             return ResponseData.error(400,"id没有值");
         }
         SxValue sx=  sxSer.selectById(id);
         return ResponseData.success(sx);
     }
     /* 修改

    路径    http://localhost:8080/api/sxvalue/updatexvalue

    post请求

    参数   id （必传）        name nameCH

    返回值     {code:"",inif:""}*/
     @PostMapping("updatexvalue")
    public ResponseData updatexvalue(SxValue sx){
         if (sx==null){
             return ResponseData.error(400,"spo没有值");
         }
         sxSer.updatexvalue(sx);
         return ResponseData.success(null);
     }
}
