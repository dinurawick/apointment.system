package com.admin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.ConsultantDao;
import com.db.DBConnect;
import com.entity.Consultant;

@WebServlet("/addConsultant")
public class AddConsultant extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {

			String fullName = req.getParameter("fullname");
			String dob = req.getParameter("dob");
			String qualification = req.getParameter("qualification");

			String spec = req.getParameter("spec");

			String email = req.getParameter("email");
			String mobno = req.getParameter("mobno");
			String password = req.getParameter("password");

			Consultant c = new Consultant(fullName, dob, qualification, spec, email, mobno, password);

			ConsultantDao dao = new ConsultantDao(DBConnect.getConn());
			HttpSession session = req.getSession();

			if (dao.registerConsultant(c)) {
				session.setAttribute("succMsg", "Added Sucessfully");
				resp.sendRedirect("admin/consultant.jsp");
			} else {
				session.setAttribute("errorMsg", "Something went wrong...");
				resp.sendRedirect("admin/consultant.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}