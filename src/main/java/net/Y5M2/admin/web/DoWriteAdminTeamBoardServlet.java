package net.Y5M2.admin.web;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.Y5M2.constants.Session;
import net.Y5M2.support.MultipartHttpServletRequest;
import net.Y5M2.support.MultipartHttpServletRequest.MultipartFile;
import net.Y5M2.team.biz.TeamBiz;
import net.Y5M2.team.biz.TeamBizImpl;
import net.Y5M2.team.vo.TeamBoardVO;
import net.Y5M2.user.vo.UserVO;

public class DoWriteAdminTeamBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private TeamBiz teamBiz;
	public DoWriteAdminTeamBoardServlet() {
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
		
		String teamId = multipartRequest.getParameter("teamId");
		String teamBoardSubject = multipartRequest.getParameter("teamBoardSubject");
		String teamBoardContent = multipartRequest.getParameter("teamBoardContent");

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

		teamBoardContent = teamBoardContent.replaceAll("\n", "<br/>").replaceAll("\r", "");
		
		TeamBoardVO teamBoardVO = new TeamBoardVO();
		HttpSession session = request.getSession();
		UserVO userVO = (UserVO) session.getAttribute(Session.USER_INFO);
		
		teamBoardVO.setTeamBoardSubject(teamBoardSubject);
		teamBoardVO.setTeamBoardContent(teamBoardContent);
		teamBoardVO.setUserId(userVO.getUserId());
		teamBoardVO.setFileName(fileName);
		teamBoardVO.setTeamId(teamId);
		
		if ( teamBoardSubject.length() == 0 ) {
			response.sendRedirect("/ShootBoy/team/teamBoardWrite?errorCode=1");
			return;
		}
		
		if ( teamBoardContent.length() == 0 ) {
			response.sendRedirect("/ShootBoy/team/teamBoardWrite?errorCode=1");
			return;
		}
		
		PrintWriter out = response.getWriter();

		boolean isSuccess = teamBiz.addTeamBoard(teamBoardVO);
		if (isSuccess) {
			out.write(" <script type='text/javascript'> ");
			out.write(" window.opener.location.reload(); ");
			out.write(" window.close(); ");
			out.write(" </script> ");
			out.flush();
			out.close();
		} else {
			response.sendRedirect("/ShootBoy/teamBoard?errorCode=2");
		}
	
	}

}
