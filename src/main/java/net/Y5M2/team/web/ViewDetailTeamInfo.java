package net.Y5M2.team.web;

import java.io.Console;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.Y5M2.constants.Session;
import net.Y5M2.team.biz.TeamBiz;
import net.Y5M2.team.biz.TeamBizImpl;
import net.Y5M2.team.vo.TeamVO;
import net.Y5M2.teamjoin.biz.TeamJoinBiz;
import net.Y5M2.teamjoin.biz.TeamJoinBizImpl;
import net.Y5M2.teamjoin.vo.TeamJoinVO;
import net.Y5M2.user.biz.UserBiz;
import net.Y5M2.user.biz.UserBizImpl;
import net.Y5M2.user.vo.UserVO;

public class ViewDetailTeamInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TeamBiz teamBiz;
	private TeamJoinBiz teamJoinBiz;
	private UserBiz userBiz;
	
	public ViewDetailTeamInfo() {
		super();
		teamBiz = new TeamBizImpl();
		teamJoinBiz = new TeamJoinBizImpl();
		userBiz = new UserBizImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		UserVO userInfo = (UserVO) session.getAttribute(Session.USER_INFO);
		
		TeamVO teamInfo = teamBiz.getTeamAt(userInfo.getTeamId());
		String teamId = userInfo.getTeamId();
		
		List<TeamJoinVO> joins = teamJoinBiz.getTeamJoinId(userInfo.getTeamId());
		List<UserVO> users = userBiz.getAllUsersOfTeam(teamId);
		
		String viewPath = "/WEB-INF/view/team/detailTeamInfo.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(viewPath);
		request.setAttribute("userInfo", userInfo);
		request.setAttribute("teamInfo", teamInfo);
		request.setAttribute("users", users);
		request.setAttribute("joins", joins);
		rd.forward(request, response);
	}

}
