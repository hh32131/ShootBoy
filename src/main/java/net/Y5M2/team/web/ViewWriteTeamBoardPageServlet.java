package net.Y5M2.team.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.Y5M2.support.Param;

public class ViewWriteTeamBoardPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ViewWriteTeamBoardPageServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String teamId = Param.getStringParam(request, "teamId");
		
		
		String viewpath = "/WEB-INF/view/team/teamBoardWrite.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(viewpath);
		request.setAttribute("teamId", teamId);	
		rd.forward(request, response);
	}

}
