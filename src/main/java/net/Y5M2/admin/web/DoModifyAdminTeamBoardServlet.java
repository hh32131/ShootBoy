package net.Y5M2.admin.web;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.Y5M2.support.MultipartHttpServletRequest;
import net.Y5M2.support.MultipartHttpServletRequest.MultipartFile;
import net.Y5M2.team.biz.TeamBiz;
import net.Y5M2.team.biz.TeamBizImpl;
import net.Y5M2.team.vo.TeamBoardVO;

public class DoModifyAdminTeamBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private TeamBiz teamBiz;

	public DoModifyAdminTeamBoardServlet() {
		super();
		teamBiz = new TeamBizImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		MultipartHttpServletRequest multipartRequest = new MultipartHttpServletRequest(request);

		String teamBoardId = multipartRequest.getParameter("teamBoardId");
		String teamBoardSubject = multipartRequest.getParameter("boardSubject");
		String content = multipartRequest.getParameter("boardContent");
		String fileDeleteBtn = multipartRequest.getParameter("fileDeleteBtn");
		String teamId = multipartRequest.getParameter("teamId");

		content = content.replaceAll("\n", "<br/>").replaceAll("\r", "");

		TeamBoardVO teamBoard = new TeamBoardVO();
		teamBoard.setTeamBoardId(teamBoardId);
		teamBoard.setTeamBoardSubject(teamBoardSubject);
		teamBoard.setTeamBoardContent(content);
		teamBoard.setTeamId(teamId);

		if (fileDeleteBtn != null && fileDeleteBtn.equals("delete")) {
			String fileName = teamBiz.getFileNameOfTeamBoardBy(teamBoardId);
			File file = new File("D:\\board\\uploadFile\\" + fileName);
			file.delete();

			teamBoard.setFileName("");
		}

		MultipartFile uploadFile = multipartRequest.getFile("file");
		if (uploadFile.getFileSize() > 0) {
			File uploadFileDirectory = new File("D:\\board\\uploadfiles\\");
			if (!uploadFileDirectory.exists()) {
				uploadFileDirectory.mkdirs();
			}

			uploadFile.write("D:\\board\\uploadfiles\\" + uploadFile.getFileName());
			String fileName = uploadFile.getFileName();
			teamBoard.setFileName(fileName);
		}
		
		PrintWriter out = response.getWriter();

		boolean isSuccess = teamBiz.modifyTeamBoard(teamBoard);
		if (isSuccess) {
			out.print(" <script type='text/javascript'>   ");
			out.print("  window.opener.location.reload();   ");
			out.print("  window.close();   ");
			out.print(" </script>  ");
			out.flush();
			out.close();
		} else {
			response.sendRedirect("/ShootBoy/detailTeamBoard?errorCode=1&&teamBoardId=" + teamBoardId);
		}
	}
}
