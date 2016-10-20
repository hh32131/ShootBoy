package net.Y5M2.teamjoin.vo;

import net.Y5M2.team.vo.TeamVO;
import net.Y5M2.user.vo.UserVO;

public class TeamJoinVO {
	private String teamJoinId;
	private String teamId;
	private String userId;

	private UserVO userVO;
	private TeamVO teamVO;
	
	public TeamJoinVO() {
		userVO = new UserVO();
		teamVO = new TeamVO();
	}

	public String getTeamJoinId() {
		return teamJoinId;
	}

	public void setTeamJoinId(String teamJoinId) {
		this.teamJoinId = teamJoinId;
	}

	public String getTeamId() {
		return teamId;
	}

	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public UserVO getUserVO() {
		return userVO;
	}

	public void setUserVO(UserVO userVO) {
		this.userVO = userVO;
	}

	public TeamVO getTeamVO() {
		return teamVO;
	}

	public void setTeamVO(TeamVO teamVO) {
		this.teamVO = teamVO;
	}
	
	
}
