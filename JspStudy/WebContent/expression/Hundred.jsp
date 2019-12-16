<%
	int sum = 0;
 	for(int cnt=1;cnt<=100;cnt++){
 		sum += cnt;
 	}
 	
 	request.setAttribute("RESULT", new Integer(sum));
 	RequestDispatcher dispatcher = request.getRequestDispatcher("HundredResult.jsp");
 	dispatcher.forward(request, response);
 	
%>