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
	function event_ajax() {
		location.href = "event_ajax.do";
	}
	$(document).ready(function() {
		function event_db_write() {
			$.ajax({
				url : "event_db_write.do",
				type : "post",
				dataType : "xml",
				success : function(data) {
					alert("업데이트 성공");
				},
				error : function() {
					alert("실패");
				}
			});
		}  
	});
	

</script>
<script type="text/javascript">
function c_center_go() {
	location.href= "c_center_go.do";
}
</script>
</head>
<body>
	<div id="frame">
	<div id="header">
		<a>Home</a> <a onclick="event_ajax()">모든 행사</a> <a onclick="event_db_write()">행사 갱신(db저장)</a> <a>행사 검색</a> <a onclick="c_center_go()">고객센터</a> <a>회원가입/로그인</a> 
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