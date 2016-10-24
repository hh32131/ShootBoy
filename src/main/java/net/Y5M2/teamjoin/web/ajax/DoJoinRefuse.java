package net.Y5M2.teamjoin.web.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.Y5M2.teamjoin.biz.TeamJoinBiz;
import net.Y5M2.teamjoin.biz.TeamJoinBizImpl;

public class DoJoinRefuse extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private TeamJoinBiz teamJoinBiz;
	
	
    public DoJoinRefuse() {
        super();
        teamJoinBiz = new TeamJoinBizImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] joinIds = request.getParameterValues("joinIds");
		PrintWriter out = response.getWriter();
		
		for (String refuseId : joinIds) {
			
			boolean isSuccess = teamJoinBiz.refuseJoin(refuseId);
			if(isSuccess){
				out.write("<script type='text/javascript'>");
				out.write(" document.location.reload(); ");
				out.write("</script>");
				out.flush();
				out.close();

			}
			else{
				out.write("<script type='text/javascript'>");
				out.write(" alert('회원가입거절에 실패했습니다.'); ");
				out.write("</script>");
				out.flush();
				out.close();
			}
		}
	}

}
