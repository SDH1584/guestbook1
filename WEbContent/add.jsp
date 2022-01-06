<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>

<%@ page import="com.javaex.dao.GuestbookDao"%>
<%@ page import="com.javaex.vo.GuestbookVo"%>

<%
	GuestbookDao guestbookDao = new GuestbookDao();

	String name = request.getParameter("name");
	String password = request.getParameter("password");
	String content = request.getParameter("content");

	GuestbookVo vo = new GuestbookVo(name, content,password);
	guestbookDao.guestbookInsert(vo);

	response.sendRedirect("./addList.jsp");
%>