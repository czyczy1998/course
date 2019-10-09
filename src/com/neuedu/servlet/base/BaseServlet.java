package com.neuedu.servlet.base;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class BaseServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		Class<? extends BaseServlet> clazz = this.getClass();
		
		try {
			Method m = clazz.getDeclaredMethod(method, HttpServletRequest.class,HttpServletResponse.class);
			m.setAccessible(true);
			String path = (String)m.invoke(this, request,response);
			if(path != null && !"".equals(path)) {
				request.getRequestDispatcher(path).forward(request, response);				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}
	
}
