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
/*�����������
 * post���������������ô����
 *  req.setCharacterEncoding("utf-8")��Ҫע����ǣ����ñ���һ�����ڻ�ȡ����֮ǰ����
 * get���������������ô����
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
			req.setAttribute("errorMsg", "����ʧ�ܡ�������");
		}
		//����ʧ��
		
		return getAll(req, resp);
	}

	//��Ӱ༶��Ϣ
	public String add(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		String classname = req.getParameter("classname");
		
		System.out.println("classname:::" + classname);
		boolean flag = cs.add(classname);
		if(flag) { //����ɹ�
			//
			return getAll(req, resp);
			
		}
		//����ʧ��
		req.setAttribute("errorMsg", "��Ӱ༶ʧ�ܣ�����ϵ����Ա��������");
		return "/admin/error.jsp";
	}
	
	//��ȡ���а༶��Ϣ
	public String getAll(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		HttpSession session = req.getSession(); //1:�������Ƿ��Ѿ�Ϊ�ÿͻ��˴���Session,���û�д������ʹ���һ���µ�Session��������Ѿ������ˣ����ȡ�Ѿ������Ķ���
		Object obj = session.getAttribute("username");
		if(obj == null) {  //˵��û�е�¼����ת����¼ҳ��
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
