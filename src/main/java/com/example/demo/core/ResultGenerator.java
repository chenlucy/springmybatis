/*  
 * Copyright 2010-2017 Tocean Group.  
 * 版权：商业代码，未经许可，禁止任何形式拷贝、传播及使用
 * 文件名：ResultGenerator.java
 * 描述：  
 * 修改人：Arber.Lee  
 * 修改时间：2018年5月9日  
 * 跟踪单号：  
 * 修改单号：  
 * 修改内容：  
 */
package com.example.demo.core;

/**
 * 响应结果生成工具
 */
public class ResultGenerator {
	private static final String DEFAULT_SUCCESS_MESSAGE = "SUCCESS";

	public static Result genSuccessResult() {
		return new Result().setCode(ResultCode.SUCCESS).setMessage(DEFAULT_SUCCESS_MESSAGE);
	}

	public static Result genSuccessResult(Object data) {
		return new Result().setCode(ResultCode.SUCCESS).setMessage(DEFAULT_SUCCESS_MESSAGE)
				.setData(data);
	}

	public static Result genFailResult(String message) {
		return new Result().setCode(ResultCode.FAIL).setMessage(message);
	}
}
