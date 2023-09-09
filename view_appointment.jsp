<%@page import="com.entity.User"%>
<%@page import="com.entity.Consultant"%>
<%@page import="com.dao.ConsultantDao"%>
<%@page import="com.entity.Appointment"%>
<%@page import="java.util.List"%>
<%@page import="com.db.DBConnect"%>
<%@page import="com.dao.AppointmentDao"%>
<%@ page language="java" 
contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="css/allcss.jsp"%>


</head>
<body>
	<c:if test="${empty userObj }">
	<c:redirect url="user-login.jsp"></c:redirect>
	</c:if>
	<%@include file="css/navbar.jsp"%>

	<div class="container-fulid ">
		<p class="text-center fs-2 text-white"></p>
	</div>
	<div class="container p-3 offset-2">
		<div class="row">
			<div class="col-md-9">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-4 fw-bold text-center text-success">Appointment
							List</p>
						<table class="table">
							<thead>
								<tr>
									<th scope="col">Full Name</th>
									<th scope="col">Gender</th>
									<th scope="col">Age</th>
									<th scope="col">Appointment Date</th>
									<th scope="col">Type of Job</th>
									<th scope="col">Consultant</th>
									<th scope="col">Status</th>
									

								</tr>
							</thead>
							<tbody>
						<%
								User user = (User) session.getAttribute("userObj");
								AppointmentDao dao = new AppointmentDao(DBConnect.getConn());
								ConsultantDao dao2 = new ConsultantDao(DBConnect.getConn());
								List<Appointment> list = dao.getAllAppointmentByLoginUser(user.getId());
								for (Appointment ap : list) {
									Consultant c = dao2.getConsultantById(ap.getConsultantId());
									%>
							
							<tr>
							<td><%=ap.getFullName()%></td>
							<td><%=ap.getGender()%></td>
							<td><%=ap.getAge()%></td>
							<td><%=ap.getAppoinDate()%></td>
							<td><%=ap.getTypejob()%></td>
							<td><%=c.getFullName()%></td>
						
							<td>
							
							<%if("Pending".equals(ap.getStatus())) {%>
								<a href="#" class="btn btn-sm btn-warning">Pending</a>
								
								<%}else{%>
									<%=ap.getStatus()%>
										
								<%}
								%>
							
							</td>
							</tr>
							<%
							}
							%>
							
							</tbody>
						</table>

					</div>
				</div>
			</div>

			
		</div>
	</div>


</body>
</html>