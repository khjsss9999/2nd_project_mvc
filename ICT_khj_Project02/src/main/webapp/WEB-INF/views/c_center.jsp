<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/reset.css">
<link rel="stylesheet" href="resources/css/c_center.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

</head>
<body>
	<div id="t_menu">
		<a>자주하는 질문</a>
	</div>
	<div id="frame">
		<section id="ccenter">
			<article id="sel">
				<div id="s_menu">
					<a href="qna">QnA</a> <a href="faq">FaQ</a> <a href="review">Review</a>
					<a href="faq_write.do">faq글 채워넣기</a>
				</div>
			</article>
			<article id="main">
				<c:choose>
					<c:when test="${empty faq_list}">
						<h1>게시물이 존재하지 않습니다.</h1>
					</c:when>
					<c:otherwise>
						<c:forEach var="k" items="${faq_list}" varStatus="vs">
							<div>
								<div class="m_div">
									<div class="m_num">${paging.totalRecord - ((paging.nowPage-1)*paging.numPerPage + vs.index )}</div>
									<div class="m_type">타입1</div>
									<div class="m_subject">${k.faq_subject}</div>
								</div>
								<div class="m_content">내용 : ${k.faq_content}</div>
								<div class="m_reply">
									<p>답글 : ${k.faq_reply}</p>
								</div>
							</div>
						</c:forEach>
					</c:otherwise>
				</c:choose>

			</article>
			<article class="faq_page_body">
				<div id="sel_faq_page">
					<c:choose>
						<c:when test="${paging.beginBlock <= paging.pagePerBlock }">
							<button type="button" class="disable">&lt;</button>
						</c:when>
						<c:otherwise>
							<button type="button" class="entity"
								onclick="location.href='c_center_go.do?cPage=${paging.beginBlock - paging.pagePerBlock }'">&lt;</button>
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
									onclick="location.href='c_center_go.do?cPage=${k}'">${k}
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
								onclick="location.href='c_center_go.do?cPage=${paging.beginBlock + paging.pagePerBlock }'">&gt;
							</button>
						</c:otherwise>
					</c:choose>
				</div>
			</article>
		</section>
	</div>
	<script type="text/javascript">
	$(document).ready(function() {
		$(".m_subject").click(function() {
					$(this).parent().next().toggle();
					$(this).parent().next().next().toggle();
					
			});		
	});
	</script>
</body>
</html>