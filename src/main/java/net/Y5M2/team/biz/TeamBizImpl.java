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
	
}
