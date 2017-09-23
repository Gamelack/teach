<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
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
    	<form action="user/update" method="post">
			<table>
			<tr>
				<td>id:<input type="text" name="id" value="${userinfo.id }" readonly="readonly"/></td>
			</tr>
			<tr>
				<td>name:<input type="text" name="username" value="${userinfo.username }"/></span></td>
			</tr>
			<tr>
				<td>pass:<input type="password" name="password" value="${userinfo.password }"/></td>
			</tr>
			<tr>
				<td>sex:
				<!-- ----------------男-------------------- -->
				
				<c:if test="${userinfo.sex=='boy' }">
					<input type="radio" name="sex" value="boy" checked="checked"  />男
				</c:if>
				<c:if test="${userinfo.sex!='boy' }">
					<input type="radio" name="sex" value="boy" />男
				</c:if>
				<!-- ---------------女------------------------ -->
				
				<c:if test="${userinfo.sex=='girl' }">
					<input type="radio" name="sex" value="girl" checked="checked"  />女
				</c:if>
				<c:if test="${userinfo.sex!='girl' }">
					<input type="radio" name="sex" value="girl" />女
				</c:if>
				
				<!-- ---------------妖------------------------ -->
				
				<c:if test="${userinfo.sex=='gay' }">
					<input type="radio" name="sex" value="gay" checked="checked"  />妖
				</c:if>
				<c:if test="${userinfo.sex!='gay' }">
					<input type="radio" name="sex" value="gay" />妖
				</c:if>
				
				
				</td>
			</tr>
			<tr>
				<td>right:
				 <select name="right_id">
				 	<c:forEach var="right" items="${allright }">
				 		<c:if test="${userinfo.right_id==right.id }">
				 			<option value="${right.id }" selected="selected">${right.name }</option>
				 		</c:if>
				 		<c:if test="${userinfo.right_id!=right.id }">
				 			<option value="${right.id }" >${right.name }</option>
				 		</c:if>
				 		
				 	</c:forEach>
						
				</select>
				</td>
			</tr>
			<tr>
				<td>registDate:
					<input type="text" name="registDate" value="${userinfo.registDate }" readonly="readonly"/>
				</td>
			</tr>
			<tr>
				<td><input type="submit" value="提交"></td>
			</tr>
			
		</table>
		</form>
  </body>
</html>
