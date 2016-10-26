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
	
	public boolean deleteTeamMatch(String teamId, String matchId);
	
	
>>>>>>> 49af612399d1c309731bee11c53ef9e01a720fb8
}
