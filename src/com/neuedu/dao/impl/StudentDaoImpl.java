package com.neuedu.dao.impl;

import java.util.List;
import java.util.Map;

import com.neuedu.dao.StudentDao;
import com.neuedu.model.Student;
import com.neuedu.utils.DBUtil;

public class StudentDaoImpl implements StudentDao{

	@Override
	public List<Map<String, String>> getAll() {
		 
		return DBUtil.query("select s.*,c.classname from tb_student s,tb_class c where s.classid = c.classid", null);
	}

	@Override
	public boolean save(Student student) {
		String sql = "insert into tb_student(stunum,stuname,password,classid) values(?,?,?,?)";
		Object[] array = {student.getStunum(),student.getStuname(),student.getPassword(),student.getClassid()};
		return DBUtil.update(sql, array);
	}

	@Override
	public boolean update(Student student) {
		String sql = "update tb_student set stunum = ?,stuname = ?, password = ?,classid = ? where stuid = ?";
		Object[] array = {student.getStunum(),student.getStuname(),student.getPassword(),student.getClassid(),student.getStuid()};
		return DBUtil.update(sql, array);
	}

	@Override
	public boolean delete(String sid) {	
		return DBUtil.update("delete from tb_student where stuid = ?", sid);
	}

	@Override
	public List<Map<String, String>> getStudentById(String stuid) {
		return DBUtil.query("select * from tb_student where stuid = ?", stuid);
	}

	@Override
	public List<Student> getStudentByNumAndPwd(String stunum, String password) {
		String sql = "select * from tb_student where stunum = ? and password = ?";
		return DBUtil.query(sql, Student.class, stunum,password);
	}

}
