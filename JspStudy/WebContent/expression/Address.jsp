<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>

<%
	HashMap<String, String> map = new HashMap<String, String>();
	map.put("dooley", "남극");
	map.put("choonhyang", "남원");
	map.put("gogildong", "서울");
	
	request.setAttribute("ADDRESS", map);
	RequestDispatcher dispatcher = request.getRequestDispatcher("AddressView.jsp");
	dispatcher.forward(request, response);
%>