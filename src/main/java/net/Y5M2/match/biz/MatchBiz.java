package net.Y5M2.match.biz;

import java.util.List;

import net.Y5M2.match.vo.MatchVO;

public interface MatchBiz {

	public boolean applyMatch(MatchVO matchVO);

	public List<MatchVO> getMatchApplyTeamsOf();

}
