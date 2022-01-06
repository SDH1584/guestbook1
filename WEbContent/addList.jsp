<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>

<%@ page import="java.util.List"%>
<%@ page import="com.javaex.dao.GuestbookDao"%>
<%@ page import="com.javaex.vo.GuestbookVo"%>

<%
	GuestbookDao guestbookDao = new GuestbookDao();
	List<GuestbookVo> gList = guestbookDao.getList();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 등록폼영역 -->
		<form action="./add.jsp" method="get">
			<table border="1" width="500px">
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" values=""></td>
				<td>비밀번호</td>
				<td><input type="password" name="password" values=""></td>
			</tr>
			<tr>
				<td colspan="4">
				<textarea name="content" cols="64" rows="5"></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="4">
				<button type="submit">확인</button>
				</td>
			</tr>
			</table>
		</form>	
	<br>

	<%
	for(int i = 0; i < gList.size(); i++) {
	%>
		<table border="1">
			<tr>
				<td><%= gList.get(i).getNo()%></td>
				<td><%= gList.get(i).getName() %></td>
				<td><%= gList.get(i).getRegDate() %></td>
				<td><a href="./deleteForm.jsp?no=<%= gList.get(i).getNo()%>">삭제</a></td>
			</tr>
			<tr>
				<td colspan="4"><textarea style="width:30rem"><%= gList.get(i).getContent() %></textarea></td>
			</tr>
		</table>
		</br>
	<%
	}
	%>
</body>
</html>