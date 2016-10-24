package net.Y5M2.match.biz;

import java.util.List;

import net.Y5M2.match.dao.MatchDao;
import net.Y5M2.match.dao.MatchDaoImpl;
import net.Y5M2.match.vo.MatchVO;

public class MatchBizImpl implements MatchBiz {

	private MatchDao matchDao;
	
	public MatchBizImpl() {
		matchDao = new MatchDaoImpl();
	}
	
	@Override
	public boolean applyMatch(MatchVO matchVO) {

		return matchDao.applyMatch(matchVO)>0;
	}
	
	@Override
	public List<MatchVO> getMatchApplyTeamsOf(String locationId, String beginDate, String endDate) {

		return matchDao.getMatchApplyTeamsOf(locationId,beginDate,endDate);
	}
	
}
