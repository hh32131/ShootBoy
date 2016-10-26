package net.Y5M2.match.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.Y5M2.support.Param;
import net.Y5M2.teammatch.biz.TeamMatchBiz;
import net.Y5M2.teammatch.biz.TeamMatchBizImpl;

public class DoCancelMatch extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private TeamMatchBiz teamMatchBiz;
	
    public DoCancelMatch() {
        super();
        teamMatchBiz = new TeamMatchBizImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String matchId = Param.getStringParam(request, "matchId");
		
		boolean isSuccess = teamMatchBiz.deleteMatchOf(matchId);
		
		if(isSuccess) {
			response.sendRedirect("/ShootBoy/teamMatchInfo");
		}
		else {
			response.sendRedirect("/ShootBoy/teamMatchInfo?errorCode=1");
		}
	}

}
