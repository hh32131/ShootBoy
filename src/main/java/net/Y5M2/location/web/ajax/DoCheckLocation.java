package net.Y5M2.location.web.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.Y5M2.location.biz.LocationBiz;
import net.Y5M2.location.biz.LocationBizImpl;
import net.Y5M2.location.vo.LocationVO;
import net.Y5M2.support.Param;

public class DoCheckLocation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LocationBiz locationBiz;
	public DoCheckLocation() {
		super();
		locationBiz = new LocationBizImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		StringBuffer options = new StringBuffer();
		String locationId = Param.getStringParam(request, "locationId");
		LocationVO locationVO = new LocationVO();
		locationVO.setParentLocationId(locationId);
		List<LocationVO> locations = locationBiz.getLocations(locationVO);
		
<<<<<<< HEAD
		StringBuffer options = new StringBuffer();
		options.append("<option>상세 지역을 선택하세요</option>");
=======
			options.append("<option>상세 지역을 선택하세요</option>");
>>>>>>> be6d1e2bc9790da65c4641f3f12c74b61718efd8
		for (LocationVO location : locations) {
			options.append(String.format("<option value='%s'>%s</option>", location.getLocationId(), location.getLocationName() ));
		}
		
		PrintWriter out = response.getWriter();
		out.write(options.toString());
		out.flush();
		out.close();
	}

}
