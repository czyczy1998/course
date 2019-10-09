package com.neuedu.servlet.admin;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuedu.model.Course;
import com.neuedu.model.Student;
import com.neuedu.service.CourseService;
import com.neuedu.service.impl.CourseServiceImpl;

@WebServlet("/admin/course")
public class CourseServlet extends HttpServlet{
	CourseService cs = new CourseServiceImpl();
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		switch (method) {
		case "getAll":
			getAll(request,response);
			break;
		case "showAdd":
			showAdd(request,response);
		
			break;
		case "add":
			add(request,response);
		default:
			break;
		}
		
	}

	private void getAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��ǰҳ��
		String pageNo = request.getParameter("pageNo");
		//�γ��б�
		List<Course> courses = cs.getAll(Integer.parseInt(pageNo));
		//��ȡ�ܼ�¼��
		int totalRecord = cs.getTotalRecord();
		//��ȡ�ܵ�ҳ��
		int pageSum = cs.getPageSum(totalRecord);
		
		request.setAttribute("courses", courses);
		request.setAttribute("pageNo", pageNo);
		request.setAttribute("totalRecord", totalRecord);
		request.setAttribute("pageSum", pageSum);
		request.getRequestDispatcher("/admin/course/courseManager.jsp").forward(request, response);
	
	}
	
	private void showAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Course> courses = cs.getAll();
		request.setAttribute("courses", courses);
		request.getRequestDispatcher("/admin/course/courseAdd.jsp").forward(request, response);
	}
	
	/*
	 * �÷����������������ѧ����ť�ķ����������ݹ�����ѧ����Ϣ���浽���ݿ�����
	 */
	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String coursename = request.getParameter("coursename");
		String hour = request.getParameter("hour");
		String score = request.getParameter("score");
		
		Course c = new Course(coursename,Integer.parseInt(hour),Double.parseDouble(score));
		
		cs.add(c);
		getAll(request,response);
		
	}
	
}
