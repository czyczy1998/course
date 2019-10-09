package com.neuedu.servlet.student;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neuedu.model.Course;
import com.neuedu.model.Selection;
import com.neuedu.model.Student;
import com.neuedu.service.SelectionService;
import com.neuedu.service.impl.SelectionServiceImpl;
import com.neuedu.servlet.base.BaseServlet;
import com.neuedu.vo.SelectionVO;

@WebServlet("/student/selection")
public class SelectionServlet extends BaseServlet {
	SelectionService ss = new SelectionServiceImpl();
	

	private String selectCourse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String year = request.getParameter("year");
		String term = request.getParameter("term");
		String[] courseids = request.getParameterValues("courseid");
		HttpSession session = request.getSession();
		Student student = (Student)session.getAttribute("student");
		int stuid = student.getStuid();
		List<Selection> selections = new ArrayList<>();
		for(String courseid : courseids) {
			Selection selection = new Selection(stuid,Integer.parseInt(courseid),Integer.parseInt(year), term);
			selections.add(selection);
		}
		
		//调用service 保存选课信息
		boolean flag = ss.batSelectCourse(selections);
		
		return getAll(request, response);
		
	}

	//取消选择的课程
	private String cancelSelect(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] selids = request.getParameterValues("selid");
		ss.batchDelete(selids);
		return getAll(request, response);
	}

	public String getAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Student student = (Student)session.getAttribute("student");
		System.out.println(student);
		//获取已选课程列表
		List<SelectionVO> selectedList = ss.getSelectedList(student.getStuid()+"");
		//获取未选课程的列表
		List<Course> unSelectedList = ss.getUnSelectedList(student.getStuid() + "");
		request.setAttribute("selected", selectedList);
		request.setAttribute("unSelected", unSelectedList);
		
		//request.getRequestDispatcher("/student/selectcourse.jsp").forward(request, response);
		
		return "/student/selectcourse.jsp";
	}

}
