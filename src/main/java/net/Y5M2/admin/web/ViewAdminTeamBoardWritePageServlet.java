package net.Y5M2.admin.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.Y5M2.admin.biz.AdminBiz;
import net.Y5M2.admin.biz.AdminBizImpl;
import net.Y5M2.team.biz.TeamBiz;
import net.Y5M2.team.biz.TeamBizImpl;
import net.Y5M2.team.vo.TeamVO;

public class ViewAdminTeamBoardWritePageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private AdminBiz adminBiz;
	
	public ViewAdminTeamBoardWritePageServlet() {
		super();
		adminBiz = new AdminBizImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		List<TeamVO> teamVO = adminBiz.getAllTeams();
		
		String viewpath = "/WEB-INF/view/admin/adminTeamBoardWrite.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(viewpath);
		request.setAttribute("teamVO", teamVO);
		rd.forward(request, response);
	}

}
