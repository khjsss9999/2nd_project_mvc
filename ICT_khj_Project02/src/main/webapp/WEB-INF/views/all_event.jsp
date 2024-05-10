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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<link rel="stylesheet" href="resources/css/all_event.css">
<link rel="stylesheet" href="resources/css/reset.css">
<script type="text/javascript">
	function event_ajax() {
		location.href = "event_ajax.do";
	}
</script>
</head>
<body>
	<div id="frame">
	<div id="header">
		<a>Home</a> <a onclick="event_ajax()">모든 행사</a> <a>행사 검색</a> <a>고객센터</a> <a>회원가입/로그인</a> 
	</div>

	<div id="m_body">
		<c:forEach var="k" begin="1" end="9" step="1">
			<ul> <img alt="pds.jpg" src="resources/images/event_island.png">
			<li>행사이름:~~~~~~~~~~~~~~</li>
			<li>행사주소:~~~~~~~~~~~~~~~</li>
			<li>행사기간:~~~~~~~~~~~~~~~</li>
			</ul>
		</c:forEach>
	</div>
	</div>
</body>
</html>