<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<link rel="stylesheet" href="resources/css/reset.css">
<link rel="stylesheet" href="resources/css/login.css">
</head>
<body>
	<div id="frame">
		<div id="header">
			<a>Home</a> <a onclick="event_ajax()">모든 행사</a> <a>행사 검색</a> <a>고객센터</a>
			<a>회원가입/로그인</a>
		</div>

		<form action="" method="post">
			<div id="pack">
				<div class="ip">
					아이디 : <input type="text">
				</div>
				<div class="ip">
					비밀번호 : <input type="password">
				</div>
				<div class="ip">
					<input type="submit" value="로그인">
				</div>
			</div>
		</form>
	</div>
</body>
</html>