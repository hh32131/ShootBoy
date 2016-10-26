package net.Y5M2.admin.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.Y5M2.admin.biz.AdminBiz;
import net.Y5M2.admin.biz.AdminBizImpl;
import net.Y5M2.constants.Session;
import net.Y5M2.support.Param;
import net.Y5M2.support.pager.ClassicPageExplorer;
import net.Y5M2.support.pager.PageExplorer;
import net.Y5M2.team.biz.TeamBiz;
import net.Y5M2.team.biz.TeamBizImpl;
import net.Y5M2.team.vo.SearchTeamVO;
import net.Y5M2.team.vo.TeamBoardListVO;
import net.Y5M2.team.vo.TeamBoardVO;

public class ViewAdminTeamBoardPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private TeamBiz teamBiz;
	private AdminBiz adminBiz;
	
	public ViewAdminTeamBoardPageServlet() {
		super();
		teamBiz = new TeamBizImpl();
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
		String teamId = Param.getStringParam(request, "teamId");

        SearchTeamVO searchTeamBoard = null;

		if (pageNo == -1) {
			searchTeamBoard = (SearchTeamVO) session.getAttribute(Session.SEARCH_TEAM_INFO);
			if (searchTeamBoard == null) {
				searchTeamBoard = new SearchTeamVO();
				searchTeamBoard.setPageNo(0);
			}
		} else {
			searchTeamBoard = new SearchTeamVO();
			searchTeamBoard.setPageNo(pageNo);
			searchTeamBoard.setSearchType(searchType);
			searchTeamBoard.setSearchKeyword(searchKeyword);
		}

		TeamBoardVO teamBoardVO = new TeamBoardVO();
		teamBoardVO.setTeamId(teamId);
		session.setAttribute(Session.SEARCH_TEAM_INFO, searchTeamBoard);
		TeamBoardListVO teamBoards = adminBiz.getAllTeamBoards(searchTeamBoard, teamBoardVO);
		
		String viewPath = "/WEB-INF/view/admin/adminTeamBoard.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(viewPath);
		request.setAttribute("teamBoards", teamBoards.getTeamBoards());
		request.setAttribute("pager", teamBoards.getPager());

		PageExplorer pageExplorer = new ClassicPageExplorer(teamBoards.getPager());
		String pager = pageExplorer.getPagingList("pageNo", "[@]", "<<", ">>", "pagingForm");

		request.setAttribute("team", teamId);
		request.setAttribute("paging", pager);
		request.setAttribute("searchTeam", searchTeamBoard);
		rd.forward(request, response);

	}

}
