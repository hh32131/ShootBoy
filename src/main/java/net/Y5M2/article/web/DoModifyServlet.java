package net.Y5M2.article.web;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.Y5M2.article.biz.BoardBiz;
import net.Y5M2.article.biz.BoardBizImpl;
import net.Y5M2.article.vo.BoardVO;
import net.Y5M2.support.MultipartHttpServletRequest;
import net.Y5M2.support.MultipartHttpServletRequest.MultipartFile;

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
		String fileDeleteBtn = multipartRequest.getParameter("fileDeleteBtn");
		
		content = content.replaceAll("\n", "<br/>")
							.replaceAll("\r", "");
		
		BoardVO board = new BoardVO();
		board.setBoardId(boardId);
		board.setBoardSubject(subject);
		board.setBoardContent(content);
		
		if ( fileDeleteBtn != null && fileDeleteBtn.equals("delete") ) {
			String fileName = boardBiz.getFileNmaeOfArticleBy(boardId);
			File file = new File("D:\\board\\uploadFile\\" + fileName);
			file.delete();
			
			board.setFileName("");
		}
		
		MultipartFile uploadFile = multipartRequest.getFile("file");
		if ( uploadFile.getFileSize() > 0 ) {
			File uploadFileDirectory = new File("D:\\board\\uploadfiles\\");
			if (!uploadFileDirectory.exists()) {
				uploadFileDirectory.mkdirs();
			}

			uploadFile.write("D:\\board\\uploadfiles\\" + uploadFile.getFileName());
			String fileName = uploadFile.getFileName();
			board.setFileName(fileName);
		}
		
		boolean isSuccess = boardBiz.modifyBoard(board);
		if ( isSuccess ) {
			response.sendRedirect("/ShootBoy/board/detail?boardId=" + boardId);
		}
		else{
			response.sendRedirect("/ShootBoy/board/detail?errorCode=1&&boardId=" + boardId);
		}
	}
}
