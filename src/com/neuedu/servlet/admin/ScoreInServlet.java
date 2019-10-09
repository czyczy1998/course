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
import com.neuedu.model.ScoreIn;
import com.neuedu.model.Student;
import com.neuedu.service.ScoreInService;
@WebServlet("/admin/scoreIn/scoreInManager")
public class ScoreInServlet extends HttpServlet{
	ScoreInService ss=new ScoreInService();
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		switch (method) {
		case "getAll":
			getAll(request,response);
			break;
		case "edit":
			edit(request,response);
			break;
		default:
			break;
		}
		
	}

	


	private void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String selid = req.getParameter("selid");
		String grade = req.getParameter("grade");
		
		boolean flag = ss.edit(selid, grade);
		req.setAttribute("selid", selid);
		req.setAttribute("grade", grade);
		if(!flag) {
			
			req.setAttribute("errorMsg", "更新失败。。。。");
		}
		//保存失败
		
		getAll(req, resp);
	
	}
	







	private void getAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//当前页数
List<Map<String, String>> list = ss.getAll();
		
		
		request.setAttribute("scorein", list);
		
		System.out.println(list);
		request.getRequestDispatcher("/admin/scoreIn/scoreInManager.jsp").forward(request, response);
		
	}
}