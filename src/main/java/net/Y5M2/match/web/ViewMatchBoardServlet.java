package net.Y5M2.match.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.Y5M2.match.biz.MatchBiz;
import net.Y5M2.match.biz.MatchBizImpl;
import net.Y5M2.match.vo.MatchVO;
import net.Y5M2.support.Param;



public class ViewMatchBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MatchBiz matchBiz;
	
	public ViewMatchBoardServlet() {
		super();
		matchBiz = new MatchBizImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String teamId = Param.getStringParam(request, "teamId");
		
		String viewPath = "/WEB-INF/view/match/matchBoard.jsp";
		
		List<MatchVO> matchVO =  matchBiz.getAllMatchTeam(teamId);
		
		RequestDispatcher rd = request.getRequestDispatcher(viewPath);
		
		request.setAttribute("matchVO", matchVO);
		
		rd.forward(request, response);
		
	}

}
