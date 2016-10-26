package net.Y5M2.match.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.Y5M2.constants.Session;
import net.Y5M2.teammatch.biz.TeamMatchBiz;
import net.Y5M2.teammatch.biz.TeamMatchBizImpl;
import net.Y5M2.teammatch.vo.TeamMatchVO;
import net.Y5M2.user.vo.UserVO;

public class ViewMatchApplyManagement extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private TeamMatchBiz teamMatchBiz;
    public ViewMatchApplyManagement() {
        super();
        teamMatchBiz = new TeamMatchBizImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String viewPath = "/WEB-INF/view/match/matchApplyManagement.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(viewPath);
		
		HttpSession session = request.getSession();
		UserVO userVO = (UserVO) session.getAttribute(Session.USER_INFO);
		
		List<TeamMatchVO> matchs = teamMatchBiz.getMatchApplyOf(userVO.getTeamId());
		request.setAttribute("matchs", matchs);
		
		rd.forward(request, response);	
	}

}
