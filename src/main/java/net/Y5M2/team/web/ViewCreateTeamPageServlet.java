package net.Y5M2.team.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.Y5M2.location.biz.LocationBiz;
import net.Y5M2.location.biz.LocationBizImpl;
import net.Y5M2.location.vo.LocationVO;

public class ViewCreateTeamPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LocationBiz locationBiz;
	public ViewCreateTeamPageServlet() {
		super();
		locationBiz = new LocationBizImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		
		LocationVO locationVO = new LocationVO();
		locationVO.setParentLocationId("0");
		
		List<LocationVO> location = locationBiz.getLocations(locationVO);
				
		String viewPath = "/WEB-INF/view/team/createTeam.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(viewPath);
		request.setAttribute("location", location);
		rd.forward(request, response);
	}

}
