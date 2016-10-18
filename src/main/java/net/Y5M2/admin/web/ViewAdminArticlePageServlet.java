package net.Y5M2.admin.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.Y5M2.article.biz.BoardBiz;
import net.Y5M2.article.biz.BoardBizImpl;
import net.Y5M2.article.vo.BoardListVO;
import net.Y5M2.article.vo.SearchBoardVO;
import net.Y5M2.constants.Session;
import net.Y5M2.support.Param;
import net.Y5M2.support.pager.ClassicPageExplorer;
import net.Y5M2.support.pager.PageExplorer;

public class ViewAdminArticlePageServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	private BoardBiz boardBiz;
	
	public ViewAdminArticlePageServlet() {
		super();
		boardBiz = new BoardBizImpl();
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

		SearchBoardVO searchBoard = null;

		if (pageNo == -1) {
			searchBoard = (SearchBoardVO) session.getAttribute(Session.SEARCH_BOARD_INFO);
			if (searchBoard == null) {
				searchBoard = new SearchBoardVO();
				searchBoard.setPageNo(0);
			}
		} else {
			searchBoard = new SearchBoardVO();
			searchBoard.setPageNo(pageNo);
			searchBoard.setSearchType(searchType);
			searchBoard.setSearchKeyword(searchKeyword);
		}

		session.setAttribute(Session.SEARCH_BOARD_INFO, searchBoard);
		BoardListVO boards = boardBiz.getAllBoards(searchBoard);

		String viewPath = "/WEB-INF/view/adminArticle.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(viewPath);
		request.setAttribute("boards", boards.getBoards());
		request.setAttribute("pager", boards.getPager());

		PageExplorer pageExplorer = new ClassicPageExplorer(boards.getPager());
		String pager = pageExplorer.getPagingList("pageNo", "[@]", "<<", ">>", "searchForm");

		request.setAttribute("paging", pager);
		request.setAttribute("searchBoard", searchBoard);
		rd.forward(request, response);

	}

}
