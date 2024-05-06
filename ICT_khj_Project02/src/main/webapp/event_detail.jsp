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
<link rel="stylesheet" href="resources/css/reset.css">
<link rel="stylesheet" href="resources/css/event_detail.css">
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
			
		<div id="main_image"><img id="m_img" src="resources/images/event_b_island.png">
		</div>
	</div>
	<div class="info">
		<div class="pack">
			<div class="first">공연기간</div>
			<div class="second">2024.05.06(월) ~ 2024.05.06(월)</div>
		</div>
		<div class="pack">
			<div class="first">공연장소</div>
			<div class="second">예스24 라이브홀 (구. 악스코리아)</div>
		</div>
		<div class="pack">
			<div class="first">공연시간</div>
			<div class="second">월요일(17:00)</div>
		</div>
		<div class="pack">
			<div class="first">관람연령</div>
			<div class="second">만 7세 이상</div>
		</div>
		<div class="pack">
			<div class="first">티켓가격</div>
			<div class="second">전석 132,000원</div>
		</div>
		<div class="pack">
			<div class="first">출연진</div>
			<div class="second">해당정보 없음</div>
		</div>
		<div class="pack">
			<div class="first">제작진</div>
			<div class="second">해당정보 없음</div>
		</div>
		<div class="pack">
			<div class="first">주최.주관</div>
			<div class="second">Knowmerce(노머스)(주관) , 아이피큐 (IPQ Inc.)(주최)</div>
		</div>
		<div class="pack">
			<div class="first">기획.제작</div>
			<div class="second">해당정보 없음</div>
		</div>
	</div>
	<div id="chd_but">공연장 상세보기</div>
	<div id="concert_hall_info">
		<div id="aaaa">예스24 라이브홀 (구.악스코리아)</div>
		<div class="chi_pack">
			<div class="c_first">좌석수</div>
			<div class="c_second">1051석</div>
		</div>
		<div class="chi_pack">
			<div class="c_first">시설특징</div>
			<div class="c_second">민간(대학로 외)</div>
		</div>
		<div class="chi_pack">
			<div class="c_first">주소</div>
			<div class="c_second">서울특별시 광진구 구천면로 20 (광장동)</div>
		</div>
		<div class="chi_pack">
			<div class="c_first">홈페이지</div>
			<div class="c_second">www.yes24livehall.com/</div>
		</div>
		<div id="bbbb">공연장 위치</div>
		<div id="location"><img id="ch_location_img" src="resources/images/location_example.png"></div>
	</div>
</body>
</html>