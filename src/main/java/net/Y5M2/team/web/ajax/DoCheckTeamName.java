package net.Y5M2.team.web.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.Y5M2.support.Param;
import net.Y5M2.team.biz.TeamBiz;
import net.Y5M2.team.biz.TeamBizImpl;

public class DoCheckTeamName extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private TeamBiz teamBiz;
	public DoCheckTeamName() {
		super();
		teamBiz = new TeamBizImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String teamName = Param.getStringParam(request, "teamName");
		
		boolean isSuccess = teamBiz.isExsistTeam(teamName);

		PrintWriter out = response.getWriter();
		out.print(isSuccess + "");
		out.flush();
		out.close();
		
	}

}
