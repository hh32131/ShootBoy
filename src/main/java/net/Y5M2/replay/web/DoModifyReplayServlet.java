package net.Y5M2.replay.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
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

public class DoModifyReplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ReplayBiz replayBiz;

	public DoModifyReplayServlet() {
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
		String replyId = Param.getStringParam(request, "replyId");
		String replayContent = Param.getStringParam(request, "replayContent");

		//HttpSession session = request.getSession();
		//UserVO userVO = (UserVO) session.getAttribute(Session.USER_INFO);

		ReplayVO replays = new ReplayVO();
		//replays.setUserId(userVO.getUserId());
		replays.setReplayId(replyId);
		replays.setReplayContent(replayContent);
		
		PrintWriter out = response.getWriter();
		
		boolean isSuccess = replayBiz.replayModify(replays);
		if (isSuccess) {
			out.print("<script type='text/javascript'> ");
			out.print("     window.opener.location.reload(); ");
			out.print(" window.close() ");
			out.print("</script>");
			out.flush();
			out.close();
			
		} else {
			response.sendRedirect("/ShootBoy/modifyReply?errorCode=2");
		}
	}

}
