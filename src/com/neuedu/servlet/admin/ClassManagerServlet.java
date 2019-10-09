package com.neuedu.servlet.admin;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neuedu.service.ClassService;
import com.neuedu.servlet.base.BaseServlet;
import com.sun.media.jfxmedia.control.VideoDataBuffer;
/*解决乱码问题
 * post请求的乱码问题怎么处理：
 *  req.setCharacterEncoding("utf-8")，要注意的是，设置编码一定是在获取参数之前设置
 * get请求的乱码问题怎么处理
 * 
 * 
 * 
 */

@WebServlet("/admin/classManager")
public class ClassManagerServlet extends BaseServlet{
	ClassService cs = new ClassService();
	
	/*@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String method = req.getParameter("method");
		if("getAll".equals(method)) {
			getAll(req, resp);
		}else if("add".equals(method)) {
			add(req, resp);
		}else if("edit".equals(method)) {
			edit(req,resp);
		}else if("delete".equals(method)) {
			delete(req, resp);
		}
		
	}
	*/
	private String delete(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		System.out.println("delete");
		String classid = req.getParameter("classid");	
		cs.delete(classid);	
		return getAll(req, resp);
	}

	private String edit(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String classid = req.getParameter("classid");
		String classname = req.getParameter("classname");
		
		boolean flag = cs.edit(classid, classname);
		if(!flag) {
			req.setAttribute("classid", classid);
			req.setAttribute("classname", classname);
			req.setAttribute("errorMsg", "更新失败。。。。");
		}
		//保存失败
		
		return getAll(req, resp);
	}

	//添加班级信息
	public String add(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		String classname = req.getParameter("classname");
		
		System.out.println("classname:::" + classname);
		boolean flag = cs.add(classname);
		if(flag) { //保存成功
			//
			return getAll(req, resp);
			
		}
		//保存失败
		req.setAttribute("errorMsg", "添加班级失败，请联系管理员。。。。");
		return "/admin/error.jsp";
	}
	
	//获取所有班级信息
	public String getAll(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		HttpSession session = req.getSession(); //1:检查服务是否已经为该客户端创建Session,如果没有创建，就创建一个新的Session对象，如果已经创建了，则获取已经创建的对象
		Object obj = session.getAttribute("username");
		if(obj == null) {  //说明没有登录，跳转到登录页面
			String path = req.getContextPath();
			resp.sendRedirect(path + "/admin/login.jsp");
			return "";
		}
		
		
		List<Map<String, String>> list = cs.getAll();
		System.out.println(list);
		req.setAttribute("classes", list);
		return "/admin/classManager.jsp";
	}
	
	
}
