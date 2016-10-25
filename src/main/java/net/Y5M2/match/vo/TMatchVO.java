package net.Y5M2.match.vo;

import net.Y5M2.team.vo.TeamVO;

public class TMatchVO {

	private String teamMatchId;
	private String teamId;
	private String awayTeamId;

	private TeamVO teamVO;

	public TMatchVO() {
		teamVO = new TeamVO();
	}

	public TeamVO getTeamVO() {
		return teamVO;
	}

	public void setTeamVO(TeamVO teamVO) {
		this.teamVO = teamVO;
	}

	public String getTeamMatchId() {
		return teamMatchId;
	}

	public void setTeamMatchId(String teamMatchId) {
		this.teamMatchId = teamMatchId;
	}

	public String getTeamId() {
		return teamId;
	}

	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}

	public String getAwayTeamId() {
		return awayTeamId;
	}

	public void setAwayTeamId(String awayTeamId) {
		this.awayTeamId = awayTeamId;
	}

}
