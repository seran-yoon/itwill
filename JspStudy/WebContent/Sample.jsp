<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>1부터 100까지의 합</title>
</head>
<body>

	<%
		int total = 0;
		for(int cnt = 1; cnt <= 100; cnt++){
			total += cnt;
		}
	%>
	
	1부터 100까지의 합은? <%= total %> <% //expression %>
	1부터 100까지의 합은? <%= total + 100 %> <% //expression %>
	1부터 100까지의 합은? <%= Math.sqrt(total) %> <% //expression %>
	
</body>
</html>