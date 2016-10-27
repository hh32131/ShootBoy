package net.Y5M2.admin.biz;

import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.Y5M2.admin.dao.AdminDao;
import net.Y5M2.admin.dao.AdminDaoImpl;
import net.Y5M2.article.dao.BoardDao;
import net.Y5M2.article.dao.BoardDaoImpl;
import net.Y5M2.article.vo.BoardVO;
import net.Y5M2.constants.PageSelector;
import net.Y5M2.constants.Session;
import net.Y5M2.match.dao.MatchDao;
import net.Y5M2.match.dao.MatchDaoImpl;
import net.Y5M2.match.vo.MatchListVO;
import net.Y5M2.match.vo.MatchVO;
import net.Y5M2.match.vo.SearchMatchVO;
import net.Y5M2.support.pager.Pager;
import net.Y5M2.support.pager.PagerFactory;
import net.Y5M2.team.dao.TeamDao;
import net.Y5M2.team.dao.TeamDaoImpl;
import net.Y5M2.team.vo.SearchTeamVO;
import net.Y5M2.team.vo.TeamBoardListVO;
import net.Y5M2.team.vo.TeamBoardVO;
import net.Y5M2.team.vo.TeamVO;
import net.Y5M2.user.dao.UserDao;
import net.Y5M2.user.dao.UserDaoImpl;
import net.Y5M2.user.vo.UserVO;

public class AdminBizImpl implements AdminBiz {

	private UserDao userDao;
	private TeamDao teamDao;
	private BoardDao boardDao;
	private AdminDao adminDao;
	private MatchDao matchDao;

	public AdminBizImpl() {
		userDao = new UserDaoImpl();
		teamDao = new TeamDaoImpl();
		boardDao = new BoardDaoImpl();
		adminDao = new AdminDaoImpl();
		matchDao = new MatchDaoImpl();
	}

	@Override
	public List<UserVO> getAllUser() {
		return userDao.getUserListOf();
	}

	@Override
	public List<BoardVO> getAllBoard() {
		return boardDao.getAllBoard();
	}

	@Override
	public List<TeamVO> getAllTeams() {
		return teamDao.getAllTeams();
	}

	@Override
	public boolean deleteUser(String userId) {
		return userDao.adminPageDeleteUser(userId) > 0;
	}

	@Override
	public UserVO getUserOne(String userId) {
		return userDao.getUserOne(userId);
	}

	public int getCountOfTeam(String teamId) {
		return teamDao.getCountOfTeam(teamId);
	}

	@Override
	public boolean userInfoModify(UserVO userInfo, ServletRequest request) {
		UserVO originalUserInfo = userDao.getUserInfoForModify(userInfo);

		int modiUserCount = 6;
		if (originalUserInfo.getPassword().equals(userInfo.getPassword())) {
			userInfo.setPassword(null);
			modiUserCount--;
		}
		if (originalUserInfo.getUserName().equals(userInfo.getUserName())) {
			userInfo.setUserName(null);
			modiUserCount--;
		}
		if (originalUserInfo.getPhoneNumber().equals(userInfo.getPhoneNumber())) {
			userInfo.setPhoneNumber(null);
			modiUserCount--;
		}
		if (originalUserInfo.getAge().equals(userInfo.getAge())) {
			userInfo.setAge(null);
			modiUserCount--;
		}
		if (originalUserInfo.getPosition().equals(userInfo.getPosition())) {
			userInfo.setPosition(null);
			modiUserCount--;
		}
		if (originalUserInfo.getLocationId().equals(userInfo.getLocationId())) {
			userInfo.setLocationId(null);
			modiUserCount--;
		}
		if (modiUserCount == 0) {
			return true;
		}
		boolean isSuccess = userDao.UpdateUserInfo(userInfo) > 0;
		if (isSuccess) {
			HttpSession session = ((HttpServletRequest) request).getSession();
			session.removeAttribute(Session.USER_INFO);
			UserVO UserVO = userDao.getUserInfoForModify(userInfo);
			session.setAttribute(Session.USER_INFO, UserVO);

			return true;
		} else {
			return false;
		}
	}

	@Override
	public BoardVO getBoardOne(String boardId) {
		return boardDao.getBoardAt(boardId);
	}

	@Override
	public int getCountOfUsers() {
		return userDao.getCountOfUsers();
	}

	@Override
	public int getCountOfBoards() {
		return boardDao.getCountOfBoards();
	}

	@Override
	public TeamBoardListVO getAllTeamBoards(SearchTeamVO searchTeam, TeamBoardVO teamBoardVO) {
		int totalCount = teamDao.getCountOfTeamBoard(searchTeam);
		Pager pager = PagerFactory.getPager(true, PageSelector.TEAMBOARD_PAGE_SELECTOR, 5);
		pager.setTotalArticleCount(totalCount);
		pager.setPageNumber(searchTeam.getPageNo());

		searchTeam.setStartRowNumber(pager.getStartArticleNumber());
		searchTeam.setEndRowNumber(pager.getEndArticleNumber());

		List<TeamBoardVO> teams = adminDao.getAllTeamBoards(searchTeam, teamBoardVO);

		TeamBoardListVO teamList = new TeamBoardListVO();
		teamList.setPager(pager);
		teamList.setTeams(teams);

		return teamList;
	}

	@Override
	public MatchListVO getAllTeamMatchs(SearchMatchVO searchTeamMatch) {
		int totalCount = matchDao.getCountOfTeamMatchs(searchTeamMatch);
		Pager pager = PagerFactory.getPager(true, 10, 5);
		pager.setTotalArticleCount(totalCount);
		pager.setPageNumber(searchTeamMatch.getPageNo());
		
		searchTeamMatch.setStartRowNumber(pager.getStartArticleNumber());
		searchTeamMatch.setEndRowNumber(pager.getEndArticleNumber());
		
		List<MatchVO> matchs = matchDao.getAllTeamMatchs(searchTeamMatch);
		
		MatchListVO matchList = new MatchListVO();
		matchList.setPager(pager);
		matchList.setMatchs(matchs);
		
		return matchList;
	}

	@Override
	public int getCountOfTeamBoards() {
		return adminDao.getCountOfTeamBoards();
	}

	@Override
	public List<MatchVO> getAllMatchTeams() {
		return matchDao.getAllMatchTeams();
	}

	@Override
	public boolean deleteAdminTeamMatchs(String matchId) {
		return matchDao.deleteAdminTeamMatch(matchId) > 0;
	}


	@Override
	public int getCountOfTeamMatchs() {
		return adminDao.getCountOfTeamMatchs();
	}


}
