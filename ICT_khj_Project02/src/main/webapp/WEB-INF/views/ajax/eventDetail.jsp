<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	$("#result").empty();
	$.ajax({
		url : "event_detail_ok.do,
		method : "post",
		dataType : "xml",
		data:{
			mt20id:${mt20id}
		},
		success : function(data) {
			console.log(data);
			let tbody = "";
			$(data).find("dbs").find("db").each(function() {
				tbody += "<tr>";
				tbody += "<td>"+$(this).find("mt20id").text()+"</td>";
				tbody += "<td>"+$(this).find("mt10id").text()+"</td>";
				tbody += "<td>"+$(this).find("prfnm").text()+"</td>";
				tbody += "<td>"+$(this).find("prfpdfrom").text()+"</td>";
				tbody += "<td>"+$(this).find("prfpdto").text()+"</td>";
				tbody += "<td>"+$(this).find("fcltynm").text()+"</td>";
				tbody += "</tr>";
			});
			$("#tbody").append(tbody);
		},
		error : function() {
			alert("읽기 실패");
		}
	});
});
</script>
</head>
<body>
	<h2>공연 상세보기</h2>
	<table>
		<thead>
			<tr>
				<td>공연ID</td><td>공연시설ID</td><td>공연명</td><td>공연시작일</td><td>공연종료일</td><td>공연시설명(공연장명)</td> 
			</tr>
		</thead>
		<tbody id="tbody"></tbody>
	</table>
</body>
</html>