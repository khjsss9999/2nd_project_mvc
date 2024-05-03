<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- JQuery 라이브러리 -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<link rel="stylesheet" href="resources/css/index.css">
<link rel="stylesheet" href="resources/css/reset.css">
<script type="text/javascript">
	function event_ajax() {
		location.href = "event_ajax.do";
	}
</script>
</head>
<body>

	<header>
		<a>Home</a> <a onclick="event_ajax()">행사 불러오기</a> <a>행사 검색</a> <a>고객센터</a> <a>회원가입</a> <a>로그인</a> <a>검색</a>
	</header>

	<section>
		<c:forEach var="k" begin="1" end="30" step="1">
			<a> <img alt="pds.jpg" src="resources/images/pds.jpg">
			</a>
		</c:forEach>
	</section>

</body>
</html>