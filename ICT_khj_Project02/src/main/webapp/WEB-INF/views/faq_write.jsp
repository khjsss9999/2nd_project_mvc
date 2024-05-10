<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function faq_write_go(f) {
		for (var i = 0; i < f.elements.length; i++) {
			if (f.elements[i].value == "") {
				if(i == 0){
					continue;
				}
				alert(f.elements[i].name + "를 입력하세요");
				f.elements[i].focus();
				return;//수행 중단
			}
		}
		f.submit();
	}
	function back() {
		location.href = "c_center_go.do";
	}
</script>
</head>
<body>
<form action="faq_write_ok" method="post">
		
		<table width="700" style="margin: 200px auto; border: 1px solid black;">
			<caption style="font-size: 20px; font-weight: bold;">
				FaQ글 채워넣기
			</caption>
		<tbody>
			<tr>
				<th>제목</th>
				<td align="left"><input type="text" name="faq_subject"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td align="left">
					<textarea rows="10" cols="60" name="faq_content"></textarea>
				</td>
			</tr>
			<tr>
				<th>답글</th>
				<td align="left">
					<textarea rows="10" cols="60" name="faq_reply"></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2">
				<input type="button" value="입력" onclick="faq_write_go(this.form)" /> 
				<input type="button" value="취소" onclick="back()" />
				</td>
			</tr>
            </tbody>
		</table>
	</form>
</body>
</html>