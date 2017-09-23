<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	request.setAttribute("path", path);
%>

<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">

<title>天骄用户管理系统-用户列表</title>
</head>

<body>
	<c:if test="${userinfo.right_id==1 }">
		<span style="color: red;">管理员</span><a href="${request.getContextPath() }/user/beforeAdd">添加</a>
	</c:if>
	<table>
		<thead>
			<tr>
				<td>id</td>
				<td>name</td>
				<td>password</td>
				<td>sex</td>
				<td>registDate</td>
				<td>Opera</td>
			</tr>
		</thead>


	<c:forEach var="userInfo" items="${list }">
		<tr>
			<td>${userInfo.id }</td>
			<td>${userInfo.username }</td>
			<td>${userInfo.password }</td>
			<td>${userInfo.sex }</td>
			<td>${userInfo.registDate }</td>
			<td><a
				href="${path }/user/delete?id=${userInfo.id }">删除</a>
				<a
				href="${path }/user/beforeUpdate?id=${userInfo.id }">修改</a></td>
		</tr>
	</c:forEach>
		</table>
</body>
</html>
