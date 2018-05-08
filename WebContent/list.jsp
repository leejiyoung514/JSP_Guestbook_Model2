<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.javaex.vo.GuestbookVo"%>
<%@page import="java.util.List"%>
    
<%
    	List<GuestbookVo> list=(List<GuestbookVo>)request.getAttribute("list");
    %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>방명록</title>
</head>
<body>
	<form action="/guestbook/Gb" method="post">
	<input type="hidden" name="a" value="insert"><br>	
	<table border=1 width=500>
		<tr>
			<td>이름</td><td><input type="text" name="name" value=""></td>
			<td>비밀번호</td><td><input type="password" name="pass" value=""></td>
		</tr>
		<tr>
			<td colspan=4><textarea name="content" cols=60 rows=5 value=""></textarea></td>
		</tr>
		<tr>
			<td colspan=4 align=right><input type="submit" VALUE=" 확인 " value=""></td>
		</tr>
	</table>
	</form>
	<br/>

	<%
		for(GuestbookVo vo : list){
	%>
	<table width=510 border=1>
		<tr>
			<td><%=vo.getNo()%></td>
			<td><%=vo.getName()%></td>
			<td><%=vo.getReq_date()%></td>
			<td><a href="/guestbook/Gb?a=deleteform&no=<%=vo.getNo()%>">삭제</a></td>
		</tr>
		<tr>
			<td colspan=4><%=vo.getContent()%></td>
		</tr>
	</table>
        <br/>
    <% 
	  }
	%>    
	
</body>
</html>