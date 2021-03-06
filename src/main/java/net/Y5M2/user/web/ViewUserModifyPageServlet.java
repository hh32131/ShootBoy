package net.Y5M2.user.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.Y5M2.constants.Session;
import net.Y5M2.location.biz.LocationBiz;
import net.Y5M2.location.biz.LocationBizImpl;
import net.Y5M2.location.vo.LocationVO;
import net.Y5M2.user.vo.UserVO;

public class ViewUserModifyPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private LocationBiz locationBiz;
    public ViewUserModifyPageServlet() {
        super();
        locationBiz = new LocationBizImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		UserVO userInfo = (UserVO) session.getAttribute(Session.USER_INFO);
		
		LocationVO locationVO = new LocationVO();
		locationVO.setParentLocationId("0");
		
		List<LocationVO> location = locationBiz.getLocations(locationVO);
		
		String viewPath = "/WEB-INF/view/user/userModify.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(viewPath);
		request.setAttribute("userInfo", userInfo);
		request.setAttribute("location", location);
		rd.forward(request, response);
	}

}
