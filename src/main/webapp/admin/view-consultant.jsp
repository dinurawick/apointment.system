<%@page import="com.entity.Consultant"%>
<%@page import="com.dao.ConsultantDao"%>
<%@page import="com.entity.Consultant"%>
<%@page import="java.util.List"%>
<%@page import="com.entity.Specialist"%>
<%@page import="com.dao.SpecialistDao"%>
<%@page import="com.entity.Specialist"%>
<%@page import="com.db.DBConnect"%>
<%@page import="com.dao.SpecialistDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="../css/allcss.jsp"%>
<style type="text/css">
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}
</style>
</head>
<body>
	<%@include file="navbar.jsp"%>
	<c:if test="${ empty adminObj }">
		<c:redirect url="../admin-login.jsp"></c:redirect>
	</c:if>
	
	<div class="container-fluid p-3">
		<div class="row">

			

			<div class="col-md-12">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-3 text-center">Consultant Details</p>
						<table class="table">
						<thead>
							<tr>
							<th scope="col">Full Name</th>
							<th scope="col">DOB</th>
							<th scope="col">Qualification</th>
							<th scope="col">Specialization</th>
							<th scope="col">Email</th>
							<th scope="col">Contact</th>
							<th scope="col">action</th>
							
							</tr>
						</thead>
						<tbody>
							<%
							ConsultantDao dao=new ConsultantDao(DBConnect.getConn());
							List<Consultant> list=dao.getAllConsultant();
							for(Consultant c:list)
							{%>
							<tr>
								<td><%=c.getFullName()%></td>
								<td><%=c.getDob()%></td>
								<td><%=c.getQualification()%></td>
								<td><%=c.getSpecialist()%></td>
								<td><%=c.getEmail()%></td>
								<td><%=c.getMobNo()%></td>
								<td>
							
								<a href="../deleteConsultant?id=<%=c.getId()%>" class="btn btn-sm btn-danger">Delete</a>
								</td>
							</tr>
							
							<%}
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