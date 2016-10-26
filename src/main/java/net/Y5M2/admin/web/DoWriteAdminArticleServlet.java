package net.Y5M2.admin.web;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import net.Y5M2.article.biz.BoardBiz;
import net.Y5M2.article.biz.BoardBizImpl;
import net.Y5M2.article.vo.BoardVO;
import net.Y5M2.constants.Session;
import net.Y5M2.support.MultipartHttpServletRequest;
import net.Y5M2.support.MultipartHttpServletRequest.MultipartFile;
import net.Y5M2.user.vo.UserVO;

public class DoWriteAdminArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BoardBiz boardBiz;

	public DoWriteAdminArticleServlet() {
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
		
		String categoryId = multipartRequest.getParameter("categoryId");
		String boardSubject = multipartRequest.getParameter("boardSubject");
		String boardContent = multipartRequest.getParameter("boardContent");

		String fileName = "";
		MultipartFile uploadFile = multipartRequest.getFile("file");
		
		if ( uploadFile.getFileSize() > 0 ) {
			File uploadFileDirectory = new File("D:\\board\\uploadfiles\\");
			
			if ( !uploadFileDirectory.exists() ) {
				uploadFileDirectory.mkdirs();
			}
			
			uploadFile.write("D:\\board\\uploadfiles\\"+uploadFile.getFileName());
			fileName = uploadFile.getFileName();
		}

		boardContent = boardContent.replaceAll("\n", "<br/>").replaceAll("\r", "");
		
		BoardVO board = new BoardVO();
		HttpSession session = request.getSession();
		UserVO userVO = (UserVO) session.getAttribute(Session.USER_INFO);
		
		board.setBoardSubject(boardSubject);
		board.setBoardContent(boardContent);
		board.setUserId(userVO.getUserId());
		board.setFileName(fileName);
		board.setCategoryId(categoryId);
		
		if ( boardSubject.length() == 0 ) {
			response.sendRedirect("/ShootBoy/board/write?errorCode=1");
			return;
		}
		
		if ( boardContent.length() == 0 ) {
			response.sendRedirect("/ShootBoy/board/write?errorCode=1");
			return;
		}
		PrintWriter out = response.getWriter();
		
		boolean isSuccess = boardBiz.writeBoard(board);
		if (isSuccess) {
			out.write(" <script type='text/javascript'> ");
			out.write(" window.opener.location.reload(); ");
			out.write(" window.close(); ");
			out.write(" </script> ");
			out.flush();
			out.close();
		} else {
			response.sendRedirect("/ShootBoy/list?errorCode=2");
		}
	}
}