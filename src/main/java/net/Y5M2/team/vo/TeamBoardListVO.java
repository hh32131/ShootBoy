package net.Y5M2.team.vo;

import java.util.List;

import net.Y5M2.support.pager.Pager;

public class TeamBoardListVO {

	private List<TeamBoardVO> teams;
	private Pager pager;



	public List<TeamBoardVO> getTeamBoards() {
		return teams;
	}

	public void setTeams(List<TeamBoardVO> teams) {
		this.teams = teams;
	}

	public Pager getPager() {
		return pager;
	}

	public void setPager(Pager pager) {
		this.pager = pager;
	}

}
