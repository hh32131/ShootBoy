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
	
		
		PrintWriter out = response.getWriter();
		StringBuffer list = new StringBuffer();
		List<MatchVO> matchTeams = matchBiz.getMatchApplyTeamsOf(locationId);
		
		for (MatchVO matchVO : matchTeams) {
			list.append(" <div class='matchApplyManagement'> ");	
			list.append(String.format(" <div class='matchApplyImg'> <img class='matchApplyImg' src='/ShootBoy/showImage?teamId=%s' ></div>", matchVO.getTeamId()));
			list.append(" <div class='matchApplyContent'>");
			list.append(String.format(" <div class='matchApplyTeamName'>팀명 : %s</div>", matchVO.getTeamVO().getTeamName()));
			list.append(String.format(" <div class='matchApplyTeamLocation'>지역 : %s -%s </div>",matchVO.getTeamVO().getLocationVO().getParentLocationName(), matchVO.getTeamVO().getLocationVO().getLocationName()));
			list.append(String.format(" <div class='matchApplyTeamName'>팀명 : %s</div>", matchVO.getTeamVO().getTeamName()));
			list.append(String.format(" <div class='matchApplyField'>%s(%s-%s)</div> ",matchVO.getPlayField(),matchVO.getLocationVO().getParentLocationName(),matchVO.getLocationVO().getLocationName()));
			list.append(String.format(" <div class='matchApplySchedule'>%s</div> ", matchVO.getSchedule()));
			list.append(String.format(" <input type='button' class='matchAgreementBtn' name='matchAgreementBtn' data-teamid='%s' data-matchid='%s' value='신청'> ",matchVO.getTeamId(),matchVO.getMatchId()));
			list.append(String.format(" <input type='button' class='matchCancelBtn' name='matchCancelBtn' data-teamid='%s' data-matchid='%s' value='취소' ", matchVO.getTeamId(), matchVO.getMatchId()));
			list.append(" </div> ");
			list.append(" </div> ");
		}
		
		out.write(list.toString());
		out.flush();
		out.close();
		
	}

}
