package net.Y5M2.team.web;

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
import net.Y5M2.team.vo.TeamVO;
import net.Y5M2.user.vo.UserVO;

public class DoModifyTeamInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TeamBiz teamBiz;
	
	
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

		MultipartHttpServletRequest multiparRequest = new MultipartHttpServletRequest(request);
		
		String teamId = multiparRequest.getParameter("teamId");
		String teamName = multiparRequest.getParameter("teamName");
		String teamCountParam = multiparRequest.getParameter("teamCount");
		int teamCount = Integer.parseInt(teamCountParam);
		String leafCategory = multiparRequest.getParameter("leafCategory");
		String teamInfo = multiparRequest.getParameter("teamInfo");
		String fileDeleteBtn = multiparRequest.getParameter("fileDeleteBtn");
		
		String email = multiparRequest.getParameter("email");
		
		teamInfo = teamInfo.replaceAll("\n", "<br/>").replaceAll("\r", "");
		
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
		
		UserVO userInfo = new UserVO();
		userInfo.setEmail(email);
		
		PrintWriter out = response.getWriter();
		boolean isSuccess = teamBiz.updateTeamInfo(teamVO, request, userInfo);
		if(isSuccess){
			
			out.print(" <script type='text/javascript'>   ");
			out.print("  window.opener.location.reload();   ");
			out.print("  window.close();   ");
			out.print(" </script>  ");
			out.flush();
			out.close();
		}
		else{
			response.sendRedirect("/ShootBoy/teamModify?errorCode=1");
		}
		
	}

}
