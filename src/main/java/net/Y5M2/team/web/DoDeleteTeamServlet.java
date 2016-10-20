package net.Y5M2.team.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.Y5M2.constants.Session;
import net.Y5M2.support.Param;
import net.Y5M2.team.biz.TeamBiz;
import net.Y5M2.team.biz.TeamBizImpl;
import net.Y5M2.user.vo.UserVO;

public class DoDeleteTeamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TeamBiz teamBiz;
	public DoDeleteTeamServlet() {
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
		HttpSession session = request.getSession();
		UserVO userVO = (UserVO) session.getAttribute(Session.USER_INFO);
		boolean isSuccess = teamBiz.deleteTeam(teamId, userVO, request);
		if ( isSuccess ) {
			response.sendRedirect("/ShootBoy/userInfo");
		}
		else{
			response.sendRedirect("/ShootBoy/detailTeamInfo?errorCode=1");
		}
	}

}
