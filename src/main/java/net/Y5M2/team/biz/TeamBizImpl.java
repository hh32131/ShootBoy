package net.Y5M2.team.biz;

import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.Y5M2.constants.Session;
import net.Y5M2.team.dao.TeamDao;
import net.Y5M2.team.dao.TeamDaoImpl;
import net.Y5M2.team.vo.TeamVO;
import net.Y5M2.user.dao.UserDao;
import net.Y5M2.user.dao.UserDaoImpl;
import net.Y5M2.user.vo.UserVO;

public class TeamBizImpl implements TeamBiz {

	private TeamDao teamDao;
	private UserDao userDao;
	
	public TeamBizImpl() {
		teamDao = new TeamDaoImpl();
		userDao = new UserDaoImpl();
	}
	
	@Override
	public boolean addTeam(TeamVO teamVO, UserVO userInfo, ServletRequest request) {
		
		boolean isSuccess = userDao.UserTemaIdUpdate(teamVO, userInfo)>0;
		if(isSuccess) {
			HttpSession session = ((HttpServletRequest)request).getSession();
			session.removeAttribute(Session.USER_INFO);
			
			UserVO userVO = userDao.getUserBy(userInfo);
			session.setAttribute(Session.USER_INFO, userVO);
			
			return teamDao.addTeam(teamVO) > 0;
		}
		
		return false;
	}

	@Override
	public List<TeamVO> getAllTeam() {
		return teamDao.getAllTeam();
	}

	@Override
	public TeamVO getTeamAt(String teamId) {
		return teamDao.getTeamAt(teamId);
	}

	@Override
	public String getFileNmaeOfTeamBy(String teamId) {
		TeamVO team = teamDao.getTeamAt(teamId);
		return team.getTeamPhoto();
	}
	
}
