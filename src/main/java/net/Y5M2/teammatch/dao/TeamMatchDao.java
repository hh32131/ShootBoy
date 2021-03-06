package net.Y5M2.teammatch.dao;

import java.util.List;

import net.Y5M2.teammatch.vo.TeamMatchVO;

public interface TeamMatchDao {

	public int teamMatchRequest(String teamId, String awayTeamId, String matchId);
	
	public int isExistTeam(String teamId, String matchId);

	public List<TeamMatchVO> getMatchApplyOf(String teamId);

	public int deleteMatchApply(String matchId);

	public List<TeamMatchVO> getMyApply(String teamId);

	public int deleteMatchOf(String matchId);

}
