package com.user.servlet;

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

@WebServlet("/consultUpdateProfile")
public class EditProfile extends HttpServlet {

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

			int id = Integer.parseInt(req.getParameter("id"));

			Consultant c = new Consultant(id,fullName, dob, qualification, spec, email, mobno, "");

			ConsultantDao dao = new ConsultantDao(DBConnect.getConn());
			HttpSession session = req.getSession();

			if (dao.editConsultantProfile(c)) {
				session.setAttribute("succMsg", "Update Sucessfully..");
				resp.sendRedirect("consultant/edit_profile.jsp");
			} else {
				session.setAttribute("errorMsg", "Something wrong on server");
				resp.sendRedirect("consultant/edit_profile.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}