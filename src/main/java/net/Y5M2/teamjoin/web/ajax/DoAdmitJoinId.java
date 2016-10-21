package net.Y5M2.teamjoin.web.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.Y5M2.support.Param;
import net.Y5M2.teamjoin.biz.TeamJoinBiz;
import net.Y5M2.teamjoin.biz.TeamJoinBizImpl;

public class DoAdmitJoinId extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TeamJoinBiz  teamJoinBiz;

	
    public DoAdmitJoinId() {
        super();
        teamJoinBiz = new TeamJoinBizImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] joinIds = request.getParameterValues("joinIds");
		String teamId = Param.getStringParam(request, "teamId");
		
		if(joinIds==null || joinIds.length == 0){
			
		}
		PrintWriter out = response.getWriter();
		for (String joinId : joinIds) {
			
			boolean isSuccess = teamJoinBiz.admitJoinId(joinId, teamId);
			if(isSuccess){
				out.write("<script type='text/javascript'>");
				out.write(" reload(); ");
				out.write("</script>");
				out.flush();
				out.close();
			}
			else{
				
			}
			
			
			
			
		}
	}

}
