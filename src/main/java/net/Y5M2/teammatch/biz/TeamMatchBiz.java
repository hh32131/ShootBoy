package net.Y5M2.teammatch.biz;

import net.Y5M2.match.vo.MatchVO;

public interface TeamMatchBiz {

	public boolean teamMatchRequest(String teamId, MatchVO matchVO);
	
	public boolean isExistTeam(MatchVO matchVO);
	
}
