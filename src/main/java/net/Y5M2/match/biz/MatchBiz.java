package net.Y5M2.match.biz;

import java.util.List;

import net.Y5M2.match.vo.MatchVO;

public interface MatchBiz {

	public boolean applyMatch(MatchVO matchVO);

	public List<MatchVO> getMatchApplyTeamsOf(String locationId, String beginDate, String endDate);

	public List<MatchVO> getAllMatchTeam(String teamId);

	public boolean doMatch(String matchId, String awayTeamId);
<<<<<<< HEAD

	public List<MatchVO> getCompleteMatch(String teamId);
=======
	
>>>>>>> 024479efcca4b12b056546aea06981ae67f827cc
}
