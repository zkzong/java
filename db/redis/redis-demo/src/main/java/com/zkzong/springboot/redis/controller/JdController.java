package com.zkzong.springboot.redis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JdController {
	
	/**
	 * 需求：返回jd首页
	 */
	@RequestMapping("jdList")
	public String jdList(){
		return "index";
	}

}
