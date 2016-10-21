package net.Y5M2.teamjoin.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.Y5M2.constants.Session;
import net.Y5M2.support.Param;
import net.Y5M2.teamjoin.biz.TeamJoinBiz;
import net.Y5M2.teamjoin.biz.TeamJoinBizImpl;
import net.Y5M2.user.vo.UserVO;

public class DoTeamJoin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TeamJoinBiz teamJoinBiz;
	
	public DoTeamJoin() {
		super();
		teamJoinBiz = new TeamJoinBizImpl();
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
		
		boolean isSuccess = teamJoinBiz.SaveTeamJoinId(teamId, userVO);
		if(isSuccess){
			response.sendRedirect("/ShootBoy/teamDetail?teamId="+teamId);
		}
		else{
			response.sendRedirect("/ShootBoy/teamDetail?teamId="+teamId+"&&erroCode=1");
		}

	}

}
