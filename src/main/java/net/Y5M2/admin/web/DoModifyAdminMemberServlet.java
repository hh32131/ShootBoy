package net.Y5M2.admin.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.Y5M2.admin.biz.AdminBiz;
import net.Y5M2.admin.biz.AdminBizImpl;
import net.Y5M2.support.Param;
import net.Y5M2.user.vo.UserVO;

public class DoModifyAdminMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private AdminBiz adminBiz;
	
	public DoModifyAdminMemberServlet() {
		super();
		adminBiz = new AdminBizImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = Param.getStringParam(request, "userId");
		String email = Param.getStringParam(request, "email");
		String userName = Param.getStringParam(request, "userName");
		String password = Param.getStringParam(request, "password");
		String phoneNumber = Param.getStringParam(request, "phoneNumber");
		String age = Param.getStringParam(request, "age");
		String position = Param.getStringParam(request, "position");
		String leafCategory = Param.getStringParam(request, "leafCategory");

		UserVO userInfo = new UserVO();
		userInfo.setUserId(userId);
		userInfo.setEmail(email);
		userInfo.setUserName(userName);
		userInfo.setPassword(password);
		userInfo.setPhoneNumber(phoneNumber);
		userInfo.setAge(age);
		userInfo.setPosition(position);
		userInfo.setLocationId(leafCategory);

		PrintWriter out = response.getWriter();

		boolean isSuccess = adminBiz.userInfoModify(userInfo, request);

		if (isSuccess) {
			out.print(" <script type='text/javascript'>   ");
			out.print("  window.opener.location.reload();   ");
			out.print("  window.close();   ");
			out.print(" </script>  ");
			out.flush();
			out.close();
		} else {
			response.sendRedirect("/ShootBoy/admin/adminMemberModify?errorCode=1");
		}
	}
}
