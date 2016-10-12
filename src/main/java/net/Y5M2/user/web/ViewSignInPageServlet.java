package net.Y5M2.user.web;

import java.io.IOException;
<<<<<<< HEAD
=======
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
>>>>>>> d448ce0edae533fd6ed89e0ec272981fa678b4f4
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewSignInPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
<<<<<<< HEAD
	
	public ViewSignInPageServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

=======
       
    public ViewSignInPageServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Enumeration<String> headers = request.getHeaderNames();
		String key = "";
		while(headers.hasMoreElements()) {
			key = headers.nextElement();
			System.out.printf("%s, %s \n", key, request.getHeader(key));
		}
		
		String Referer = request.getHeader("referer");
		System.out.println("Referer = " + Referer);
		String viewPath = "/WEB-INF/view/signIn.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(viewPath);
		request.setAttribute("Referer", Referer);
		rd.forward(request, response);
>>>>>>> d448ce0edae533fd6ed89e0ec272981fa678b4f4
	}

}
