package net.Y5M2.main.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.Y5M2.article.biz.BoardBiz;
import net.Y5M2.article.biz.BoardBizImpl;
import net.Y5M2.article.vo.BoardVO;
import net.Y5M2.match.biz.MatchBiz;
import net.Y5M2.match.biz.MatchBizImpl;
import net.Y5M2.match.vo.MatchVO;

public class ViewMainPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private BoardBiz boardBiz;
	private MatchBiz matchBiz;
	
	public ViewMainPageServlet() {
		super();
		boardBiz = new BoardBizImpl();
		matchBiz = new MatchBizImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				
		List<BoardVO> boards = boardBiz.getAllBoard();
		String locationId = "0";
		List<MatchVO> matchList = matchBiz.getAllMatchList();
		List<MatchVO> matchTeams = matchBiz.getMatchApplyTeamsOf(locationId);
		
		String viewPath = "/WEB-INF/view/main.jsp";
		request.setAttribute("boards", boards);
		request.setAttribute("matchList", matchList);
		request.setAttribute("matchTeams", matchTeams);
		RequestDispatcher rd = request.getRequestDispatcher(viewPath);
		rd.forward(request, response);
	}
}
