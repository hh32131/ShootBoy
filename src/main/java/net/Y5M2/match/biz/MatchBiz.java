package net.Y5M2.match.biz;

import java.util.List;

import net.Y5M2.match.vo.MatchListVO;
import net.Y5M2.match.vo.MatchVO;
import net.Y5M2.match.vo.SearchMatchVO;

public interface MatchBiz {

	public boolean applyMatch(MatchVO matchVO);

	public List<MatchVO> getMatchApplyTeamsOf(String locationId, String beginDate, String endDate);

	public MatchListVO getAllMatchTeam(SearchMatchVO searchMatch);

	public boolean doMatch(String matchId, String awayTeamId);

	public List<MatchVO> getCompleteMatch(String teamId);

	public boolean deleteTeamMatch(String teamId, String matchId);

}
