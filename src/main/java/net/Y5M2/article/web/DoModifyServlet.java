package net.Y5M2.article.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.Y5M2.article.biz.BoardBiz;
import net.Y5M2.article.biz.BoardBizImpl;
import net.Y5M2.article.vo.BoardVO;
import net.Y5M2.support.MultipartHttpServletRequest;

public class DoModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BoardBiz boardBiz;
	
	public DoModifyServlet() {
		super();
		boardBiz = new BoardBizImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		MultipartHttpServletRequest multipartRequest = new MultipartHttpServletRequest(request);
		
		String boardId = multipartRequest.getParameter("boardId");
		String subject = multipartRequest.getParameter("boardSubject");
		String content = multipartRequest.getParameter("boardContent");
		
		content = content.replaceAll("\n", "<br/>").replaceAll("\r", "");
		
		BoardVO board = new BoardVO();
		board.setBoardId(boardId);
		board.setBoardSubject(subject);
		board.setBoardContent(content);
		
		boolean isSuccess = boardBiz.modifyBoard(board);
		if ( isSuccess ) {
			response.sendRedirect("/ShootBoy/board/detail?boardId=" + boardId);
		}
	}
}
