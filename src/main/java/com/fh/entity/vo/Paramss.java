package com.fh.entity.vo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

// 业务bean
public class Paramss {
    // start （必传的）
    // size (必传的)
    // name
    //  birthdaymin（yyyy-MM-dd）
    //  birthdaymax（yyyy-MM-dd）
    //agemin
    //agemax
        private String bandE ; //首字母
        private Integer ord ;  //排序字段
        private  Integer start;
        private Integer size;
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        private Date birthdaymin;
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        private Date birthdaymax;
         private String  nameCH  ;// 属性中文名   颜色
        private String name;
        private Double primin;
        private Double primax;
        private Integer type;
        private Integer area;
        private String [] peoples;


    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Date getBirthdaymin() {
        return birthdaymin;
    }

    public void setBirthdaymin(Date birthdaymin) {
        this.birthdaymin = birthdaymin;
    }

    public Date getBirthdaymax() {
        return birthdaymax;
    }

    public void setBirthdaymax(Date birthdaymax) {
        this.birthdaymax = birthdaymax;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrimin() {
        return primin;
    }

    public void setPrimin(Double primin) {
        this.primin = primin;
    }

    public Double getPrimax() {
        return primax;
    }

    public void setPrimax(Double primax) {
        this.primax = primax;
    }

    public String[] getPeoples() {
        return peoples;
    }

    public void setPeoples(String[] peoples) {
        this.peoples = peoples;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }


    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public String getBandE() {
        return bandE;
    }

    public void setBandE(String bandE) {
        this.bandE = bandE;
    }

    public Integer getOrd() {
        return ord;
    }

    public String getNameCH() {
        return nameCH;
    }

    public void setNameCH(String nameCH) {
        this.nameCH = nameCH;
    }

    public void setOrd(Integer ord) {
        this.ord = ord;
    }
}
