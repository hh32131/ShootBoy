package net.Y5M2.user.web;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DoLogOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DoLogOutServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Enumeration<String> headers = request.getHeaderNames();
		String key = "";
		while(headers.hasMoreElements()) {
			key = headers.nextElement();
			System.out.printf("%s, %s \n", key, request.getHeader(key));
		}
		
		String Referer = request.getHeader("referer");
		System.out.println("Referer = " + Referer);
		
		
		HttpSession session = request.getSession();
		session.invalidate();
		
		if(Referer.equals("")){
			response.sendRedirect("/ShootBoy/main");
		}
		else {
			response.sendRedirect(Referer);
		}
	}

}
