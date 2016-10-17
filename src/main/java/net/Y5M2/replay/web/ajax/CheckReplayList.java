package net.Y5M2.replay.web.ajax;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.Y5M2.constants.Session;
import net.Y5M2.replay.biz.ReplayBiz;
import net.Y5M2.replay.biz.ReplayBizImpl;
import net.Y5M2.replay.vo.ReplayVO;
import net.Y5M2.support.Param;
import net.Y5M2.user.vo.UserVO;

public class CheckReplayList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ReplayBiz replayBiz;
	public CheckReplayList() {
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
		String replayContent = Param.getStringParam(request, "replayContent");
		String boardId = Param.getStringParam(request, "boardId");
		HttpSession session = request.getSession();
		UserVO userVO = (UserVO) session.getAttribute(Session.USER_INFO);
		
		ReplayVO replayVO = new ReplayVO();
		replayVO.setUserId(userVO.getUserId());
		replayVO.setReplayContent(replayContent);
		replayVO.setBoardId(boardId);
		
		boolean isSuccess = replayBiz.writeReplay(replayVO);
		
		if ( isSuccess ) {
			response.sendRedirect(Referer);
		}
	}

}
