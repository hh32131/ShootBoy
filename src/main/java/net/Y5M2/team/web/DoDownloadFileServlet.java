package net.Y5M2.team.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.Y5M2.support.DownloadUtil;
import net.Y5M2.support.Param;
import net.Y5M2.team.biz.TeamBiz;
import net.Y5M2.team.biz.TeamBizImpl;

public class DoDownloadFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TeamBiz teamBiz;
       
    public DoDownloadFileServlet() {
        super();
        teamBiz= new TeamBizImpl();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String teamBoardId = Param.getStringParam(request, "teamBoards");
		String fileName = teamBiz.getFileNameOfTeamBoardBy(teamBoardId);
		
		if (fileName != null && fileName.length() > 0) {
			DownloadUtil downloadUtil = DownloadUtil.getInstance("D:\\board\\uploadfiles");
			downloadUtil.download(request, response, fileName, fileName);
		}
	}

}
