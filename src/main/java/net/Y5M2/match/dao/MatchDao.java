package net.Y5M2.match.dao;

import java.util.List;

import net.Y5M2.match.vo.MatchVO;

public interface MatchDao {

	public int applyMatch(MatchVO matchVO);

	public List<MatchVO> getMatchApplyTeamsOf();


}