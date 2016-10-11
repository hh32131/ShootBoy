package net.Y5M2.user.web;

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

public class ViewSignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private LocationBiz locationBiz;
    public ViewSignUpServlet() {
        super();
        locationBiz = new LocationBizImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String locationId = Param.getStringParam(request, "locationId");
		if ( locationId == null ) {
			response.sendRedirect("");
		}
		
		List<LocationVO> locations = locationBiz.getLocations();

		
		String viewPath = "/WEB-INF/view/signUp.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(viewPath);
		request.setAttribute("location", locations);
		rd.forward(request, response);
	}

}
