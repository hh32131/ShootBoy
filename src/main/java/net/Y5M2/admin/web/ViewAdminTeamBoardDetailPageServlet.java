package net.Y5M2.admin.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.Y5M2.replay.biz.ReplayBiz;
import net.Y5M2.replay.biz.ReplayBizImpl;
import net.Y5M2.replay.vo.ReplayVO;
import net.Y5M2.support.Param;
import net.Y5M2.team.biz.TeamBiz;
import net.Y5M2.team.biz.TeamBizImpl;
import net.Y5M2.team.vo.TeamBoardVO;

public class ViewAdminTeamBoardDetailPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private TeamBiz teamBiz;
	private ReplayBiz replayBiz;
	
	public ViewAdminTeamBoardDetailPageServlet() {
		super();
		teamBiz = new TeamBizImpl();
		replayBiz = new ReplayBizImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String boardId = Param.getStringParam(request, "teamBoardId");
		TeamBoardVO teamBoard = teamBiz.getTeamBoardAt(boardId);
		List<ReplayVO> replays = replayBiz.getListReplays(boardId);

		String viewPath = "/WEB-INF/view/admin/adminTeamBoardDetail.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(viewPath);
		request.setAttribute("teamBoards", teamBoard);
		request.setAttribute("replays", replays);
		rd.forward(request, response);

	}

}
