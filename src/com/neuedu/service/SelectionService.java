package com.neuedu.service;

import java.util.List;

import com.neuedu.model.Course;
import com.neuedu.model.Selection;
import com.neuedu.vo.SelectionVO;

public interface SelectionService {
	//Ϊѡ��γ��б�
		public List<Course> getUnSelectedList(String stuid);
		//��ѯ��ѡ��Ŀγ��б�
		public List<SelectionVO> getSelectedList(String stuid);
		public void batchDelete(String[] selids);
		public boolean batSelectCourse(List<Selection> selections);
}
