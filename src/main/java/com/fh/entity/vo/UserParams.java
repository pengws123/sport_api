package com.fh.entity.vo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

// 用户的相关搜索条件
public class UserParams {
    private  Integer page;

    private  Integer limit;

    private Integer startIndex;
    private  String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthdayStart;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthdayEnd;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthdayStart() {
        return birthdayStart;
    }

    public void setBirthdayStart(Date birthdayStart) {
        this.birthdayStart = birthdayStart;
    }

    public Date getBirthdayEnd() {
        return birthdayEnd;
    }

    public void setBirthdayEnd(Date birthdayEnd) {
        this.birthdayEnd = birthdayEnd;
    }
    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(Integer startIndex) {
        this.startIndex = startIndex;
    }
}
