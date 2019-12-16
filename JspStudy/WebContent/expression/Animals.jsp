<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>

<%
	ArrayList<String> items = new ArrayList<String>();
	items.add("고릴라");
	items.add("늑대");
	items.add("여우");
	
	request.setAttribute("ANIMALS", items);
	RequestDispatcher dispatcher = request.getRequestDispatcher("AnimalsView.jsp");
	dispatcher.forward(request, response);
%>