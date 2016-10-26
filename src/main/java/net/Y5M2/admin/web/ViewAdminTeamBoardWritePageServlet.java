package net.Y5M2.admin.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.Y5M2.team.biz.TeamBiz;
import net.Y5M2.team.biz.TeamBizImpl;

public class ViewAdminTeamBoardWritePageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private TeamBiz teamBiz;
	
	public ViewAdminTeamBoardWritePageServlet() {
		super();
		teamBiz = new TeamBizImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	

		String viewpath = "/WEB-INF/view/admin/adminTeamBoardWrite.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(viewpath);
		rd.forward(request, response);
	}

}
