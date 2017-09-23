<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE>
<html>
<head>
<base href="<%=basePath%>">

<title>天骄用户管理系统-用户登录</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
</head>

<body>
	<h1>注册</h1>
	<div>
<!-- ?username=little+bai&password=123&repassword=123&sex=gay&interesting=football&interesting=basketball&interesting=pingpang&interesting=book&country=bang&dubai=%E5%A4%A7%E5%B8%88%E5%82%85%E6%A1%88%E7%9A%84%E8%AF%B4%E6%B3%95%E9%83%BD%E6%98%AF%E5%8F%91%E5%A4%A7%E5%B8%88%E6%B3%95%E7%AC%AC%E4%B8%89%E6%96%B9
 -->		
 		<form action="user/login" method="post">
			<table>
			<tr>
				<td>name:<input type="text" name="username" value="little bai"/><span style="color:red">*</span></td>
			</tr>
			<tr>
				<td>pass:<input type="password" name="password" value="123"/><span style="color:red">*</span></td>
			</tr>
			<tr>
				<td><input type="submit" value="提交"></td>
			</tr>
			
		</table>
		</form>
	</div>
</body>
</html>
