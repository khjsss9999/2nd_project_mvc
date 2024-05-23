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
<link rel="stylesheet" href="resources/css/index.css">
<link rel="stylesheet" href="resources/css/reset.css">
<script type="text/javascript">
	function event_list() {
		location.href = "event_list.do";
	}
	
	function event_db_refresh() {
		location.href = "event_db_refresh.do"
	}
	function c_center_go() {
		location.href= "c_center_go.do";
	}
	
</script>
<script type="text/javascript">
	$(document).ready(function() {
		let join_ok = "${suvo.join}";
		if(join_ok == "1"){
			alert("회원가입을 축하축하");
		}
	});
</script>

</head>
<body>
	<div id="frame">
	<div id="header">
		<a >Home</a> <a onclick="event_list()">모든 행사</a> <a onclick="event_db_refresh()">행사 갱신(db저장)</a> <a>행사 검색</a> <a onclick="c_center_go()">고객센터</a> 
		<c:choose>
			<c:when test="${suvo.login == '1'}">
				<a href="mypage.do">마이페이지</a>
			</c:when>
			<c:otherwise>
				<a href="login_join.do">회원가입/로그인</a> 
			</c:otherwise>
		</c:choose>
	</div>

	<div id="m_body">
			
		<div id="main_image">
			<img id="main_img" src="resources/images/old_man_sea.png">
		</div>
	</div>
		<div id="footer">
			<div id="pack">
				<div id="a">개인정보처리방침</div>
				<div id="b" >이용약관</div>
			</div>
			<div id="aaaa">(03082) 서울시 종로구 대학로 57 (연건동) 홍익대학교 대학로 캠퍼스 교육동 12층 예술경영지원센터<br>
				TEL. 02-708-2214(통계 분석·연구), 02-2098-2945(연계기관·API·My통계)<br>
 					FAX. 02-2098-2904 E-mail. kopis@gokams.or.kr<br>
					COPYRIGHT © KOREA PERFORMING ARTS BOX OFFICE INFORMATION SYSTEM</div>
			<div id="bbbb">kopis.or.kr 사이트 api와 이미지 사용</div>
		</div>
	</div>
</body>
</html>