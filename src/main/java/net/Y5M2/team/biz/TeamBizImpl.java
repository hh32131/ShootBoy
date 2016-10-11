package net.Y5M2.team.biz;

import net.Y5M2.team.dao.TeamDao;
import net.Y5M2.team.dao.TeamDaoImpl;
import net.Y5M2.team.vo.TeamVO;

public class TeamBizImpl implements TeamBiz {

	private TeamDao teamDao;
	
	public TeamBizImpl() {
		teamDao = new TeamDaoImpl();
	}
	
	@Override
	public boolean addTeam(TeamVO teamVO) {
		return teamDao.addTeam(teamVO) > 0;
	}
	
}
