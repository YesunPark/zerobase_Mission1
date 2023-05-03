<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="location.HistoryDAO"%>
<%@ page import="java.io.PrintWriter"%>
<%
request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="location" class="location.HistoryDTO" scope="page" />
<jsp:setProperty name="location" property="xCoordinate" />
<jsp:setProperty name="location" property="yCoordinate" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" charset="text/html; charset=UTF-8">
<title>Mission1</title>
</head>
<body>
	<%
	HistoryDAO historyDAO = new HistoryDAO();
	int result = historyDAO.saveLocationHistory(1, 2);

	if (result == 1) {
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('저장 성공!')");
		script.println("</script>");
	} else {
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('데이터베이스에 오류가 발생했습니다. 다시 시도해주십시오.')");
		script.println("</script>");
	}
	%>
</body>
</html>