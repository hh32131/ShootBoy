package net.Y5M2.article.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import net.Y5M2.article.biz.BoardBiz;
import net.Y5M2.article.biz.BoardBizImpl;
import net.Y5M2.article.vo.BoardVO;
import net.Y5M2.support.MultipartHttpServletRequest;
import net.Y5M2.support.MultipartHttpServletRequest.MultipartFile;
import net.Y5M2.user.vo.UserVO;

public class DoWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BoardBiz boardBiz;
	
	public DoWriteServlet() {
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

		String boardSubject = multipartRequest.getParameter("boardSubject");
		String boardContent = multipartRequest.getParameter("boardContent");
		
		String fileName= "";
		MultipartFile uploadFile = multipartRequest.getFile("file");
		
		boardContent = boardContent.replaceAll("\n", "<br/>")
										.replaceAll("/r", "");
		UserVO userVO = new UserVO();
		BoardVO board = new BoardVO();
		board.setBoardSubject(boardSubject);
		board.setBoardContent(boardContent);
		board.setUserId(userVO.getUserId());
		board.setFileName(fileName);
		
		boolean isSuccess = boardBiz.writeBoard(board);
		
		response.sendRedirect("/ShootBoy/list");
	}

}
