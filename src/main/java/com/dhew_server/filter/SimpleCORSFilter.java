package com.dhew_server.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class SimpleCORSFilter
 */
@WebFilter("/*")
public class SimpleCORSFilter implements Filter {

    /**
     * Default constructor. 
     */
    public SimpleCORSFilter() {
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
	public void doFilter(ServletRequest request, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		 HttpServletResponse response = (HttpServletResponse) res;  
         response.setHeader("Access-Control-Allow-Origin", "*");  
         response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");  
         response.setHeader("Access-Control-Max-Age", "3600");  
         response.setHeader("Access-Control-Allow-Headers", "x-requested-with");  
         chain.doFilter(request, res);  
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
