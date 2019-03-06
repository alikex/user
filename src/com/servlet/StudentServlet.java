package com.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.biz.StudentBiz;
import com.biz.impl.StudentBizImpl;
import com.entity.Page;
import com.entity.Student;
import com.util.Val;




public class StudentServlet extends HttpServlet {
	
	private StudentBiz stuBiz = new StudentBizImpl();
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		String action = request.getParameter(Val.REQUEST_ACTION);
		if("list".equals(action)) {//查询全部
			this.list(request, response);
		}else if("insert".equals(action)) {//添加
			this.insert(request, response);
		}else if("update".equals(action)){//更新
			this.update(request, response);
		}else if("delete".equals(action)) {//删除
			this.delete(request, response);
		}else if("goupdate".equals(action)){
			this.goupdate(request, response);
		}else {
			
		}
	}

	protected void goupdate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("student", stuBiz.getById(id));
		request.getRequestDispatcher("updateStudent.jsp").forward(request,response);
	}
	
	protected void insert(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		String sname = request.getParameter("sname");
		String gender = request.getParameter("gender");
		String birthday = request.getParameter("birthday");
		String telephone = request.getParameter("telephone");
		String email = request.getParameter("email");
		String classId = request.getParameter("classId");

		Student stu = new Student();
		stu.setSname(sname);
		stu.setGender(gender);

		String by = birthday;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		try {
			Date date = sdf.parse(by);
			stu.setBirthday(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		stu.setTelephone(telephone);
		stu.setEmail(email);
		stu.setClassId(Integer.parseInt(classId));
		stuBiz.insertStudent(stu);
		response.sendRedirect("StudentServlet?action=list");
	}

	protected void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		stuBiz.deleteStudent(Integer.parseInt(id));
		response.sendRedirect("StudentServlet?action=list");
	}

	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		Integer id = Integer.parseInt(request.getParameter("id"));
		String id = request.getParameter("id");
		String sname = request.getParameter("sname");
		String gender = request.getParameter("gender");
		String birthday = request.getParameter("birthday");
		String telephone = request.getParameter("telephone");
		String email = request.getParameter("email");
		String classId = request.getParameter("classId");

		Student stu = new Student();
		stu.setId(Integer.parseInt(id));
		stu.setSname(sname);
		stu.setGender(gender);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = sdf.parse(birthday);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		stu.setBirthday(date);
		
		stu.setTelephone(telephone);
		stu.setEmail(email);
		stu.setClassId(Integer.parseInt(classId));
		stuBiz.updateStudent(stu);
		response.sendRedirect("StudentServlet?action=list");

	}
	protected void list(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		String pageIndex = request.getParameter("pageNo");
		int pageNo = 1;//当前页的页码
		int pageSize = 4;// 每页显示的记录数
		if(pageIndex == null) {
			pageNo = 1;
		}else {
			pageNo = Integer.parseInt(pageIndex);
		}
		Page page = new Page();
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		stuBiz.findByPage(page);
		List<Student> stulist = page.getData();//取得分页集合中的数据
		if (stulist.size() < page.getPageSize()) {
			for (int i = stulist.size(); i < page.getPageSize(); i++)
				stulist.add(null);
		}
		page.setData(stulist);
		request.setAttribute("page",page);
		request.getRequestDispatcher("listStudents.jsp").forward(request, response);
		
		//查询全部的方法
//		request.setAttribute("stuList", stuBiz.getAll());
//		request.getRequestDispatcher("listStudents.jsp").forward(request,response);
	}

}
