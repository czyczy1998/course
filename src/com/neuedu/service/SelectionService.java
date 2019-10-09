package com.neuedu.service;

import java.util.List;

import com.neuedu.model.Course;
import com.neuedu.model.Selection;
import com.neuedu.vo.SelectionVO;

public interface SelectionService {
	//为选择课程列表
		public List<Course> getUnSelectedList(String stuid);
		//查询已选择的课程列表
		public List<SelectionVO> getSelectedList(String stuid);
		public void batchDelete(String[] selids);
		public boolean batSelectCourse(List<Selection> selections);
}
