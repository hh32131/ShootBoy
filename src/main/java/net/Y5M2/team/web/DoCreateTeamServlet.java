package net.Y5M2.team.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.Y5M2.article.vo.BoardVO;
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

		String teamPhoto = "";
		MultipartFile uploadFile = multipartRequest.getFile("teamPhoto");

		teamInfo = teamInfo.replaceAll("\n", "<br/>").replaceAll("/r", "");
		TeamVO team = new TeamVO();
		team.setTeamName(teamName);
		team.setTeamCount(teamCount);
		team.setTeamInfo(teamInfo);
		team.setTeamPhoto(teamPhoto);

		boolean isSuccess = teamBiz.addTeam(team);
		PrintWriter out = response.getWriter();
		if (isSuccess) {
			out.write("<script type='text/javascript'> window.close() </script>");
			out.flush();
			out.close();
		}
		else {
			response.sendRedirect("/ShootBoy/createTeam?errorCode=1");

		}
	}
}
