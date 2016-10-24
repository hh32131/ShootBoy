package net.Y5M2.team.biz;

import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;



import net.Y5M2.constants.Session;
import net.Y5M2.support.pager.Pager;
import net.Y5M2.support.pager.PagerFactory;
import net.Y5M2.team.dao.TeamDao;
import net.Y5M2.team.dao.TeamDaoImpl;
import net.Y5M2.team.vo.SearchTeamVO;
import net.Y5M2.team.vo.TeamListVO;
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
			
			boolean isUpdateSuccess = userDao.UserTemaIdUpdate(teamInfo.getTeamId(), userInfo.getUserId())>0;
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
	public TeamListVO getAllTeam(SearchTeamVO searchTeam) {
		
		int totalCount = teamDao.getCountOfTeams(searchTeam);
		Pager pager = PagerFactory.getPager(true, 20, 5);
		pager.setTotalArticleCount(totalCount);
		pager.setPageNumber(searchTeam.getPageNo());
		
		
		searchTeam.setStartRowNumber(pager.getStartArticleNumber());
		searchTeam.setEndRowNumber(pager.getEndArticleNumber());
		
		List<TeamVO> teams = teamDao.getAllTeam(searchTeam);
		
		TeamListVO teamList = new TeamListVO();
		teamList.setPager(pager);
		teamList.setTeams(teams);;
		
		return teamList;
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

	@Override
	public boolean deleteTeam(String teamId,UserVO userVO, ServletRequest request) {

		boolean isSuccess = userDao.UserTemaIdDelete(teamId)>0;
		if(isSuccess){
			HttpSession session = ((HttpServletRequest)request).getSession();
			session.removeAttribute(Session.USER_INFO);
			UserVO userInfo = userDao.getUserBy(userVO);
			session.setAttribute(Session.USER_INFO, userInfo);
			return teamDao.deleteTeam(teamId) > 0;
		}
		
		return false;
	}
	
	@Override
	public boolean dropTeam(String teamId, UserVO userVO, HttpServletRequest request) {
		
		boolean isSuccess = userDao.UserTeamIdDrop(teamId, userVO)>0;
		
		if(isSuccess){
			HttpSession session = ((HttpServletRequest)request).getSession();
			session.removeAttribute(Session.USER_INFO);
			UserVO userInfo = userDao.getUserBy(userVO);
			session.setAttribute(Session.USER_INFO, userInfo);
			return true;
		}
		
		return false;
	}

	@Override
	public boolean isExsistTeam(String teamName) {
		return teamDao.isExsistTeam(teamName) > 0;
	}

	@Override
	public int getCountOfTeam(String teamId) {
		return teamDao.getCountOfTeam(teamId);
	}

	@Override
	public boolean deleteTeam(String teamId) {
		return teamDao.deleteTeam(teamId) > 0;
	}

}
