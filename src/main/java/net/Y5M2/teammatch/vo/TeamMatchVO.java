package net.Y5M2.teammatch.vo;

import net.Y5M2.match.vo.MatchVO;
import net.Y5M2.team.vo.TeamVO;

public class TeamMatchVO {

	private String teamMatchId;
	private String teamId;
	private String awayTeamId;
	private String matchId;

	private TeamVO teamVO;
	private MatchVO matchVO;
	
	public TeamMatchVO() {
		teamVO = new TeamVO();
		matchVO = new MatchVO();
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

	public TeamVO getTeamVO() {
		return teamVO;
	}

	public void setTeamVO(TeamVO teamVO) {
		this.teamVO = teamVO;
	}

	public String getMatchId() {
		return matchId;
	}

	public void setMatchId(String matchId) {
		this.matchId = matchId;
	}

	public MatchVO getMatchVO() {
		return matchVO;
	}

	public void setMatchVO(MatchVO matchVO) {
		this.matchVO = matchVO;
	}
	
	

}
