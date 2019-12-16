<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>내가 좋아하는 동물</h1><hr>
	
	<form action=PetsResult.jsp>
		아이디 : <input type=text name=ID><hr>
		다음 중 회원님이 좋아하시는 동물을 선택하십시오.<br>
		멍멍이<input type=checkbox name=ANIMAL value="멍멍이">
		야옹이<input type=checkbox name=ANIMAL value="야옹이">
		물고기<input type=checkbox name=ANIMAL value="물고기"><br><br>
		<input type=reset value=취소>
		<input type=submit value=확인>
	</form>

</body>
</html>