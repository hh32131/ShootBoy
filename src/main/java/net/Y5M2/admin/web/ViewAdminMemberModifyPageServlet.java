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
import net.Y5M2.location.biz.LocationBiz;
import net.Y5M2.location.biz.LocationBizImpl;
import net.Y5M2.location.vo.LocationVO;
import net.Y5M2.support.Param;
import net.Y5M2.user.vo.UserVO;

public class ViewAdminMemberModifyPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private AdminBiz adminBiz;
	private LocationBiz locationBiz;

	public ViewAdminMemberModifyPageServlet() {
		super();
		adminBiz = new AdminBizImpl();
		locationBiz = new LocationBizImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userId = Param.getStringParam(request, "userId");
		UserVO userVO = adminBiz.getUserOne(userId);
		
		LocationVO locationVO = new LocationVO();
		locationVO.setParentLocationId("0");
		
		List<LocationVO> location = locationBiz.getLocations(locationVO);
		
		String viewPath = "/WEB-INF/view/admin/adminMemberModify.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(viewPath);
		request.setAttribute("userInfo", userVO);
		request.setAttribute("location", location);
		rd.forward(request, response);
	}
}
