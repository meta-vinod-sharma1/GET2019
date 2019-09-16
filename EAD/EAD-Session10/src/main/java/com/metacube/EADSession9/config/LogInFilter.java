package com.metacube.EADSession9.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Servlet Filter implementation class LogInFilter
**/
@WebFilter("/editProfile")
//@Component
public class LogInFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LogInFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("here");
		HttpServletRequest requestOne = (HttpServletRequest) request;
		HttpServletResponse responseOne = (HttpServletResponse) response;
		// Get the HttpSession object.
		HttpSession session = requestOne.getSession();	
		String email=(String)session.getAttribute("email"); 
		    if (email!=null) {
		          chain.doFilter(requestOne, responseOne);
		          System.out.println("in if");
		      }else{
		    	  responseOne.sendRedirect("login");
		      } 
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("filter Init invoked");
	}

}
