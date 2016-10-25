package net.Y5M2.teammatch.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.Y5M2.constants.Session;
import net.Y5M2.match.vo.MatchVO;
import net.Y5M2.support.Param;
import net.Y5M2.teammatch.biz.TeamMatchBiz;
import net.Y5M2.teammatch.biz.TeamMatchBizImpl;

public class DoMatchRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TeamMatchBiz teamMatchBiz;
	
	public DoMatchRequest() {
		super();
		teamMatchBiz = new TeamMatchBizImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String teamId = Param.getStringParam(request, "teamId");
		HttpSession session = request.getSession();
		MatchVO matchVO = (MatchVO) session.getAttribute(Session.SEARCH_TEAM_INFO);
		
		boolean isSuccess = teamMatchBiz.teamMatchRequest(teamId, matchVO);
		
		if ( isSuccess ) {
			response.sendRedirect("/ShootBoy/teamBoard?teamId=" + teamId);
		}
		else{
			response.sendRedirect("/ShootBoy/teamBoard?teamId="+teamId+"&&errorCode=1");
		}
	}

}
