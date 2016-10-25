package net.Y5M2.teammatch.biz;

import net.Y5M2.match.vo.MatchVO;
import net.Y5M2.teammatch.dao.TeamMatchDao;
import net.Y5M2.teammatch.dao.TeamMatchDaoImpl;

public class TeamMatchBizImpl implements TeamMatchBiz {

	TeamMatchDao teamMatchDao;
	
	public TeamMatchBizImpl() {
		teamMatchDao = new TeamMatchDaoImpl();
	}
	
	@Override
	public boolean teamMatchRequest(String teamId, MatchVO matchVO) {
		return teamMatchDao.teamMatchRequest(teamId, matchVO) > 0;
	}
	
	@Override
	public boolean isExistTeam(MatchVO matchVO) {
		return teamMatchDao.isExistTeam(matchVO) > 0;
	}

}
