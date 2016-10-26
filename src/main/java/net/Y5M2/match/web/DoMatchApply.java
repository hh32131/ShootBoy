package net.Y5M2.match.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.Y5M2.constants.Session;
import net.Y5M2.match.biz.MatchBiz;
import net.Y5M2.match.biz.MatchBizImpl;
import net.Y5M2.match.vo.MatchVO;
import net.Y5M2.support.Param;
import net.Y5M2.user.vo.UserVO;

public class DoMatchApply extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private MatchBiz matchBiz;
	
    public DoMatchApply() {
        super();
        matchBiz = new MatchBizImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String locationId = Param.getStringParam(request, "locationId");
		String leafCategory = Param.getStringParam(request, "leafCategory");
		String playingField = Param.getStringParam(request, "playingField");
		String schedule = Param.getStringParam(request, "schedule");
		
		HttpSession session = request.getSession();
		UserVO userVO = (UserVO) session.getAttribute(Session.USER_INFO);
		
		MatchVO matchVO = new MatchVO();
		matchVO.setSchedule(schedule);
		matchVO.setPlayField(playingField);
		matchVO.setLocationId(leafCategory);
		matchVO.setParentLocaionId(locationId);
		matchVO.setTeamId(userVO.getTeamId());
		
		PrintWriter out = response.getWriter();
		
		boolean isSuccess = matchBiz.applyMatch(matchVO);
		if(isSuccess){
			out.write(" <script type='text/javascript'> ");
			out.write(" window.close(); ");
			out.write(" </script> ");
			out.flush();
			out.close();
		}
		else{
			out.write(" <script type='text/javascript'> ");
			out.write(" location.href='/ShootBoy/doMatchApply?errorCode=1'; ");
			out.write(" </script> ");
			out.flush();
			out.close();
		}
			
			
		
	}

}
