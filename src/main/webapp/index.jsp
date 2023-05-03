<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mission1</title>
</head>
<body>
	<h1>와이파이 정보 구하기</h1>
	
	<a href="index.jsp" style="padding: 0px 6px 0px 3px; border-right:1px solid black;">홈</a>
	<a href="./jsp/history.jsp" style="padding: 0px 6px 0px 3px; border-right:1px solid black;">위치 히스토리 목록</a>
	<a href="./jsp/wifi.jsp" style="padding: 0px 6px 0px 3px; ">Open API 와이파이 정보 가져오기</a>
	<br/>
	<br/>
	
	<span>LAT: </span>
	<input placeholder="0.0"/>
	<span>, LNT: </span>
	<input placeholder="0.0"/>
	
	<button>내 위치 가져오기</button>
	<button>근처 WIFI 정보보기</button>
	
	<br/>
	<br/>
	
	<table style="width:100%; boder: 1px solid white;">
		<thead style="background-color:lightgreen;">
		<tr style="height:40px;">
			<th>거리(Km)</th>
			<th>관리번호</th>
			<th>자치구</th>
			<th>와이파이명</th>
			<th>도로명주소</th>
			<th>상세주소</th>
			<th>설치위치(층)</th>
			<th>설치유형</th>
			<th>설치기관</th>
			<th>서비스구분</th>
			<th>망종류</th>
			<th>설치년도</th>
			<th>실내외구분</th>
			<th>WIFI접속환경</th>
			<th>X좌표</th>
			<th>Y좌표</th>
			<th>작업일자</th>
		</tr>
		</thead>
		<tbody >
			<tr>
			    <td>1열 1행 </td>
			    <td>2열 1행 </td>
			</tr>
			<tr>
			    <td>1열 2행 </td>
			    <td>2열 2행 </td>
			</tr>
		</tbody>
	</table>

<%-- <%
	
%> --%>
</body>
</html>