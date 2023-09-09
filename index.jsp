<%@page import="com.db.DBConnect"%>
<%@page import="java.sql.Connection"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="css/allcss.jsp" %>

<style type="text/css">

body{
background-color:rgb(68, 68, 68);
}
#carouselExampleIndicators{
margin-top:40px;
margin-bottom:40px
}

.container.p-3{
font-color:white;
}

</style>

</head>
<body>

<%@include file="css/navbar.jsp" %>



<div id="carouselExampleIndicators" class="carousel slide" data-bs-ride="carousel">
  <div class="carousel-indicators">
    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1" aria-label="Slide 2"></button>
    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2" aria-label="Slide 3"></button>
  </div>
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img src="images/index1.svg" class="d-block w-100" alt="..." height="500px">
    </div>
    <div class="carousel-item">
      <img src="images/index2.svg" class="d-block w-100" alt="..." height="500px">
    </div>
    <div class="carousel-item">
      <img src="images/index3.svg" class="d-block w-100" alt="..." height="500px">
    </div>
  </div>
  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Previous</span>
  </button>
  <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Next</span>
  </button>
</div>


<div class="container p-3">
		<p class="text-center fs-2 ">Key Features of Our Service</p>

		<div class="row">
			<div class="col-md-8 p-5">
				<div class="row">
					<div class="col-md-6">
						<div class="card paint-card">
							<div class="card-body">
								<p class="fs-5">Guidance</p>
								<p>Our Consultants can and will provide you with thorough guidance on finding jobs Abroad </p>
							</div>
						</div>
					</div>
					<div class="col-md-6">
						<div class="card paint-card">
							<div class="card-body">
								<p class="fs-5">Expenditures</p>
								<p> Guaranteed that there are no costs involved for you to receive consultation</p>
							</div>
						</div>
					</div>
					<div class="col-md-6 mt-2">
						<div class="card paint-card">
							<div class="card-body">
								<p class="fs-5">Consultants</p>
								<p>Each Consultant is extremely knowlegable and has experience migrating and working in relevant countries as per their expertise.</p>
							</div>
						</div>
					</div>
					<div class="col-md-6 mt-2">
						<div class="card paint-card">
							<div class="card-body">
								<p class="fs-5">Making Appointment</p>
								<p>Our Consultant work on a part time basis so be aware of their available days mentioned in their BIO. </p>
							</div>
						</div>
					</div>
				</div>
			</div>

			<div class="col-md-4">
				<img alt="" src="images/feat.svg" height="300px">
			</div>

		</div>
	</div>
<hr>

	<div class="container p-2">
		<p class="text-center fs-2 ">Our Team</p>
		
		<div class="row">
			<div class="col-md-3">
				<div class="card paint-card">
					<div class="card-body text-center">
						<img src="images/exprofile.svg" width="250px" height="300px">
						<p class="fw-bold fs-5">Roy Smith</p>
						<p class="fs-7">Consults migration and working in US and Canada</p>
						<p class="fs-7">Monday, Tuesday, Friday available from 9 AM to 5 PM</p>
					</div>
				</div>
			</div>

			<div class="col-md-3">
				<div class="card paint-card">
					<div class="card-body text-center">
						<img src="images/exprofile.svg" width="250px" height="300px">
						<p class="fw-bold fs-5">Dr.Kumar Silva</p>
						<p class="fs-7">Consults on migration and working in UK</p>
						<p class="fs-7">Monday, Thursday, Saturday, Sunday available from 9 AM to 5 PM</p>
					</div>
				</div>
			</div>

			<div class="col-md-3">
				<div class="card paint-card">
					<div class="card-body text-center">
						<img src="images/exprofile.svg" width="250px" height="300px">
						<p class="fw-bold fs-5"> Niel Paule</p>
						<p class="fs-7">Consults on migration and working in Australia</p>
					<p class="fs-7">Monday, Friday, Saturday, Sunday available from 9 AM to 5 PM</p>
					</div>
				</div>
			</div>

			<div class="col-md-3">
				<div class="card paint-card">
					<div class="card-body text-center">
						<img src="images/exprofile.svg" width="250px" height="300px">
						<p class="fw-bold fs-5">Matthew Samuel</p>
						<p class="fs-7">Consults on migration and working in New Zealand</p>
						<p class="fs-7">Saturday, Sunday, Tuesday available from 9 AM to 5 PM</p>
					</div>
				</div>
			</div>

		</div>

	</div>

<%@include file="css/footer.jsp" %>
</body>
</html>