package net.Y5M2.team.biz;

import java.util.List;

import net.Y5M2.article.vo.BoardVO;
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

	@Override
	public List<TeamVO> getAllTeam() {
		return teamDao.getAllTeam();
	}

	@Override
	public TeamVO getTeamAt(String teamId) {
		return teamDao.getTeamAt(teamId);
	}

	@Override
	public String getFileNmaeOfTeamBy(String teamId) {
		TeamVO team = teamDao.getTeamAt(teamId);
		return team.getTeamPhoto();
	}
	
}
