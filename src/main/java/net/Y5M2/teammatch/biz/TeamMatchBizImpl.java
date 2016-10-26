package net.Y5M2.teammatch.biz;

import java.util.List;

import net.Y5M2.match.vo.MatchVO;
import net.Y5M2.teammatch.dao.TeamMatchDao;
import net.Y5M2.teammatch.dao.TeamMatchDaoImpl;
import net.Y5M2.teammatch.vo.TeamMatchVO;

public class TeamMatchBizImpl implements TeamMatchBiz {

	TeamMatchDao teamMatchDao;
	
	public TeamMatchBizImpl() {
		teamMatchDao = new TeamMatchDaoImpl();
	}
	
	@Override
	public boolean teamMatchRequest(String teamId, String awayTeamId, String matchId) {
		return teamMatchDao.teamMatchRequest(teamId, awayTeamId, matchId) > 0;
	}
	
	@Override
	public boolean isExistTeam(String teamId) {
		return teamMatchDao.isExistTeam(teamId) > 0;
	}

	@Override
	public List<TeamMatchVO> getMatchApplyOf(String teamId) {

		return teamMatchDao.getMatchApplyOf(teamId);
	}
	
	@Override
	public List<TeamMatchVO> getMyApply(String teamId) {
		
		return teamMatchDao.getMyApply(teamId);
	}
	
	@Override
	public boolean deleteMatchOf(String matchId) {
		return teamMatchDao.deleteMatchOf(matchId) > 0;
	}
}
