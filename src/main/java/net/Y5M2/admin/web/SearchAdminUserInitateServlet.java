package net.Y5M2.admin.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.Y5M2.constants.Session;

public class SearchAdminUserInitateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SearchAdminUserInitateServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.removeAttribute(Session.SEARCH_USER_INFO);

		response.sendRedirect("/ShootBoy/adminMember");
	}

}
