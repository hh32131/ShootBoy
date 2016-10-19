package net.Y5M2.team.vo;

import java.util.List;

import net.Y5M2.support.pager.Pager;

public class TeamListVO {

	private List<TeamVO> teams;
	private Pager pager;

	public List<TeamVO> getTeams() {
		return teams;
	}

	public void setTeams(List<TeamVO> teams) {
		this.teams = teams;
	}

	public Pager getPager() {
		return pager;
	}

	public void setPager(Pager pager) {
		this.pager = pager;
	}

}
