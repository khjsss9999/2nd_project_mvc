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
	function c_center_go() {
		location.href = "c_center_go.do";
	}
	function index_go() {
		location.href = "/";
	}
	
</script>
</head>
<body>
	<div id="frame">
	<div id="header">
		<a onclick="index_go()">Home</a>  <a>행사 검색</a> <a onclick="event_db_refresh()">행사 갱신(db저장)</a> <a>행사 검색</a> <a onclick="c_center_go()">고객센터</a> <a>회원가입/로그인</a> 
	</div>

	<div id="m_body">
	<c:choose>
		<c:when test="${empty event_list}">
			<h1>공연리스트가 존재하지 않습니다...........</h1>
		</c:when>
		<c:otherwise>
			<c:forEach var="k" items="${event_list}" varStatus="vs">
				<ul> <img alt="${k.poster}" src="resources/images/event_island.png">
				<li>행사이름: ${k.prfnm}</li>
				<li>행사주소: ${k.area}</li>
				<li>행사기간: ${k.prfpdfrom.substring(0,10)}~${k.prfpdto.substring(0,10)}</li>
				</ul>
			</c:forEach>
		</c:otherwise>
	</c:choose>
	</div>
	<div class="all_event_body">
				<div id="sel_event_page">
					<c:choose>
						<c:when test="${paging.beginBlock <= paging.pagePerBlock }">
							<button type="button" class="disable">&lt;</button>
						</c:when>
						<c:otherwise>
							<button type="button" class="entity"
								onclick="location.href='event_list.do?cPage=${paging.beginBlock - paging.pagePerBlock }'">&lt;</button>
						</c:otherwise>
					</c:choose>
					<c:forEach begin="${paging.beginBlock}" end="${paging.endBlock}"
						step="1" var="k">
						<c:choose>
							<c:when test="${k == paging.nowPage }">
								<button type="button" class="page_num">${k}</button>
							</c:when>
							<c:otherwise>
								<button type="button" class="page_num"
									onclick="location.href='event_list.do?cPage=${k}'">${k}
								</button>
							</c:otherwise>
						</c:choose>
					</c:forEach>
					<c:choose>
						<c:when test="${paging.endBlock >= paging.totalPage}">
							<button class="disable">&gt;</button>
						</c:when>
						<c:otherwise>
							<button type="button" class="page_num"
								onclick="location.href='event_list.do?cPage=${paging.beginBlock + paging.pagePerBlock }'">&gt;
							</button>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
	</div>
</body>
</html>