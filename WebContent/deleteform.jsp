<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.javaex.vo.GuestbookVO"%>
<%@page import="java.util.List"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>삭제페이지</title>
</head>
<body>
	<form  action="/guestbook/Gb" method="post">
	<input type="text" name="a" value="delete">
	<table>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="password"></td>
			<td><input type="text" name="no" value="<%=request.getParameter("no")%>"></td>
			<td><input type="submit" value="삭제"></td>
			<td><a href="index.php">메인으로 돌아가기</a></td>
			
		</tr>
	</table>
	</form>
</body>
</html>