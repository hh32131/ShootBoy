package net.Y5M2.teamjoin.biz;

import java.util.List;

import net.Y5M2.teamjoin.vo.TeamJoinVO;
import net.Y5M2.user.vo.UserVO;

public interface TeamJoinBiz {

	public boolean SaveTeamJoinId(String teamId, UserVO userVO);

	public boolean isExistTeamJoinApply(UserVO userVO);

	public List<TeamJoinVO> getTeamJoinId(String teamId);

	public boolean admitJoinId(String joinId, String teamId);

	public boolean refuseJoin(String refuseId);

	

}
