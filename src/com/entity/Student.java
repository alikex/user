package com.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Student {
	private Integer id;
	private String sname;
	private Date birthday;
	private String gender;
	private String telephone;
	private String email;
	private Integer classId;
	private String cname;//班级名称
	
	
	public String getCname() {
		return cname;
	}
	public void setCname(String string) {
		this.cname = string;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getClassId() {
		return classId;
	}
	public void setClassId(Integer classId) {
		this.classId = classId;
	}

	
}
