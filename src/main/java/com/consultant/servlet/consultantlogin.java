package com.consultant.servlet;

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

@WebServlet("/consultantLogin")
public class consultantlogin extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String email = req.getParameter("email");
		String password = req.getParameter("password");

		HttpSession session = req.getSession();

		ConsultantDao dao = new ConsultantDao(DBConnect.getConn());
		Consultant Consultant = dao.login(email, password);

		if (Consultant != null) {
			session.setAttribute("consultObj", Consultant);
			resp.sendRedirect("consultant/index.jsp");
		} else {
			session.setAttribute("errorMsg", "invalid email & password");
			resp.sendRedirect("consultant-login.jsp");
		}

	}

}