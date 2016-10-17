package net.Y5M2.replay.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.Y5M2.replay.biz.ReplayBiz;
import net.Y5M2.replay.biz.ReplayBizImpl;
import net.Y5M2.replay.vo.ReplayVO;
import net.Y5M2.support.Param;

public class ViewModifyReply extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReplayBiz replayBiz;

	public ViewModifyReply() {
		super();
		replayBiz = new ReplayBizImpl();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String replyId = Param.getStringParam(request, "replyId");
		String viewPath="/WEB-INF/view/board/replyModify.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(viewPath);
		ReplayVO replayVO = replayBiz.getReplyAt(replyId);
		request.setAttribute("replayVO", replayVO);
		rd.forward(request, response);
	}

}
