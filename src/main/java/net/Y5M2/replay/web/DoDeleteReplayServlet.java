package net.Y5M2.replay.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.Y5M2.replay.biz.ReplayBiz;
import net.Y5M2.replay.biz.ReplayBizImpl;
import net.Y5M2.replay.vo.ReplayVO;
import net.Y5M2.support.Param;

public class DoDeleteReplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ReplayBiz replayBiz;
	public DoDeleteReplayServlet() {
		super();
		replayBiz = new ReplayBizImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String Referer = request.getHeader("referer");
		String replayId = Param.getStringParam(request, "replayId");
		String boardId = Param.getStringParam(request, "boardId");
		ReplayVO replayVO = new ReplayVO();
		
		replayVO.setBoardId(boardId);
		replayVO.setReplayId(replayId);
		
		boolean isSuccess = replayBiz.deleteOneReplay(replayVO);
		
		if( isSuccess ) {
			response.sendRedirect(Referer);
		}
		
	}

}
