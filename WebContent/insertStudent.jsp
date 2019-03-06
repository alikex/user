 <%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="jquery-1.12.4.js"></script>
<script type="text/javascript">
function check() {
	var sname = $("#sname").val();
	var birthday = $("#birthday").val();
	var telephone = $("#telephone").val();
	var email = $("#email").val();
	if (sname == "") {
		alert("姓名不能为空！请填写！");
		return false;
	}
	if (birthday == "") {
		alert("生日不能为空！请填写！");
		return false;
	}
	if (telephone == "") {
		alert("电话号码不能为空！请填写！");
		return false;
	}
	if (email == "") {
		alert("邮箱不能为空！请填写！");
		return false;
	}

	
}
</script>
<title>添加学生</title>
</head>
<body>
	<div align="center">
		<h1>添加学生信息</h1>
		<form action="" method="post" onsubmit="">
			<table>
				<tr>
					<td>姓名:</td>
					<td><input type="text" name="sname" id="sname" /></td>
				</tr>
				<tr>
					<td>性别：</td>
					<td>
						<input type="radio" value="男" name="gender" id="gender" checked="checked">男
						<input type="radio" value="女" name="gender" id="gender">女
					</td>
				</tr>
				<tr>
					<td>生日：</td>
					<td><input type="text" name="birthday" id="birthday" /></td>
				</tr>
				<tr>
					<td>电话：</td>
					<td><input type="text" name="telephone" id="telephone" /></td>
				</tr>
				<tr>
					<td>邮箱：</td>
					<td><input type="text" name="email" id="email" /></td>
				</tr>
				<tr>
					<td>班级：</td>
					<td><select name="classId" id="classId">
							<option value="0">请选择班级</option>
							<option value="1">S1234</option>
							<option value="2">S1235</option>
							<option value="3">S2234</option>
							<option value="4">S2235</option>
							<option value="5">Y2234</option>
							<option value="6">Y2235</option>
					</select></td>
				</tr>
				<tr>
					<td><input type="submit" value="保存"/></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>