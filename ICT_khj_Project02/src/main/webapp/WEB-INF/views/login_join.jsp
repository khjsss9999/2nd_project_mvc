<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<link rel="stylesheet" href="resources/css/login_join.css">
<link rel="stylesheet" href="resources/css/reset.css">
<script type="text/javascript">
	function join_go() {
		location.href = "join.do";
	}
</script>
</head>
<body>
	<div id="frame">
		<div id="header">
			<a>Home</a> <a onclick="event_ajax()">모든 행사</a> <a>행사 검색</a> <a>고객센터</a>
			<a>회원가입/로그인</a>
		</div>
		<div id="but">
			<div class="aaa" onclick="join_go()">일반 회원가입</div>
			<div class="aaa">일반 로그인</div>
			<div class="ddd" id="naver_login">
				<img id="nl_img" src="resources/images/btnG_logIn.png">
			</div>
			<div class="ddd" id="kakao_login">
				<img id="kl_img" src="resources/images/kakao_login_large_narrow.png">
			</div>
		</div>
	</div>
</body>
</html>