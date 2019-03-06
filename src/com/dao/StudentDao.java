package com.dao;

import java.util.List;

import com.entity.Page;
import com.entity.Student;

public interface StudentDao {
	public List<Student> findByPage(Page page);//分页查询
	public Integer countStudent();//统计学生总数
	public Integer updateStudent(Student student);//修改学生信息
	public Integer deleteStudent(Integer id);//根据id删除学生信息
	public Integer insertStudent(Student student);//添加学生信息
	public List<Student> getAll();
	public List<Student> getById(Integer id);//根据id查询信息
}
