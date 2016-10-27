package net.Y5M2.match.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.Y5M2.article.vo.SearchBoardVO;
import net.Y5M2.constants.Session;
import net.Y5M2.match.biz.MatchBiz;
import net.Y5M2.match.biz.MatchBizImpl;
import net.Y5M2.match.vo.MatchListVO;
import net.Y5M2.match.vo.MatchVO;
import net.Y5M2.match.vo.SearchMatchVO;
import net.Y5M2.support.Param;
import net.Y5M2.support.pager.ClassicPageExplorer;
import net.Y5M2.support.pager.PageExplorer;



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
		
		HttpSession session = request.getSession();
		int pageNo = Param.getIntParam(request, "pageNo", -1);
		int searchType = Param.getIntParam(request, "searchType");
		String searchKeyword = Param.getStringParam(request, "searchKeyword");
		
		
		SearchMatchVO searchMatch = null;
		
		if (pageNo == -1) {
			searchMatch = (SearchMatchVO) session.getAttribute(Session.SEARCH_MATCH_INFO);
			if (searchMatch == null) {
				searchMatch = new SearchMatchVO();
				searchMatch.setPageNo(0);
			}
		} else {
			searchMatch = new SearchMatchVO();
			searchMatch.setPageNo(pageNo);
			searchMatch.setSearchType(searchType);
			searchMatch.setSearchKeyword(searchKeyword);
		}
		
		session.setAttribute(Session.SEARCH_MATCH_INFO, searchMatch);
		MatchListVO matchs = matchBiz.getAllMatchTeam(searchMatch);
		
		String viewPath = "/WEB-INF/view/match/matchBoard.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(viewPath);
		request.setAttribute("matchs", matchs.getMatchs());
		request.setAttribute("pager", matchs.getPager());
		
		
		PageExplorer pageExplorer = new ClassicPageExplorer(matchs.getPager());
		String pager = pageExplorer.getPagingList("pageNo", "[@]", "<<", ">>", "pagingForm");

		request.setAttribute("paging", pager);
		request.setAttribute("searchMatch", searchMatch);

		rd.forward(request, response);
		
	}

}
