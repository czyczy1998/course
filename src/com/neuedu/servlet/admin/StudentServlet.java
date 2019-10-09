package com.neuedu.servlet.admin;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuedu.model.Student;
import com.neuedu.service.ClassService;
import com.neuedu.service.StudentService;
import com.neuedu.service.impl.StudentServiceImpl;

@WebServlet("/admin/student")
public class StudentServlet extends HttpServlet {
	StudentService ss = new StudentServiceImpl();
	ClassService cs = new ClassService();
	
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
			break;
		case "showEdit":
			showEdit(request,response);
			break;	
		case "edit":
			edit(request,response);
			break;
		case "delete":
			delete(request,response);
			break;
		default:
			break;
		}
	}

	/*
	 * ��ʾ�༭ҳ��ķ������ڸ÷����и���stuid��ѯѧ������Ϣ����ѧ����Ϣ����request�У�����ת��studentEdit.jsp,��studentEdit.jspҳ����
	 * ��ʾѧ������Ϣ
	 */
	private void showEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String stuid = request.getParameter("stuid");
		Map<String, String> student = ss.getStudentByid(stuid);
		List<Map<String, String>> classes = cs.getAll();
		request.setAttribute("classes", classes);
		
		request.setAttribute("student", student);
		request.getRequestDispatcher("/admin/student/studentEdit.jsp").forward(request, response);
	}

	/*
	 * ���������������Ҫ��ѯ�༶�б�Ȼ����ת����Ӱ༶��jspҳ�棨studentAdd.jsp��
	 */
	private void showAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Map<String, String>> classes = cs.getAll();
		request.setAttribute("classes", classes);
		request.getRequestDispatcher("/admin/student/studentAdd.jsp").forward(request, response);
	}
	
	/*
	 * �÷����������������ѧ����ť�ķ����������ݹ�����ѧ����Ϣ���浽���ݿ�����
	 */
	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String stunum = request.getParameter("stunum");
		String stuname = request.getParameter("stuname");
		String password = request.getParameter("password");
		String classid = request.getParameter("classid");
		Student student = new Student(stunum, stuname, password, Integer.parseInt(classid));
		
		ss.add(student);
		getAll(request, response);
		
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String stuid = request.getParameter("stuid");
		ss.delete(stuid);
		getAll(request, response);
		
	}

	private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String stuid = request.getParameter("stuid");
		String stunum = request.getParameter("stunum");
		String stuname = request.getParameter("stuname");
		String password = request.getParameter("password");
		String classid = request.getParameter("classid");
		
		Student student = new Student(Integer.parseInt(stuid), stunum, stuname, password, Integer.parseInt(classid));
		
		ss.update(student);
		getAll(request, response);
		
	}

	

	private void getAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Map<String, String>> list = ss.getAll();
		
		List<Map<String, String>> classList = cs.getAll();
		request.setAttribute("students", list);
		
		
		request.getRequestDispatcher("/admin/student/studentManager.jsp").forward(request, response);
		
	}
}
