package net.Y5M2.admin.web;

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
import net.Y5M2.support.Param;
import net.Y5M2.team.biz.TeamBiz;
import net.Y5M2.team.biz.TeamBizImpl;
import net.Y5M2.team.vo.TeamVO;

public class ViewAdminTeamModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LocationBiz locationBiz;
	private TeamBiz teamBiz;
	public ViewAdminTeamModifyServlet() {
		super();
		locationBiz = new LocationBizImpl();
		teamBiz = new TeamBizImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String teamId =  Param.getStringParam(request, "teamId");
		
		TeamVO team = teamBiz.getTeamAt(teamId);
		LocationVO locationVO = new LocationVO();
		locationVO.setParentLocationId("0");
		
		List<LocationVO> location = locationBiz.getLocations(locationVO);
		
		String viewPath = "/WEB-INF/view/admin/adminTeamModify.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(viewPath);
		
		request.setAttribute("location", location);
		request.setAttribute("teamInfo", team);
		
		rd.forward(request, response);
		
	}

}
