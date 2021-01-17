package com.fh.entity.vo;
//自定义的规范     ajax的请求  返回的都是json数据

//  {"status":,"info":,"data":}
public class ResponseData {
	private Integer code;

	private String info;

	private Object data;

	private ResponseData() {

	}


	public static ResponseData success(Object data) {
		ResponseData rs=new ResponseData();
		rs.setInfo("处理成功");
		rs.setCode(200);
		rs.setData(data);
		return  rs;
	}

	public static ResponseData error(Integer code, String info) {
		ResponseData rs=new ResponseData();
		rs.setInfo(info);
		rs.setCode(code);
		return  rs;
	}


	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}
