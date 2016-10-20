package net.Y5M2.admin.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.Y5M2.constants.Session;
import net.Y5M2.support.Param;
import net.Y5M2.support.pager.ClassicPageExplorer;
import net.Y5M2.support.pager.PageExplorer;
import net.Y5M2.team.biz.TeamBiz;
import net.Y5M2.team.biz.TeamBizImpl;
import net.Y5M2.team.vo.SearchTeamVO;
import net.Y5M2.team.vo.TeamListVO;

public class ViewAdminTeamPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TeamBiz teamBiz;

	public ViewAdminTeamPageServlet() {
		super();
		teamBiz = new TeamBizImpl();
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
		String teamId = Param.getStringParam(request, "teamCode");
		
		SearchTeamVO searchTeam = null;
		
		if (pageNo == -1) {
			searchTeam = (SearchTeamVO) session.getAttribute(Session.SEARCH_TEAM_INFO);
			if (searchTeam == null) {
				searchTeam = new SearchTeamVO();
				searchTeam.setPageNo(0);
			}
		} else {
			searchTeam = new SearchTeamVO();
			searchTeam.setPageNo(pageNo);
			searchTeam.setSearchType(searchType);
			searchTeam.setSearchKeyword(searchKeyword);
		}
		
		session.setAttribute(Session.SEARCH_TEAM_INFO, searchTeam);
		TeamListVO teams = teamBiz.getAllTeam(searchTeam);
		int count = teamBiz.getCountOfTeam(teamId);

		String viewPath = "/WEB-INF/view/admin/adminTeam.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(viewPath);
		request.setAttribute("team", teams.getTeams());
		request.setAttribute("pager", teams.getPager());

		PageExplorer pageExplorer = new ClassicPageExplorer(teams.getPager());
		String pager = pageExplorer.getPagingList("pageNo", "[@]", "<<", ">>", "pagingForm");

		request.setAttribute("paging", pager);
		request.setAttribute("searchTeam", searchTeam);
		request.setAttribute("count", count);

		rd.forward(request, response);
	}

}
