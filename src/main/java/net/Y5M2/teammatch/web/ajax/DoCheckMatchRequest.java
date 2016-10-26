package net.Y5M2.teammatch.web.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.Y5M2.constants.Session;
import net.Y5M2.support.Param;
import net.Y5M2.teammatch.biz.TeamMatchBiz;
import net.Y5M2.teammatch.biz.TeamMatchBizImpl;
import net.Y5M2.user.vo.UserVO;

public class DoCheckMatchRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private TeamMatchBiz teamMatchBiz;
	public DoCheckMatchRequest() {
		super();
		teamMatchBiz = new TeamMatchBizImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		UserVO userVO = (UserVO) session.getAttribute(Session.USER_INFO);
		String teamId = userVO.getTeamId();
		String matchId = Param.getStringParam(request, "matchId");
		
		boolean isSuccess = teamMatchBiz.isExistTeam(teamId, matchId);
		PrintWriter out = response.getWriter();
		out.write(isSuccess+"");
		out.flush();
		out.close();
		
	}

}
