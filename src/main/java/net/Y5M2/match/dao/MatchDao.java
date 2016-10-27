package net.Y5M2.match.dao;

import java.util.List;

import net.Y5M2.match.vo.MatchListVO;
import net.Y5M2.match.vo.MatchVO;
import net.Y5M2.match.vo.SearchMatchVO;

public interface MatchDao {

	public int applyMatch(MatchVO matchVO);

	public List<MatchVO> getMatchApplyTeamsOf(String locationId, String beginDate, String endDate);

	public List<MatchVO> getAllMatchTeam(String teamId);

	public List<MatchVO> getAllMatchTeams();
	
	public int doMatch(String matchId, String awayTeamId);
	
	public List<MatchVO> getCompleteMatch(String teamId);

	public int checkTheMatchTeam(MatchVO matchVO);
	
	public int deleteTeamMatch(String teamId, String matchId);
	
	public int deleteTeamMatchs(String teamId);
	
	public int deleteAdminTeamMatch(String matchId);
	
	public List<MatchVO> getAllTeamMatchs(SearchMatchVO searchTeamMatch);
	
	public int getCountOfTeamMatchs(SearchMatchVO searchTeamMatch);
}
