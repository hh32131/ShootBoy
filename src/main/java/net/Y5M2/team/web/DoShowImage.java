package net.Y5M2.team.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.Y5M2.support.DownloadUtil;
import net.Y5M2.support.Param;
import net.Y5M2.team.biz.TeamBiz;
import net.Y5M2.team.biz.TeamBizImpl;
import net.Y5M2.team.vo.TeamVO;


public class DoShowImage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TeamBiz teamBiz;
	
	
	public DoShowImage() {
		super();
		teamBiz = new TeamBizImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String teamId = Param.getStringParam(request, "teamId");
		String teamPhoto = teamBiz.getFileNmaeOfTeamBy(teamId);
			
			DownloadUtil downloadUtil = DownloadUtil.getInstance("D:\\board\\uploadfiles");
			downloadUtil.download(request, response, teamPhoto , teamPhoto);
		
	}

}
