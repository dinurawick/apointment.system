<%@page import="com.entity.Consultant"%>
<%@page import="com.entity.Consultant"%>
<%@page import="com.db.DBConnect"%>
<%@page import="com.dao.ConsultantDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}
</style>
<%@include file="../css/allcss.jsp"%>
</head>
<body>
	<c:if test="${empty consultObj }">
		<c:redirect url="../consultant-login.jsp"></c:redirect>
	</c:if>


	<%@include file="navbar.jsp"%>

	<p class="text-center fs-3">Consultant Dashboard</p>

	<%
	Consultant c = (Consultant) session.getAttribute("consultObj");
	ConsultantDao dao = new ConsultantDao(DBConnect.getConn());
	%>
	<div class="container p-5">
		<div class="row">
			<div class="col-md-4 offset-md-2">
				<div class="card paint-card">
					<div class="card-body text-center text-success">
						<i class="fas fa-user-md fa-3x"></i><br>
						<p class="fs-4 text-center">
							Doctor <br><%=dao.countConsultant()%>
						</p>
					</div>
				</div>
			</div>


			<div class="col-md-4">
				<div class="card paint-card">
					<div class="card-body text-center text-success">
						<i class="far fa-calendar-check fa-3x"></i><br>
						<p class="fs-4 text-center">
							Total Appointment <br>
							<%=dao.countAppointmentByConsultantId(c.getId())%>
						</p>
					</div>
				</div>
			</div>

		</div>
	</div>
</body>
</html>