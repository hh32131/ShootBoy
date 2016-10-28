package net.Y5M2.admin.web.ajax;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.Y5M2.constants.PageSelector;
import net.Y5M2.support.Param;

public class DoCheckList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DoCheckList() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int memberValue = Param.getIntParam(request, "memberValue",10);
		int teamValue = Param.getIntParam(request, "teamValue",20);
		int teamArticleValue = Param.getIntParam(request, "teamArticleValue",10);
		int gameValue = Param.getIntParam(request, "gameValue",10);
		int articleValue = Param.getIntParam(request, "articleValue",10);
		
		
		PageSelector.MEMBER_PAGE_SELECTOR = memberValue;
		PageSelector.TAEM_PAGE_SELECTOR = teamValue;
		PageSelector.TEAMBOARD_PAGE_SELECTOR = teamArticleValue;
		PageSelector.GAME_PAGE_SELECTOR = gameValue;
		PageSelector.BOARD_PAGE_SELECTOR = articleValue;
	}
}
