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

@WebServlet("/deleteConsultant")
public class DeleteConsultant extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("id"));
		
		ConsultantDao dao = new ConsultantDao(DBConnect.getConn());
		HttpSession session = req.getSession();

		if (dao.deleteConsultant(id)) {
			session.setAttribute("succMsg", " Deleted Sucessfully");
			resp.sendRedirect("admin/view-consultant.jsp");
		} else {
			session.setAttribute("errorMsg", "Something wrong on server");
			resp.sendRedirect("admin/view-consultant.jsp");
		}
		

	}

}