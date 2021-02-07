package com.fh.controller;

import com.fh.entity.po.Userjuese;
import com.fh.entity.vo.Paramss;
import com.fh.entity.vo.ResponseData;
import com.fh.service.UserjueseSer;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("api/userjuese")
public class UserjueseContorller {
    @Resource
    private UserjueseSer userjueseSer;
    /*
     * 查询角色信息
     * 路径： http://localhost:8080/api/userjuese/queryjuese
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
    @GetMapping("queryjuese")
    private ResponseData queryjuese (Paramss param){
        if(param.getStart()==null){
            return ResponseData.error(400,"起始小标不能为空");
        }
        if(param.getSize()==null){
            return ResponseData.error(400,"每页条数不能为空");
        }
        Map map = userjueseSer.queryspoper(param);
        return ResponseData.success(map);
    }
    /*
     * 新增角色信息
     * 路径： http://localhost:8080/api/userjuese/savejuese
     * 请求方式 get
     *
     * 参数
     * Userjuese
     *
     * 返回值
     *  code  info   无
     *
     * */
    @PostMapping("savejuese")
    private ResponseData savejuese(Userjuese juese){
        if(juese==null){
            return ResponseData.error(400,"起始小标不能为空");
        }
        juese.setIsDel(0);
        juese.setCreateDate(new Date());
        userjueseSer.savejuese(juese);
        return ResponseData.success(null);
    }
}
