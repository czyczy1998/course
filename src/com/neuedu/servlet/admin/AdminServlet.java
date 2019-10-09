package com.neuedu.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neuedu.service.AdminService;
@WebServlet("/admin/login")
public class AdminServlet extends HttpServlet{
	AdminService as = new AdminService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		/*在servlet 中的绝对路径（/）分成两种
		 * 转发
		 * 	转发的 【/】表示的是 localhost:8080/项目名称/
		 * 重定向的绝对路径
		 * 	重定向中的【/】表示的是 localhost:8080/
		 * 	String path = this.getServletContext().getContextPath(); //course
		 *	resp.sendRedirect(path + "/admin/login.jsp");
		 */
		boolean login = as.login(username, password);
		if(!login) { //登录失败
			req.setAttribute("message", "用户名或密码错误");
			req.getRequestDispatcher("/admin/login.jsp").forward(req, resp);
		
			return;
		}
		//登录成功
		
		HttpSession session = req.getSession();
		session.setAttribute("username", username);
		
		
		String path = this.getServletContext().getContextPath();
		resp.sendRedirect(path + "/admin/index.jsp");
	}
}
