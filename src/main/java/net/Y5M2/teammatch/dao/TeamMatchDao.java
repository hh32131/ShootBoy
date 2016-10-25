package net.Y5M2.teammatch.dao;

import net.Y5M2.match.vo.MatchVO;

public interface TeamMatchDao {

	public int teamMatchRequest(String teamId, MatchVO matchVO);
	
	public int isExistTeam(MatchVO matchVO);
}
