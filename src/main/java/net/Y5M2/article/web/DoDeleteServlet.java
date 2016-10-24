package net.Y5M2.article.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.Y5M2.article.biz.BoardBiz;
import net.Y5M2.article.biz.BoardBizImpl;
import net.Y5M2.article.vo.BoardVO;
import net.Y5M2.support.Param;

public class DoDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BoardBiz boardBiz;
	
	public DoDeleteServlet() {
		super();
		boardBiz = new BoardBizImpl();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String boardId = Param.getStringParam(request, "boardId");
		String categoryId = Param.getStringParam(request, "categoryId");
		
		BoardVO board = new BoardVO();
		board.setCategoryId(categoryId);
		
		boolean isSuccess = boardBiz.deleteBoard(boardId);
		if ( isSuccess ) {
			response.sendRedirect("/ShootBoy/list?categoryId="+categoryId);
		}
		else {
			response.sendRedirect("/ShootBoy/board/detail?boardId="+boardId);
		}
	}
}
