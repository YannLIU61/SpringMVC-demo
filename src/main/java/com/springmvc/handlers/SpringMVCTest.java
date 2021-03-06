package com.springmvc.handlers;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.entities.User;

@RequestMapping("/springmvc")
@Controller
public class SpringMVCTest {
	private static final String SUCCESS = "success";

	@RequestMapping(value = "/testMethod", method = RequestMethod.POST)
	public String testMethod() {
		System.out.println("testMethod");
		return SUCCESS;
	}

	@RequestMapping(value = "/testParam", params = { "username", "age!=18" })
	public String testParameter() {
		System.out.println("test Parameter");
		return SUCCESS;
	}

	@RequestMapping(value = "/testRest", method = RequestMethod.POST)
	public String testRestPost() {
		System.out.println("test Rest POST");
		return SUCCESS;
	}

	/*
	 * Tomcat no longer supports HTTP PUT access to JSP pages, only GET, POST, and
	 * HEAD, starting with Tomcat version 8.x, as specified in the JCP specification
	 * (JSP2.3).
	 */
	@RequestMapping(value = "/testRest/{id}", method = RequestMethod.PUT)
	public String testRestPut(@PathVariable Integer id) {
		System.out.println("test Rest PUT " + id);
		return SUCCESS;
	}

	@RequestMapping(value = "/testRest/{id}", method = RequestMethod.DELETE)
	public String testRestDelete(@PathVariable Integer id) {
		System.out.println("test Rest DELETE " + id);
		return SUCCESS;
	}

	@RequestMapping(value = "/testRest/{id}", method = RequestMethod.GET)
	public String testRestGet(@PathVariable Integer id) {
		System.out.println("test Rest GET " + id);
		return SUCCESS;
	}

	/**
	 * @RequestMapping 映射请求参数 @CookieValue @RequestHeader
	 * @param name
	 * @param age
	 * @return
	 */
	@RequestMapping(value = "/testRequestParam")
	public String testRequestParam(@RequestParam(value = "username") String name,
			@RequestParam(value = "age", required = false, defaultValue = "0") int age) {
		System.out.println(name + " " + age);
		return SUCCESS;
	}

	/**
	 * Spring MVC 会按请求的参数名和POJO属性名进行自动匹配, 自动为该对象填充属性. 支持级联属性
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/testPojo")
	public String testPojo(User user) {
		System.out.println(user);
		return SUCCESS;
	}

	/**
	 *  可以使用servlet原生api作为目标函数参数 HttpServletRequest HttpServletResponse HttpSession
	 * InputStream OutputStream Reader Writer
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "/testServletApi")
	public void testServletApi(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.getWriter().write("Test Servlet Api");
	}

	/**
	 * 处理数据模型
	 * 一:
	 * SpringMVC ModelAndView 会把model中的数据对象放在request域的对象中
	 * @return
	 */
	@RequestMapping(value = "/testModelAndView")
	public ModelAndView testModelAndView() {
		String viewName = SUCCESS;
		ModelAndView modelAndView = new ModelAndView(viewName);
		modelAndView.addObject("user", "Yan LIU");
		return modelAndView;
	}
	/**
	 * 二:
	 * 可以添加Map类型(也可以是model类型活着modelmap类型)
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/testMap")
	public String testMap(Map<String, Object> map) {
		map.put("names", Arrays.asList("bonjour", "salut","bonsoir"));
		return SUCCESS;
	}
	
	/**
	 * 有ModelAttribute标记的方法会在每个目标方法执行前被springmvc调用
	 * @param id
	 * @param model
	 */
	@ModelAttribute
	public void getModel(@RequestParam(value = "id",required=false) Integer id, Model model) {
		System.out.println("Model Attribute----");
		if(id!=null) {
			User user = new User(1,"LIU","y@a","aaa",24);
			System.out.println("Gets model from database:"+user);
			model.addAttribute("user", user);
		}
	}
	/**
	 * 运行流程:
	 * 1. 执行@ModelAttribut 注解修饰的方法: 从数据库中取出对象, 把对象放在implicModel的 Map(Model)中. 键为:user(也可以自己设置 model.addAttribute("abc", user);)
	 * 1.1 如果键改动可以在目标方法参数前修饰 如: public String testModelAttribute(@ModelAttribute(“abc”) User user)
	 * 2. SpringMVC 先从implicModel的Map中取出User对象, (如果没有再尝试去@SessionAttribute中找, 没有的话会抛异常, )并把表单的请求参数付给User对象对应属性
	 * 3. SpringMVC 把上述对象传入目标方法的参数.
	 * 
	 * 注意⚠️: 放在Model时 的键名
	 * @param user
	 * @return
	 */
	@RequestMapping(value="/testModelAttribute",method = RequestMethod.POST )
	public String testModelAttribute(User user) {
		
		System.out.println("Modifier model: "+user);
		return SUCCESS;
	}
	
	@RequestMapping(value = "/testView")
	public String testView() {
		System.out.println("Test View");
		return "helloView";
	}

}
