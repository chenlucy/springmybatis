/*  
 * Copyright 2010-2017 Tocean Group.  
 * 版权：商业代码，未经许可，禁止任何形式拷贝、传播及使用
 * 文件名：ResultCode.java
 * 描述：  
 * 修改人：Arber.Lee  
 * 修改时间：2018年5月9日  
 * 跟踪单号：  
 * 修改单号：  
 * 修改内容：  
 */
package com.example.demo.core;

/**
 * 响应码枚举，参考HTTP状态码的语义
 */
public enum ResultCode {
	SUCCESS(200), // 成功
	FAIL(400), // 失败
	UNAUTHORIZED(401), // 未认证（签名错误）
	NOT_FOUND(404), // 接口不存在
	INTERNAL_SERVER_ERROR(500);// 服务器内部错误

	private final int code;

	ResultCode(int code) {
		this.code = code;
	}

	public int code() {
		return code;
	}
}
