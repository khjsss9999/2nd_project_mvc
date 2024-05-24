<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<!-- css -->
<link href="resources/css/reset.css" rel="stylesheet">
<link href="resources/css/mypage.css" rel="stylesheet">
<!-- 아이콘들 -->
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
<script type="text/javascript">
	function update() {
		location.href="update.do";
	}
	function update_pwd() {
		location.href="update_pwd.do";
	}
	
</script>
</head>
<body>
	<section id="first">
		<article id="f_info">
			<div id="info_pro">
				<p>프로필</p>
				<div class="infos">
					<p>
						<span class="material-symbols-outlined">유저네임</span>
					</p>
					<p>이름 : ${uvo.user_name}</p>
				</div>
				<div class="infos">
					<p>
						<span class="material-symbols-outlined">유저아이디</span>
					</p>
					<p>아이디 : ${uvo.user_id}</p>
				</div>
				<div class="infos">
					<p>
						<span class="material-symbols-outlined">유저 핸드폰번호</span>
					</p>
					<p>번호 : ${uvo.user_phone}</p>
				</div>
				<div class="infos">
					<p>
						<span class="material-symbols-outlined">유저 이메일</span>
					</p>
					<p>이메일 : ${uvo.user_f_email}@${uvo.user_b_email}</p>
				</div>
				<div class="infos">
					<p>
						<span class="material-symbols-outlined">유저 주소</span>
					</p>
					<p>주소 : ${uvo.user_main_addr}
						<c:choose>
							<c:when test="${!empty uvo.user_detail_addr}">, ${uvo.user_detail_addr}</c:when>
							<c:otherwise></c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${!empty uvo.user_ex_addr}">, ${uvo.user_ex_addr}</c:when>
							<c:otherwise></c:otherwise>
						</c:choose>
					</p>
				</div>
				
				<button class="move_btn" onclick="update()">회원정보 수정</button>
				<button class="move_btn" onclick="update_pwd()">비밀번호 수정</button>
			</div>
		</article>
	</section>
	<script type="text/javascript">
		
		$(".move_btn").hover(
			    function() {
			        $(this).css("fontWeight", "bold");
			        $(this).css("backgroundColor", "lightgray");
			        
			    },
			    function() {
			        $(this).css("fontWeight", "normal");
			        $(this).css("backgroundColor", "transparent");
			    }
			);
		
	</script>
</body>
</html>