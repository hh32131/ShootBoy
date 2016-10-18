package net.Y5M2.team.web;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

<<<<<<< HEAD

public class DoModifyTeamInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
=======
import net.Y5M2.support.MultipartHttpServletRequest;
import net.Y5M2.support.MultipartHttpServletRequest.MultipartFile;
import net.Y5M2.team.biz.TeamBiz;
import net.Y5M2.team.biz.TeamBizImpl;
import net.Y5M2.team.vo.TeamVO;

public class DoModifyTeamInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TeamBiz teamBiz;
>>>>>>> f755565746d1b618537d1b98fce724e3d2dfaed5
	
	
	public DoModifyTeamInfo() {
		super();
		teamBiz = new TeamBizImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
<<<<<<< HEAD
		

=======
		MultipartHttpServletRequest multiparRequest = new MultipartHttpServletRequest(request);
		
		String teamId = multiparRequest.getParameter("teamId");
		String teamName = multiparRequest.getParameter("teamName");
		String teamCountParam = multiparRequest.getParameter("teamCount");
		int teamCount = Integer.parseInt(teamCountParam);
		String leafCategory = multiparRequest.getParameter("leafCategory");
		String teamInfo = multiparRequest.getParameter("teamInfo");
		String fileDeleteBtn = multiparRequest.getParameter("fileDeleteBtn");
		
		teamInfo = teamInfo.replaceAll("\n", "<br/>")
							.replaceAll("\r", "");
		
		TeamVO teamVO = new TeamVO();
		teamVO.setTeamId(teamId);
		teamVO.setTeamName(teamName);
		teamVO.setTeamCount(teamCount);
		teamVO.setLocationId(leafCategory);
		teamVO.setTeamInfo(teamInfo);
		
		if(fileDeleteBtn != null && fileDeleteBtn.equals("delete")){
			String fileName = teamBiz.getFileNameOfTeam(teamId);
			File file = new File("D:\\board\\uploadfiles\\" + fileName);
			file.delete();
			
			teamVO.setTeamPhoto("");
		}
		
		MultipartFile uploadFile = multiparRequest.getFile("file");
		if(uploadFile.getFileSize()>0){
			File uploadFileDirectory = new File("D:\\board\\uploadfiles\\");
			if(!uploadFileDirectory.exists()){
				uploadFileDirectory.mkdirs();
			}
			
			uploadFile.write("D:\\board\\uploadfiles\\"+uploadFile.getFileName());
			String fileName = uploadFile.getFileName();
			teamVO.setTeamPhoto(fileName);
		}
		
		boolean isSuccess = teamBiz.updateTeamInfo(teamVO);
		if(isSuccess){
			
		}
		else{
			
		}
		
>>>>>>> f755565746d1b618537d1b98fce724e3d2dfaed5
		
	}

}
