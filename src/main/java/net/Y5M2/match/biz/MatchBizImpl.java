package net.Y5M2.match.biz;

import java.util.List;

import net.Y5M2.match.dao.MatchDao;
import net.Y5M2.match.dao.MatchDaoImpl;
import net.Y5M2.match.vo.MatchVO;
import net.Y5M2.teammatch.dao.TeamMatchDao;
import net.Y5M2.teammatch.dao.TeamMatchDaoImpl;

public class MatchBizImpl implements MatchBiz {

	private MatchDao matchDao;
	private TeamMatchDao teamMatchDao;
	
	public MatchBizImpl() {
		matchDao = new MatchDaoImpl();
		teamMatchDao = new TeamMatchDaoImpl();
	}
	
	@Override
	public boolean applyMatch(MatchVO matchVO) {

		return matchDao.applyMatch(matchVO)>0;
	}
	
	@Override
	public List<MatchVO> getMatchApplyTeamsOf(String locationId, String beginDate, String endDate) {

		return matchDao.getMatchApplyTeamsOf(locationId,beginDate,endDate);
	}

	@Override
	public List<MatchVO> getAllMatchTeam(String teamId) {
		return matchDao.getAllMatchTeam(teamId);
	}
	@Override
	public boolean doMatch(String matchId, String awayTeamId) {
		
		teamMatchDao.deleteMatchApply(matchId);
		
		return matchDao.doMatch(matchId, awayTeamId)>0;
	}
	
	@Override
	public List<MatchVO> getCompleteMatch(String teamId) {
		return matchDao.getCompleteMatch(teamId);
	}
	
}
