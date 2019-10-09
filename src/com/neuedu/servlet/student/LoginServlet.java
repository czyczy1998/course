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
		//��ȡ�û���������
		String stunum = req.getParameter("stunum");
		String password = req.getParameter("password");
		//����StudentService ʵ��ѧ����¼����
		Student student = ss.login(stunum, password);
		
		if(student == null) { //��¼ʧ��
			req.setAttribute("message", "�û������������");
			req.getRequestDispatcher("/student/login.jsp").forward(req, resp);
			return;
		}
		
		//��¼�ɹ�
		HttpSession session = req.getSession();
		session.setAttribute("student", student);
		resp.sendRedirect(req.getContextPath() + "/student/index.jsp");
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
