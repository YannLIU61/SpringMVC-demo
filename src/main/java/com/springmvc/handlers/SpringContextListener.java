package com.springmvc.handlers;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Application Lifecycle Listener implementation class SpringContextListener
 *
 */
public class SpringContextListener implements ServletContextListener {

	/**
	 * Default constructor.
	 */
	public SpringContextListener() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
	}

	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent arg0) {
		ServletContext servletContext = arg0.getServletContext();
		String configLocation = servletContext.getInitParameter("configLocation");
		ApplicationContext ac = new ClassPathXmlApplicationContext(configLocation);
		servletContext.setAttribute("ApplicationContext", ac);
	}

}
