<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="com.entity.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head> 
<title>查询</title>
</head>
<body>

	<div align="center">
		<div align="center" style="font-size: 30px">学员信息表</div>
			<form action="">
				<table border="1"width="800" style="text-align: center">
					<tr>
						<th>编号</th>
						<th>姓名</th>
						<th>性别</th>
						<th>生日</th>
						<th>电话</th>
						<th>邮箱</th>
						<th>年级</th>
						<th>操作</th>
					</tr>
					<c:forEach items="${requestScope.page.data}" var="stu" varStatus="i">
						<tr
						<c:if test="${i.index % 2 ==1}">style="background-color:#9CD1F3;"</c:if>>
							<td><a style="text-decoration: none;" href="StudentServlet?id=${stu.id}&action=goupdate">${i.count}</a></td>
							<td>${stu.sname}</td>
							<td>${stu.gender}</td>
							<td><fmt:formatDate value="${stu.birthday}" pattern="yyyy-MM-dd"/></td>
							<td>${stu.telephone}</td>
							<td>${stu.email}</td>
							<td>${stu.cname}</td>
							<td><a style="text-decoration: none;" onclick="return confirm('确定要删除吗？') " href="StudentServlet?id=${stu.id}&action=delete">删除</a></td>
						</tr>
					</c:forEach>
				</table>
				<div align="left" style="width:800px" style="text-decoration: none;"><a href="insertStudent.jsp">添加学生</a></div>
				<div align="center" style="margin-top: 20px">
				<a href="StudentServlet?action=list&pageNo=1">首页</a>
				<a href="StudentServlet?action=list&pageNo=${page.pageNo-1<1?1:page.pageNo-1}">上一页</a>
				<a href="StudentServlet?action=list&pageNo=${page.pageNo+1>page.pageCount?page.pageNo:page.pageNo+1 }">下一页</a>
				<a href="StudentServlet?action=list&pageNo=${page.pageCount }">尾页</a>
				<label>第${page.pageNo }页/共${page.pageCount }页  共${page.rowCount}条记录</label>
			</div>
			</form>
	</div>
</body>


</html>