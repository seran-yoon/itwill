<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Insert title here</title>
	</head>
<body>
	
	아이디 : ${ param.ID} <hr>
	선택한 동물 : ${paramValues.ANIMAL[0]} ${paramValues.ANIMAL[1]} ${paramValues.ANIMAL[2]}
	
</body>
</html>