package com.parking.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class loginFilter
 */
public class loginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public loginFilter() {
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
		
		
		HttpServletRequest requestOne = (HttpServletRequest) request;
		HttpServletResponse responseOne = (HttpServletResponse) response;
		
		// Get the HttpSession object.
		HttpSession session = requestOne.getSession();	
		String email=(String)session.getAttribute("email"); 
		    if (email!=null) {
		    	// pass the request along the filter chain
		          chain.doFilter(requestOne, responseOne);
		      } 
		    else {
		    	//if not logged in redirect to login page
		          responseOne.sendRedirect("logIn.jsp");
		      } 

		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
