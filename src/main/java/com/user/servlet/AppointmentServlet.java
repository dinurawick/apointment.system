package com.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.AppointmentDao;
import com.db.DBConnect;
import com.entity.Appointment;

@WebServlet("/appAppointment")
public class AppointmentServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int userId = Integer.parseInt(req.getParameter("userid"));
		String fullname = req.getParameter("fullname");
		String gender = req.getParameter("gender");
		String age = req.getParameter("age");
		String appointdate = req.getParameter("appointdate");
		String email = req.getParameter("email");
		String phno = req.getParameter("phno");
		String typejob = req.getParameter("typejob");
		int consultant_id = Integer.parseInt(req.getParameter("consult"));
		

		Appointment ap = new Appointment(userId, fullname, gender, age, appointdate, email, phno, typejob, consultant_id, "Pending");

		AppointmentDao dao = new AppointmentDao(DBConnect.getConn());
		HttpSession session = req.getSession();

		if (dao.addAppointment(ap)) {
			session.setAttribute("succMsg", "Appointment Sucessfully");
			resp.sendRedirect("appointment.jsp");
		} else {
			session.setAttribute("errorMsg", "Something wrong on server");
			resp.sendRedirect("appointment.jsp");
		}

	}

}