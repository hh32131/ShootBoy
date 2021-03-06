package net.Y5M2.match.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.Y5M2.constants.Session;
import net.Y5M2.match.biz.MatchBiz;
import net.Y5M2.match.biz.MatchBizImpl;
import net.Y5M2.support.Param;
import net.Y5M2.user.vo.UserVO;

public class DoDeleteTeamMatch extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private MatchBiz matchBiz;
	
	public DoDeleteTeamMatch() {
		super();
		matchBiz = new MatchBizImpl();
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
		
		boolean isSuccess = matchBiz.deleteTeamMatch(teamId, matchId);
		PrintWriter out = response.getWriter();
		out.write(isSuccess+"");
		out.flush();
		out.close();
		
	}

}
