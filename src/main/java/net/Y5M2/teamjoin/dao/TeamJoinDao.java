package net.Y5M2.teamjoin.dao;

import java.util.List;

import net.Y5M2.teamjoin.vo.TeamJoinVO;
import net.Y5M2.user.vo.UserVO;

public interface TeamJoinDao {

	public int SaveTeamJoinId(String teamId, UserVO userVO);

	public int isExistTeamJoinApply(UserVO userVO);

	public List<TeamJoinVO> getTeamJoinId(String teamId);

}
