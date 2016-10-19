package net.Y5M2.team.web;

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
import net.Y5M2.team.vo.TeamVO;
import net.Y5M2.user.vo.UserVO;

public class DoCreateTeamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TeamBiz teamBiz;

	public DoCreateTeamServlet() {
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

		String teamName = multipartRequest.getParameter("teamName");
		String teamInfo = multipartRequest.getParameter("teamInfo");
		String teamCountParam = multipartRequest.getParameter("teamCount");
		String leafLocation = multipartRequest.getParameter("leafLocation");
		
		String teamPhoto = "";
		MultipartFile uploadFile = multipartRequest.getFile("file");
		if ( uploadFile.getFileSize() > 0 ) {
			File uploadFileDirectory = new File("D:\\board\\uploadfiles\\");
			
			if ( !uploadFileDirectory.exists() ) {
				uploadFileDirectory.mkdirs();
			}
			
			uploadFile.write("D:\\board\\uploadfiles\\"+uploadFile.getFileName());
			teamPhoto = uploadFile.getFileName();
		}
		
		
		if (teamName == null || teamName.length() == 0) {
			response.sendRedirect("/ShootBoy/createTeam?errorCode=2");
			return;
		}
		if (teamInfo == null || teamInfo.length() == 0) {
			response.sendRedirect("/ShootBoy/createTeam?errorCode=2");
			return;
		}
		if (teamCountParam == null || teamCountParam.length() == 0) {
			response.sendRedirect("/ShootBoy/createTeam?errorCode=2");
			return;
		}

		int teamCount = Integer.parseInt(teamCountParam);

		teamInfo = teamInfo.replaceAll("\n", "<br/>").replaceAll("/r", "");
		/*HttpSession session = request.getSession();*/
		/*UserVO userVO = (UserVO) session.getAttribute(Session.USER_INFO);*/
		
		
		TeamVO team = new TeamVO();
		team.setTeamName(teamName);
		team.setTeamCount(teamCount);
		team.setTeamInfo(teamInfo);
		team.setTeamPhoto(teamPhoto);
		team.setLocationId(leafLocation);
		HttpSession session = request.getSession();
		UserVO userInfo = (UserVO) session.getAttribute(Session.USER_INFO);

		boolean isSuccess = teamBiz.addTeam(team, userInfo, request);
		PrintWriter out = response.getWriter();
		if (isSuccess) {
			out.write("<script type='text/javascript'>  ");
			out.write(" window.opener.location.reload();");
			out.write(" window.close(); </script>");
			out.flush();
			out.close();
		}
		else {
			response.sendRedirect("/ShootBoy/createTeam?errorCode=1");

		}
	}
}
