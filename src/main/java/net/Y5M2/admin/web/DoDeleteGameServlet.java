package net.Y5M2.admin.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.Y5M2.admin.biz.AdminBiz;
import net.Y5M2.admin.biz.AdminBizImpl;
import net.Y5M2.constants.Session;
import net.Y5M2.support.Param;
import net.Y5M2.user.vo.UserVO;

public class DoDeleteGameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private AdminBiz adminBiz;
	
	public DoDeleteGameServlet() {
		super();
		adminBiz = new AdminBizImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String[] checkbox = request.getParameterValues("select-check");

		PrintWriter out = response.getWriter();

		if (checkbox == null || checkbox.length == 0) {
			out.print("다시선택하세요. ");
			return;
		} else {
			for (int i = 0; i < checkbox.length; i++) {
				adminBiz.deleteAdminTeamMatchs(checkbox[i]);
			}
			out.print("삭제했습니다.");
		}
		out.flush();
		out.close();

	}

}
