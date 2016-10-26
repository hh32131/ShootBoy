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
import net.Y5M2.support.Param;
import net.Y5M2.support.pager.ClassicPageExplorer;
import net.Y5M2.support.pager.PageExplorer;
import net.Y5M2.team.biz.TeamBiz;
import net.Y5M2.team.biz.TeamBizImpl;
import net.Y5M2.team.vo.SearchTeamVO;
import net.Y5M2.team.vo.TeamListVO;
import net.Y5M2.team.vo.TeamVO;

public class ViewTeamPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private TeamBiz teamBiz;
	public ViewTeamPageServlet() {
		super();
		teamBiz = new TeamBizImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		HttpSession session = request.getSession();
		int pageNo = Param.getIntParam(request, "pageNo", -1);
		int searchType = Param.getIntParam(request, "searchType");
		String searchKeyword = Param.getStringParam(request, "searchKeyword");
		
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

		request.setAttribute("team", teams.getTeams());
		request.setAttribute("pager", teams.getPager());

		PageExplorer pageExplorer = new ClassicPageExplorer(teams.getPager());
		String pager = pageExplorer.getPagingList("pageNo", "[@]", "<<", ">>", "searchForm");
		
		request.setAttribute("paging", pager);
		request.setAttribute("searchTeam", searchTeam);
		
		String viewPath = "/WEB-INF/view/team/team.jsp";
		
		RequestDispatcher rd = request.getRequestDispatcher(viewPath);
		rd.forward(request, response);

	}
}
