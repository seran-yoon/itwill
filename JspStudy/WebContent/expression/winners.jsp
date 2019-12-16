<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String	winners[] = new String[3];
	winners[0]	= "심순애";
	winners[1]	= "이수일";
	winners[2]	= "김중배";
	
	request.setAttribute("WINNERS", winners);
	RequestDispatcher dispatcher = request.getRequestDispatcher("WinnersView.jsp");
	dispatcher.forward(request, response);
%>
