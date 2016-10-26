package net.Y5M2.team.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.Y5M2.article.vo.BoardVO;
import net.Y5M2.support.Param;
import net.Y5M2.team.biz.TeamBiz;
import net.Y5M2.team.biz.TeamBizImpl;
import net.Y5M2.team.vo.TeamBoardVO;

public class ViewTeamBoardModifyPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private TeamBiz teamBiz;
	
	public ViewTeamBoardModifyPageServlet() {
		super();
		teamBiz = new TeamBizImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		String teamBoardId = Param.getStringParam(request, "teamBoardId");
		
		TeamBoardVO teamBoard = teamBiz.getTeamBoardForModify(teamBoardId);
		
		String content = teamBoard.getTeamBoardContent();
		content = content.replaceAll("<br/>", "\n");
		teamBoard.setTeamBoardContent(content);
		
		request.setAttribute("teamBoard", teamBoard);
		
		
		String viewPath = "/WEB-INF/view/team/teamBoardModify.jsp";
		RequestDispatcher rd =request.getRequestDispatcher(viewPath);
		
		rd.forward(request, response);
	}

}
