package net.Y5M2.admin.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.Y5M2.admin.biz.AdminBiz;
import net.Y5M2.admin.biz.AdminBizImpl;
import net.Y5M2.constants.Session;
import net.Y5M2.match.vo.MatchListVO;
import net.Y5M2.match.vo.MatchVO;
import net.Y5M2.match.vo.SearchMatchVO;
import net.Y5M2.support.Param;
import net.Y5M2.support.pager.ClassicPageExplorer;
import net.Y5M2.support.pager.PageExplorer;

public class ViewAdminGamePageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private AdminBiz adminBiz;

	public ViewAdminGamePageServlet() {
		adminBiz = new AdminBizImpl();
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
		String matchId = Param.getStringParam(request, "matchId");

		SearchMatchVO searchTeamMatch = null;

		if (pageNo == -1) {
			searchTeamMatch = (SearchMatchVO) session.getAttribute(Session.SEARCH_MATCH_INFO);
			if (searchTeamMatch == null) {
				searchTeamMatch = new SearchMatchVO();
				searchTeamMatch.setPageNo(0);
			}
		} else {
			searchTeamMatch = new SearchMatchVO();
			searchTeamMatch.setPageNo(pageNo);
			searchTeamMatch.setSearchType(searchType);
			searchTeamMatch.setSearchKeyword(searchKeyword);
		}

		MatchVO matchVO = new MatchVO();
		matchVO.setMatchId(matchId);
		session.setAttribute(Session.SEARCH_MATCH_INFO, searchTeamMatch);
		MatchListVO matchs = adminBiz.getAllTeamMatchs(searchTeamMatch);
		
		int count = adminBiz.getCountOfTeamMatchs();
		
		String viewPath = "/WEB-INF/view/admin/adminGame.jsp";
		/*List<MatchVO> matchVO = adminBiz.getAllMatchTeams();*/
		RequestDispatcher rd = request.getRequestDispatcher(viewPath);
		
		request.setAttribute("matchs", matchs.getMatchs());
		request.setAttribute("pager", matchs.getPager());
		request.setAttribute("count", count);

		PageExplorer pageExplorer = new ClassicPageExplorer(matchs.getPager());
		String paging = pageExplorer.getPagingList("pageNo", "[@]", "<<", ">>", "pagingForm");
		
		request.setAttribute("paging", paging);
		request.setAttribute("searchTeamMatch", searchTeamMatch);
		request.setAttribute("matchId", matchId);
		rd.forward(request, response);
	}

}
