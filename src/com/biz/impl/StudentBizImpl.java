package com.biz.impl;

import java.util.List;

import com.biz.StudentBiz;
import com.dao.StudentDao;
import com.dao.impl.StudentDaoImpl;
import com.entity.Page;
import com.entity.Student;



public class StudentBizImpl implements StudentBiz{

	private StudentDao stuDao = new StudentDaoImpl();
	
	@Override
	public void findByPage(Page page) {
		Integer count = stuDao.countStudent();
		page.setRowCount(count);//总记录数
		
		if(page.getPageNo()>page.getPageCount()) {
			page.setPageNo(page.getPageCount());
		}
		List<Student> data = stuDao.findByPage(page);
		page.setData(data);
	}

	@Override
	public Integer updateStudent(Student student) {
		
		return stuDao.updateStudent(student);
	}

	@Override
	public boolean deleteStudent(Integer id) {
		if(stuDao.deleteStudent(id)==1) {
		return true;	
		}
		return false;
	}

	@Override
	public Integer insertStudent(Student student) {
		return stuDao.insertStudent(student);
	}

	@Override
	public List<Student> getAll() {
		return stuDao.getAll();
	}

	@Override
	public List<Student> getById(Integer id) {
		
		return stuDao.getById(id);
	}
	
}
