package net.Y5M2.admin.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.Y5M2.support.Param;
import net.Y5M2.team.biz.TeamBiz;
import net.Y5M2.team.biz.TeamBizImpl;
import net.Y5M2.team.vo.TeamBoardVO;

public class ViewAdminTeamBoardModifyPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private TeamBiz teamBiz;
	
	public ViewAdminTeamBoardModifyPageServlet() {
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
		TeamBoardVO teamBoardVO = teamBiz.getTeamBoardForModify(teamBoardId);
		
		String content = teamBoardVO.getTeamBoardContent();
		content = content.replaceAll("<br/>", "\n");
		teamBoardVO.setTeamBoardContent(content);
		
		String viewPath = "/WEB-INF/view/admin/adminTeamBoardModify.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(viewPath);
		request.setAttribute("teamBoardVO", teamBoardVO);
		rd.forward(request, response);
	}

}
