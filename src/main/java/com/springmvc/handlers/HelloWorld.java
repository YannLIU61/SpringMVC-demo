package com.springmvc.handlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorld {
	/**
	 * 1.使用@RequestMapping 注解来映射请求的URL(除了可以修饰方法,也可以直接修饰类)
	 * 2.返回值回通过视图解析器解析为实际的物理视图, 对于InternalResourceViewResolver 视图解析器, 会做如下的解析:
	 * prefix + returnVal + 后缀 得到实际的物理视图, 然后转发操作
	 * @return
	 */
	@RequestMapping("/helloworld")
	public String hello() {
		System.out.println("Hello World");
		return "success";
	}
}
