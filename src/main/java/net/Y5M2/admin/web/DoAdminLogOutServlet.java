package net.Y5M2.admin.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DoAdminLogOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DoAdminLogOutServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
<<<<<<< HEAD
		
=======
>>>>>>> 7eaa7589338aa63aa31e07d3056704adf81f7eb4
		HttpSession session = request.getSession();
		session.invalidate();
		
		response.sendRedirect("/ShootBoy/main");
		
	}
}