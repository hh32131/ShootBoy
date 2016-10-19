package net.Y5M2.admin.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.Y5M2.team.biz.TeamBiz;
import net.Y5M2.team.biz.TeamBizImpl;

public class DoDeleteTeamAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TeamBiz teamBiz;
	public DoDeleteTeamAdminServlet() {
		super();
		teamBiz = new TeamBizImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		  String[] checkbox = request.getParameterValues("select-check");
	        
	        PrintWriter out = response.getWriter();
	        
	        if(checkbox==null || checkbox.length == 0) {
	            out.print("다시선택하세요. ");
	            return;
	        }
	        else {
	            for(int i=0; i < checkbox.length; i++){
	                teamBiz.deleteTeam(checkbox[i]);
	            }
	            out.print("삭제했습니다. ");
	        }
	        
	        
	        out.flush();
	        out.close();
	    }

}
