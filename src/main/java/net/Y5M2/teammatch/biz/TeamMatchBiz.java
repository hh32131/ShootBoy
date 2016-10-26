package net.Y5M2.teammatch.biz;

import java.util.List;

import net.Y5M2.teammatch.vo.TeamMatchVO;

public interface TeamMatchBiz {

	public boolean teamMatchRequest(String teamId, String awayTeamId, String matchId);
	
	public boolean isExistTeam(String teamId, String matchId);

	public List<TeamMatchVO> getMatchApplyOf(String teamId);

	public List<TeamMatchVO> getMyApply(String teamId);

	public boolean deleteMatchOf(String matchId);

}
