package com.fh.controller;

import com.fh.entity.po.SporyName;
import com.fh.entity.vo.Paramss;
import com.fh.entity.vo.ResponseData;
import com.fh.service.SpNaSer;
import com.fh.utils.FileSaveUtils;
import com.fh.utils.OsFileSaveUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping("api/name")
public class SpnmContro {
    @Resource
    private SpNaSer spnaser;
    /*
     * 查询商品名字信息
     * 路径： http://localhost:8080/api/name/queryspname
     * 请求方式 get
     *
     * 参数
     * start （当前页）  （必选）
     *
     * size （每页条数） （必选）
     *bandE     (首字母)
     * name   (按照名字准确查询)  （可选项）
     *ord       (排序)
     * birthdaymin   生产时间  最小值  （可选）
     *
     * birthdaymax   生产时间 最大值  （可选）
     *
     *
     * 返回值
     *  code  info   date:{list  count}
     *
     * */
    @GetMapping("queryspname")
    public ResponseData queryspname(Paramss param){
        if(param.getStart()==null){
            return ResponseData.error(400,"起始小标不能为空");
        }
        if(param.getSize()==null){
            return ResponseData.error(400,"每页条数不能为空");
        }
        Map map = spnaser.queryspname(param);
        return ResponseData.success(map);
    }
    /*
     * 删除商品信息
     * 路径： http://localhost:8080/api/name/delspname
     * 请求方式 post
     *
     * 参数
     *  Integer 类型 id （
     *
     *返回值  code  info
     * */
    @PostMapping("delspname")
    public ResponseData delspname(Integer id){
        if(id==null){
            return ResponseData.error(400,"起始小标不能为空");
        }
        spnaser.delspname(id);
        return ResponseData.success(null);
    }
    /*
     * 根据id查询商品名字信息
     * 路径： http://localhost:8080/api/name/selectspname
     * 请求方式 post
     *
     * 参数
     *  Integer 类型 id
     *
     *  返回值  code  info  data;{data:na}
     * */
    @PostMapping("selectspname")
    public  ResponseData selectspname(Integer id){
        if(id==null){
            return ResponseData.error(400,"起始小标不能为空");
        }
        SporyName na= spnaser.selectspname(id);
        return ResponseData.success(na);
    }
    /*
     * 修改商品信息
     * 路径： http://localhost:8080/api/name/updatespname
     * 请求方式 post
     *
     * 参数
     *  SporyName   对象
     *
     *  返回值  code  info
     * */
    @PostMapping("updatespname")
    public  ResponseData updatespname(SporyName spname){
        if(spname==null){
            return ResponseData.error(400,"起始小标不能为空");
        }
        spname.setUpdateDate(new Date());
        spnaser.updatespname(spname);
        return ResponseData.success(null);
    }
    /*
     * 新增商品信息
     * 路径： http://localhost:8080/api/name/savespname
     * 请求方式 post
     *
     * 参数
     *  SporyName   对象
     *
     *  返回值  code  info
     * */
    @PostMapping("savespname")
    public  ResponseData savespname (SporyName spname){
        if(spname==null){
            return ResponseData.error(400,"起始小标不能为空");
        }
        spname.setIsdel(0);
        spname.setCreateDate(new Date());
        spnaser.savespname(spname);
        return ResponseData.success(null);
    }
    /*
     * 图片信息
     * 路径： http://localhost:8080/api/name/updateFile
     * 请求方式 post
     *
     * 参数
     *  String 类型 image （当前页）  （必选）
     *
     *
     * */
    @PostMapping("updateFile")
    public  ResponseData updateFile(MultipartFile file) throws IOException {
        //处理新名称
        String originalFilename = file.getOriginalFilename();
        //防止中文引起的错误
        String newName= UUID.randomUUID().toString()+originalFilename.substring(originalFilename.lastIndexOf("."));
        //存储路径
        newName="imgs/"+newName;
        return ResponseData.success(OsFileSaveUtil.uploadFile(file.getInputStream(),newName));

    }
}
