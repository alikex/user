package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.BaseDao;
import com.dao.StudentDao;
import com.entity.Page;
import com.entity.Student;
import com.util.DatabaseUtil;

public class StudentDaoImpl extends BaseDao implements StudentDao{

	@Override
	public List<Student> findByPage(Page page) {
		
		Student stu = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM student LEFT JOIN classes ON student.`classId`=classes.`id` LIMIT ?,?";
		List<Student> list = new ArrayList<Student>();
		
		try {
			conn  = DatabaseUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, (page.getPageNo() - 1) * page.getPageSize());//获得起始下标	
			pstmt.setInt(2, page.getPageSize());//每页查询的条数
			rs = pstmt.executeQuery();
			while(rs.next()) {
				stu = new Student();
				stu.setId(rs.getInt("id"));
				stu.setSname(rs.getString("sname"));
				stu.setGender(rs.getString("gender"));
				stu.setBirthday(rs.getTimestamp("birthday"));
				stu.setTelephone(rs.getString("telephone"));
				stu.setEmail(rs.getString("email"));
				stu.setCname(rs.getString("cname"));
				list.add(stu);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DatabaseUtil.closeAll(null, null, rs);
		}
		return list;
	}
	/**
	 * 	总记录数
	 */
	@Override
	public Integer countStudent() {
		int result = 0;
		String sql = "SELECT count(1) FROM student";
		ResultSet rs = null;
		try {
			rs = this.executeQuery(sql);
			while (rs.next()) {
				result = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DatabaseUtil.closeAll(null, null, rs);
		}
		return result;
	}

	@Override
	public Integer updateStudent(Student student) {
		int result = 0;
		String sql = "UPDATE `student` SET `sname`=?,`birthday`=?,`gender`=?,`telephone`=?,`email`=?,`classId`=? WHERE `id`=?";
		try {
			result = this.executeUpdate(sql,student.getSname(),student.getBirthday(),student.getGender(),student.getTelephone(),
					student.getEmail(),student.getClassId(),student.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Integer deleteStudent(Integer id) {
		int result=0;
		String sql = "DELETE FROM student WHERE id =?";
		try {
			result = this.executeUpdate(sql, id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Integer insertStudent(Student student) {
		int result = 0;
		String sql = "INSERT INTO `student`(`sname`,`gender`,`birthday`,`telephone`,`email`,`classId`) VALUES (?,?,?,?,?,?)";
		try {
			result = this.executeUpdate(sql,student.getSname(),student.getGender(),student.getBirthday(),
					student.getTelephone(),student.getEmail(),student.getClassId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public List<Student> getAll() {
		Student stu = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM student LEFT JOIN classes ON student.`classId`=classes.`id`";
		List<Student> list = new ArrayList<Student>();
		try {
			rs = this.executeQuery(sql);
			while(rs.next()) {
				stu = new Student();
				stu.setId(rs.getInt("id"));
				stu.setSname(rs.getString("sname"));
				stu.setGender(rs.getString("gender"));
				stu.setBirthday(rs.getTimestamp("birthday"));
				stu.setTelephone(rs.getString("telephone"));
				stu.setEmail(rs.getString("email"));
				stu.setCname(rs.getString("cname"));
				list.add(stu);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DatabaseUtil.closeAll(null, null, rs);
		}
		return list;
	}

	@Override
	public List<Student> getById(Integer id) {
		Student stu = null;
		List<Student> list = new ArrayList<Student>();
		String sql = "SELECT * FROM student LEFT JOIN classes ON student.`classId`=classes.`id` WHERE student.`id` = '"+id+"' ";
		ResultSet rs = null;
		try {
			rs = this.executeQuery(sql);
			while(rs.next()) {
				stu = new Student();
				stu.setId(rs.getInt("id"));
				stu.setSname(rs.getString("sname"));
				stu.setGender(rs.getString("gender"));
				stu.setBirthday(rs.getTimestamp("birthday"));
				stu.setTelephone(rs.getString("telephone"));
				stu.setEmail(rs.getString("email"));
				stu.setCname(rs.getString("cname"));
				list.add(stu);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DatabaseUtil.closeAll(null, null, rs);
		}
		return list;
	}
	
}
