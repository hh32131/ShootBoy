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
		
		
		boolean isSuccess =  teamDao.addTeam(teamVO)>0;
		
		
		if(isSuccess) {
			TeamVO teamInfo = teamDao.getTeamInfoForUpdate(teamVO.getTeamName());
			boolean isUpdateSuccess = userDao.UserTemaIdUpdate(teamInfo, userInfo)>0;
			if(isUpdateSuccess){
				HttpSession session = ((HttpServletRequest)request).getSession();
				session.removeAttribute(Session.USER_INFO);
				UserVO userVO = userDao.getUserBy(userInfo);
				session.setAttribute(Session.USER_INFO, userVO);
				return true;
			}
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
	
	@Override
	public String getFileNameOfTeam(String teamId) {
		TeamVO teamInfo = teamDao.getTeamAt(teamId);
		return teamInfo.getTeamPhoto();
	}
	@Override
	public boolean updateTeamInfo(TeamVO teamVO, ServletRequest request, UserVO userInfo) {
		TeamVO originalTeamInfo = teamDao.getTeamAt(teamVO.getTeamId());
		
		int teamModify = 5;
		
		if(originalTeamInfo.getTeamName().equals(teamVO.getTeamName())){
			teamVO.setTeamName(null);
			teamModify--;
		}
		if(originalTeamInfo.getTeamCount()==teamVO.getTeamCount()){
			teamVO.setTeamCount(0);
			teamModify--;
		}
		if(originalTeamInfo.getLocationId().equals(teamVO.getLocationId())){
			teamVO.setLocationId(null);
			teamModify--;
		}
		if(originalTeamInfo.getTeamInfo().equals(teamVO.getTeamInfo())){
			teamVO.setTeamInfo(null);
			teamModify--;
		}
		if(originalTeamInfo.getTeamPhoto()==null){
			originalTeamInfo.setTeamPhoto("");
		}
		if(originalTeamInfo.getTeamPhoto().equals(teamVO.getTeamPhoto())){
			teamVO.setTeamPhoto(null);
			teamModify--;
		}
		if(teamModify==0){
			return true;
		}
		boolean isSuccess = teamDao.updateTeamInfo(teamVO) > 0;
		if(isSuccess){
			HttpSession session = ((HttpServletRequest)request).getSession();
			session.removeAttribute(Session.USER_INFO);
			UserVO UserVO = userDao.getUserInfoForModify(userInfo);
			session.setAttribute(Session.USER_INFO, UserVO);
			
			return true;
		}
		else{
			return false;
			
		}
	}
}
