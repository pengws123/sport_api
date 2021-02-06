package com.fh.controller;

import com.fh.entity.vo.Paramss;
import com.fh.entity.vo.ResponseData;
import com.fh.service.UserjueseSer;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
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
}
