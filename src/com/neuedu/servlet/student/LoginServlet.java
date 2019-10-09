package com.neuedu.servlet.student;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neuedu.model.Student;
import com.neuedu.service.StudentService;
import com.neuedu.service.impl.StudentServiceImpl;

@WebServlet("/student/login")
public class LoginServlet extends HttpServlet{
	StudentService ss = new StudentServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("student login");
		//获取用户名和密码
		String stunum = req.getParameter("stunum");
		String password = req.getParameter("password");
		//调用StudentService 实现学生登录功能
		Student student = ss.login(stunum, password);
		
		if(student == null) { //登录失败
			req.setAttribute("message", "用户名或密码错误");
			req.getRequestDispatcher("/student/login.jsp").forward(req, resp);
			return;
		}
		
		//登录成功
		HttpSession session = req.getSession();
		session.setAttribute("student", student);
		resp.sendRedirect(req.getContextPath() + "/student/index.jsp");
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
