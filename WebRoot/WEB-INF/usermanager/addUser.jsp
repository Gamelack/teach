<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">

<title>天骄用户管理系统-用户添加</title>
</head>

<body>
	<%
		//这个页面实际上是管理员的页面
	%>
	<form action="user/regist" method="post">
		<table>
			<tr>
				<td>name:<input type="text" name="username" value="little bai" /><span
					style="color:red">*</span></td>
			</tr>
			<tr>
				<td>pass:<input type="password" name="password" value="123" /><span
					style="color:red">*</span></td>
			</tr>
			<tr>
				<td>sex: <input type="radio" name="sex" value="boy"
					checked="checked">男 <input type="radio" name="sex"
					value="girl">女 <input type="radio" name="sex" value="gay">妖
				</td>
			</tr>
			<tr>
				<td>right:
				 <select name="right_id">
				 	<c:forEach var="right" items="${allright }">
				 			<option value="${right.id }" >${right.name }</option>
				 	</c:forEach>
				</select>
				</td>
			</tr>

			<tr>
				<td><input type="submit" value="提交"></td>
			</tr>

		</table>
	</form>
</body>
</html>
