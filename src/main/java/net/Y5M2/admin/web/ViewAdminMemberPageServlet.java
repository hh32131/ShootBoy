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
import net.Y5M2.user.biz.UserBiz;
import net.Y5M2.user.biz.UserBizImpl;
import net.Y5M2.user.vo.SearchUserVO;
import net.Y5M2.user.vo.UserListVO;

public class ViewAdminMemberPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserBiz userBiz;
	
	public ViewAdminMemberPageServlet() {
		super();
		userBiz = new UserBizImpl();
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

		SearchUserVO searchUser = null;

		if (pageNo == -1) {
			searchUser = (SearchUserVO) session.getAttribute(Session.SEARCH_USER_INFO);
			if (searchUser == null) {
				searchUser = new SearchUserVO();
				searchUser.setPageNo(0);
			}
		} else {
			searchUser = new SearchUserVO();
			searchUser.setPageNo(pageNo);
			searchUser.setSearchType(searchType);
			searchUser.setSearchKeyword(searchKeyword);
		}

		session.setAttribute(Session.SEARCH_USER_INFO, searchUser);
		UserListVO users = userBiz.getAllUsers(searchUser);

		String viewPath = "/WEB-INF/view/adminMember.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(viewPath);
		request.setAttribute("users", users.getUsers());
		request.setAttribute("pager", users.getPager());

		PageExplorer pageExplorer = new ClassicPageExplorer(users.getPager());
		String pager = pageExplorer.getPagingList("pageNo", "[@]", "<<", ">>", "searchForm");

		request.setAttribute("paging", pager);
		request.setAttribute("searchUser", searchUser);
		rd.forward(request, response);
	}

}
