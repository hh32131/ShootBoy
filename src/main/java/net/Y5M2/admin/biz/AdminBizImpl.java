package net.Y5M2.admin.biz;

import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.Y5M2.article.dao.BoardDao;
import net.Y5M2.article.dao.BoardDaoImpl;
import net.Y5M2.article.vo.BoardVO;
import net.Y5M2.constants.Session;
import net.Y5M2.team.dao.TeamDao;
import net.Y5M2.team.dao.TeamDaoImpl;
import net.Y5M2.team.vo.TeamVO;
import net.Y5M2.user.dao.UserDao;
import net.Y5M2.user.dao.UserDaoImpl;
import net.Y5M2.user.vo.UserVO;

public class AdminBizImpl implements AdminBiz {

	private UserDao userDao;
	private TeamDao teamDao;
	private BoardDao boardDao;

	public AdminBizImpl() {
		userDao = new UserDaoImpl();
		teamDao = new TeamDaoImpl();
		boardDao = new BoardDaoImpl();
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
<<<<<<< HEAD
	
  	@Override
	public int getCountOfUsers() {
		return userDao.getCountOfUsers();
	}

	@Override
	public int getCountOfBoards() {
		return boardDao.getCountOfBoards();
=======

	@Override
	public int getCountOfUsers(String userId) {
		return userDao.getCountOfUser(userId);
	}

	@Override
	public int getCountOfBoards(String boardId) {
		return boardDao.getCountOfBoards(boardId);
>>>>>>> e73764ea7a70014e2107664083f2144c4fdf9228
	}
}
