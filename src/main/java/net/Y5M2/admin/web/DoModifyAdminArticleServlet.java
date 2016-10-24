package net.Y5M2.admin.web;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.Y5M2.article.biz.BoardBiz;
import net.Y5M2.article.biz.BoardBizImpl;
import net.Y5M2.article.vo.BoardVO;
import net.Y5M2.support.MultipartHttpServletRequest;
import net.Y5M2.support.MultipartHttpServletRequest.MultipartFile;

public class DoModifyAdminArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BoardBiz boardBiz;

	public DoModifyAdminArticleServlet() {
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
		String categoryId = multipartRequest.getParameter("categoryId");

		content = content.replaceAll("\n", "<br/>").replaceAll("\r", "");

		BoardVO board = new BoardVO();
		board.setBoardId(boardId);
		board.setBoardSubject(subject);
		board.setBoardContent(content);
		board.setCategoryId(categoryId);
		
		if (fileDeleteBtn != null && fileDeleteBtn.equals("delete")) {
			String fileName = boardBiz.getFileNmaeOfArticleBy(boardId);
			File file = new File("D:\\board\\uploadFile\\" + fileName);
			file.delete();

			board.setFileName("");
		}

		MultipartFile uploadFile = multipartRequest.getFile("file");
		if (uploadFile.getFileSize() > 0) {
			File uploadFileDirectory = new File("D:\\board\\uploadfiles\\");
			if (!uploadFileDirectory.exists()) {
				uploadFileDirectory.mkdirs();
			}

			uploadFile.write("D:\\board\\uploadfiles\\" + uploadFile.getFileName());
			String fileName = uploadFile.getFileName();
			board.setFileName(fileName);
		}

		PrintWriter out = response.getWriter();
		
		boolean isSuccess = boardBiz.modifyBoard(board);
		if (isSuccess) {
			out.print(" <script type='text/javascript'>   ");
			out.print("  window.opener.location.reload();   ");
			out.print("  window.close();   ");
			out.print(" </script>  ");
			out.flush();
			out.close();
		} else {
			response.sendRedirect("/ShootBoy/adminArticleModify?errorCode=1");
		}
	}

}
