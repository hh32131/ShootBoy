package net.Y5M2.article.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.Y5M2.article.biz.BoardBiz;
import net.Y5M2.article.biz.BoardBizImpl;
import net.Y5M2.article.vo.BoardVO;
import net.Y5M2.support.Param;

public class ViewDetailPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BoardBiz boardBiz;
	
	public ViewDetailPageServlet() {
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
		boardBiz.hitCountUpdate(boardId);
		BoardVO board = boardBiz.getBoardAt(boardId);

		String viewPath = "/WEB-INF/view/board/detail.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(viewPath);
		request.setAttribute("board", board);
		rd.forward(request, response);
		
	}

}
