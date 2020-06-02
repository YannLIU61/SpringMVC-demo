package com.springmvc.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 添加自定义的Interceptor拦截器- 在SpringMVC 的IOC中添加
 * 可以用作:权限,日志,事务等
 * @author yann
 *
 */
public class SecondInterceptor implements HandlerInterceptor {

	/**
	 * 该方法在目标方法之前被调用
	 * 若返回true:则调用后续的拦截器和目标方法
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("[Second-preHandle]");
		return true;
	}

	/**
	 * 目标方法调用后,视图渲染前
	 * 可以对请求域中的属性或视图作出修改
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("[Second-postHandle]");
	}

	/**
	 * 视图渲染后:
	 * 释放资源
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("[Second-afterCompletion]");
	}

}
