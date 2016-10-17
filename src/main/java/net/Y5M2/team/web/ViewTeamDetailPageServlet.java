package net.Y5M2.team.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.Y5M2.support.Param;
import net.Y5M2.team.biz.TeamBiz;
import net.Y5M2.team.biz.TeamBizImpl;
import net.Y5M2.team.vo.TeamVO;

public class ViewTeamDetailPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TeamBiz teamBiz;

	public ViewTeamDetailPageServlet() {
		super();
		teamBiz = new TeamBizImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String teamId = Param.getStringParam(request, "teamId");
		
		TeamVO team = teamBiz.getTeamAt(teamId);
		String viewPath = "/WEB-INF/view/team/teamDetail.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(viewPath);
		request.setAttribute("team", team);
		rd.forward(request, response);
	}

}
