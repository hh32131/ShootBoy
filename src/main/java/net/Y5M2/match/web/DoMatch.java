package net.Y5M2.match.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.Y5M2.match.biz.MatchBiz;
import net.Y5M2.match.biz.MatchBizImpl;
import net.Y5M2.support.Param;

public class DoMatch extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private MatchBiz matchBiz;
    public DoMatch() {
        super();
        matchBiz = new MatchBizImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String matchId = Param.getStringParam(request, "matchId");
		String awayTeamId = Param.getStringParam(request, "awayTeamId");
		
		
		boolean isSuccess = matchBiz.doMatch(matchId, awayTeamId);
		if(isSuccess){
			response.sendRedirect("/ShootBoy/matchApplyManagement");
		}
		else{
			response.sendRedirect("/ShootBoy/matchApplyManagement?errorCode=1");
		}
	}

}
