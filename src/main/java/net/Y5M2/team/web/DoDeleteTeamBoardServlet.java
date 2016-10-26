package net.Y5M2.team.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.Y5M2.support.Param;
import net.Y5M2.team.biz.TeamBiz;
import net.Y5M2.team.biz.TeamBizImpl;

public class DoDeleteTeamBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TeamBiz teamBiz;
	
	public DoDeleteTeamBoardServlet() {
		super();
		teamBiz = new TeamBizImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	String teamBoardId = Param.getStringParam(request, "teamBoardId");
		
		boolean isSuccess = teamBiz.deleteTeamBoard(teamBoardId);
		if ( isSuccess ) {
		
			response.sendRedirect("/ShootBoy/teamBoard");
		}
		else {
			response.sendRedirect("/ShootBoy/detailTeamBoard?teamBoardId="+teamBoardId);
		}
		
	}

}
