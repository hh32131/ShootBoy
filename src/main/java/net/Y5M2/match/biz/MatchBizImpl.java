package net.Y5M2.match.biz;

import java.util.List;

import net.Y5M2.match.dao.MatchDao;
import net.Y5M2.match.dao.MatchDaoImpl;
import net.Y5M2.match.vo.MatchListVO;
import net.Y5M2.match.vo.MatchVO;
import net.Y5M2.match.vo.SearchMatchVO;
import net.Y5M2.support.pager.Pager;
import net.Y5M2.support.pager.PagerFactory;
import net.Y5M2.teammatch.dao.TeamMatchDao;
import net.Y5M2.teammatch.dao.TeamMatchDaoImpl;

public class MatchBizImpl implements MatchBiz {

	private MatchDao matchDao;
	private TeamMatchDao teamMatchDao;
	
	public MatchBizImpl() {
		matchDao = new MatchDaoImpl();
		teamMatchDao = new TeamMatchDaoImpl();
	}
	
	@Override
	public boolean applyMatch(MatchVO matchVO) {
		
		boolean isSuccess = matchDao.checkTheMatchTeam(matchVO) < 4;
		if ( isSuccess ) {
			return matchDao.applyMatch(matchVO)  > 0;
		}
		return false;
	}
	
	@Override
	public List<MatchVO> getMatchApplyTeamsOf(String locationId) {

		return matchDao.getMatchApplyTeamsOf(locationId);
	}

	@Override
	public MatchListVO getAllMatchTeam(SearchMatchVO searchMatch) {
		int totalCount = matchDao.getCountOfMatchs(searchMatch);
		Pager pager = PagerFactory.getPager(true,3,3);
		pager.setTotalArticleCount(totalCount);
		pager.setPageNumber(searchMatch.getPageNo());
		
		searchMatch.setStartRowNumber(pager.getStartArticleNumber());
		searchMatch.setEndRowNumber(pager.getEndArticleNumber());
		
		List<MatchVO> matchs = matchDao.getAllMatchTeam(searchMatch);
		
		MatchListVO matchList = new MatchListVO();
		matchList.setPager(pager);
		matchList.setMatchs(matchs);
		
		return matchList;
	}
	@Override
	public boolean doMatch(String matchId, String awayTeamId) {
		
		teamMatchDao.deleteMatchApply(matchId);
		
		return matchDao.doMatch(matchId, awayTeamId)>0;
	}

	@Override
	public boolean deleteTeamMatch(String teamId, String matchId) {
		return matchDao.deleteTeamMatch(teamId, matchId) > 0;
	}

	
	@Override
	public List<MatchVO> getCompleteMatch(String teamId) {
		return matchDao.getCompleteMatch(teamId);
	}
	
	@Override
	public List<MatchVO> getAllMatchList() {
		return matchDao.getAllMatchList();
	}
}
