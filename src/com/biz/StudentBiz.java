package com.biz;

import java.util.List;

import com.entity.Page;
import com.entity.Student;

public interface StudentBiz {
	public void findByPage(Page page);//分页查询
	public Integer updateStudent(Student student);//更新
	public boolean deleteStudent(Integer id);//删
	public Integer insertStudent(Student student);//添加
	public List<Student> getAll();//不分页
	public List<Student> getById(Integer id);
}
