package net.Y5M2.admin.biz;

import java.util.List;

import net.Y5M2.article.dao.BoardDao;
import net.Y5M2.article.dao.BoardDaoImpl;
import net.Y5M2.article.vo.BoardVO;
import net.Y5M2.team.dao.TeamDao;
import net.Y5M2.team.dao.TeamDaoImpl;
import net.Y5M2.team.vo.SearchTeamVO;
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

}
