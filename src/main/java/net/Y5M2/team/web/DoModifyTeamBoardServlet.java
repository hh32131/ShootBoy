package net.Y5M2.team.web;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.Y5M2.support.MultipartHttpServletRequest;
import net.Y5M2.support.MultipartHttpServletRequest.MultipartFile;
import net.Y5M2.team.biz.TeamBiz;
import net.Y5M2.team.biz.TeamBizImpl;
import net.Y5M2.team.vo.TeamBoardVO;

public class DoModifyTeamBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private TeamBiz teamBiz;

	public DoModifyTeamBoardServlet() {
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
		String teamBoardSubject = multipartRequest.getParameter("teamBoardSubject");
		String teamBoardContent = multipartRequest.getParameter("teamBoardContent");
		String fileDeleteBtn = multipartRequest.getParameter("fileDeleteBtn");

		teamBoardContent = teamBoardContent.replaceAll("\n", "<br/>").replaceAll("\r", "");

		TeamBoardVO teamBoard = new TeamBoardVO();
		teamBoard.setTeamBoardId(teamBoardId);
		teamBoard.setTeamBoardSubject(teamBoardSubject);
		teamBoard.setTeamBoardContent(teamBoardContent);

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

		boolean isSuccess = teamBiz.modifyTeamBoard(teamBoard);
		if (isSuccess) {
			response.sendRedirect("/ShootBoy/detailTeamBoard?teamBoardId=" + teamBoardId);
		} else {
			response.sendRedirect("/ShootBoy/detailTeamBoard?errorCode=1&&teamBoardId=" + teamBoardId);
		}
	}

}
