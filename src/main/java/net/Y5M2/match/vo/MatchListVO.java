package net.Y5M2.match.vo;

import java.util.List;

import net.Y5M2.support.pager.Pager;

public class MatchListVO {

	private List<MatchVO> matchs;
	private Pager pager;
	
	public List<MatchVO> getMatchs() {
		return matchs;
	}
	public void setMatchs(List<MatchVO> matchs) {
		this.matchs = matchs;
	}
	public Pager getPager() {
		return pager;
	}
	public void setPager(Pager pager) {
		this.pager = pager;
	}
	
	
}
