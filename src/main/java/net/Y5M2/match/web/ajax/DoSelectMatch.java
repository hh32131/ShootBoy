package net.Y5M2.match.web.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.Y5M2.match.biz.MatchBiz;
import net.Y5M2.match.biz.MatchBizImpl;
import net.Y5M2.match.vo.MatchVO;
import net.Y5M2.support.Param;

public class DoSelectMatch extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private MatchBiz matchBiz;
    public DoSelectMatch() {
        super();
        matchBiz = new MatchBizImpl();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String locationId = Param.getStringParam(request, "locationId");
		String beginDate = Param.getStringParam(request, "beginDate");
		String endDate = Param.getStringParam(request, "endDate");
		
		PrintWriter out = response.getWriter();
		StringBuffer list = new StringBuffer();
		List<MatchVO> matchTeams = matchBiz.getMatchApplyTeamsOf(locationId,beginDate,endDate);
		
		for (MatchVO matchVO : matchTeams) {
			list.append(" <tr> ");
			list.append(String.format(" <td rowspan='3'><img src='/ShootBoy/showImge?teamId=%s'></td> ", matchVO.getTeamId()));
			list.append(String.format(" <td>%s</td> ",matchVO.getTeamVO().getTeamName()));
			list.append(String.format(" <td>%s-%s</td> ",matchVO.getTeamVO().getLocationVO().getParentLocationName(), matchVO.getTeamVO().getLocationVO().getLocationName()));
			list.append(" <td rowspan='3'><input type='button' id='applyBtn' name='applyBtn' value='신청'></td> ");
			list.append(" </tr> ");
			list.append(" <tr> ");
			list.append(String.format(" <td>%s(%s-%s)</td> ",matchVO.getPlayField(),matchVO.getLocationVO().getParentLocationName(),matchVO.getLocationVO().getLocationName()));
			list.append(String.format(" <td>%s</td> ", matchVO.getSchedule()));
			list.append(" </tr> ");
			list.append(" <tr> ");
			list.append(String.format(" <td colspan='2'>%s</td> ", matchVO.getTeamVO().getTeamInfo()));
			list.append(" </tr> ");
		}
		
		out.write(list.toString());
		out.flush();
		out.close();
		
	}

}
