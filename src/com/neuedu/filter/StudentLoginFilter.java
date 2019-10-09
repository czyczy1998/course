package com.neuedu.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/student/*")
public class StudentLoginFilter implements Filter{
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("sadfsadfsafd");
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)resp;
		
		String uri = request.getRequestURI();
		
		if(uri.contains("login")) {
			chain.doFilter(request, response);
			return;
		}
		HttpSession session = request.getSession();
		Object object = session.getAttribute("student");
		if(object == null) {
			request.getRequestDispatcher("/student/login.jsp").forward(request, response);
			return;
		}
		chain.doFilter(request, response);
		
	}
	

	@Override
	public void destroy() {
	
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
