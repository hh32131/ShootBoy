package net.Y5M2.team.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.Y5M2.constants.Session;
import net.Y5M2.match.biz.MatchBiz;
import net.Y5M2.match.biz.MatchBizImpl;
import net.Y5M2.match.vo.MatchVO;
import net.Y5M2.teammatch.biz.TeamMatchBiz;
import net.Y5M2.teammatch.biz.TeamMatchBizImpl;
import net.Y5M2.teammatch.vo.TeamMatchVO;
import net.Y5M2.user.vo.UserVO;

public class ViewTeamMatchInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private TeamMatchBiz teamMatchBiz;
	private MatchBiz matchBiz;
	
    public ViewTeamMatchInfoServlet() {
        super();
        teamMatchBiz = new TeamMatchBizImpl();
        matchBiz = new MatchBizImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		UserVO userVO = (UserVO) session.getAttribute(Session.USER_INFO);
		String teamId = userVO.getTeamId();
		
		List<TeamMatchVO> matchs = teamMatchBiz.getMyApply(teamId);
		request.setAttribute("matchs", matchs);
		
		List<MatchVO> completeMatch = matchBiz.getCompleteMatch(teamId);
		
		String viewPath = "/WEB-INF/view/team/teamMatchInfo.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(viewPath);
		request.setAttribute("completeMatch", completeMatch);
		rd.forward(request, response);
	}

}
