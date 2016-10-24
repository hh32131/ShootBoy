package net.Y5M2.teamjoin.biz;

import java.util.List;

import net.Y5M2.teamjoin.dao.TeamJoinDao;
import net.Y5M2.teamjoin.dao.TeamJoinDaoImpl;
import net.Y5M2.teamjoin.vo.TeamJoinVO;
import net.Y5M2.user.vo.UserVO;

public class TeamJoinBizImpl implements TeamJoinBiz {
	private TeamJoinDao teamJoinDao;
	
	public TeamJoinBizImpl() {
		teamJoinDao = new TeamJoinDaoImpl();
	}
	
	@Override
	public boolean SaveTeamJoinId(String teamId, UserVO userVO) {
		
		return teamJoinDao.SaveTeamJoinId(teamId, userVO)>0;
	}
	
	@Override
	public boolean isExistTeamJoinApply(UserVO userVO) {

		return teamJoinDao.isExistTeamJoinApply(userVO)>0;
	}
	
	@Override
	public List<TeamJoinVO> getTeamJoinId(String teamId) {

		return teamJoinDao.getTeamJoinId(teamId);
	}
	
	@Override
	public boolean admitJoinId(String joinId, String teamId) {
		
		teamJoinDao.deleteTeamJoinId(joinId);
		
		return teamJoinDao.admitJoinId(joinId, teamId)>0;
	}
	
	@Override
	public boolean refuseJoin(String refuseId) {

		return teamJoinDao.deleteTeamJoinId(refuseId)>0;
	}
	
}
