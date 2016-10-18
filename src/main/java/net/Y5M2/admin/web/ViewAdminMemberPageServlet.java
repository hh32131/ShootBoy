package net.Y5M2.admin.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.Y5M2.admin.biz.AdminBiz;
import net.Y5M2.admin.biz.AdminBizImpl;
import net.Y5M2.user.vo.UserVO;

public class ViewAdminMemberPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private  AdminBiz adminBiz;
    public ViewAdminMemberPageServlet() {
        super();
        adminBiz = new AdminBizImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String viewPath = "/WEB-INF/view/adminMember.jsp";
		
		List<UserVO> users = adminBiz.getAllUser();
		
		RequestDispatcher rd = request.getRequestDispatcher(viewPath);

		request.setAttribute("users", users);
		
		rd.forward(request, response);
	}

}
