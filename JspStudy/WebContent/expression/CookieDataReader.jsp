<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>

		NAME 의 쿠키 값은 ? ${cookie.NAME }
		<hr>
		NAME 의 쿠키 값은 ? ${cookie.NAME.value }
		<hr>
		NAME 의 쿠키 값은 ? ${cookie["NAME"].value }
		<hr>
		NAME 의 쿠키 값은 ? ${cookie["NAME"]["value"] }
		
</body>
</html>