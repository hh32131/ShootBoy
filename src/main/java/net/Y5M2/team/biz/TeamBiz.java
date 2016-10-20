package net.Y5M2.team.biz;


import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import net.Y5M2.team.vo.SearchTeamVO;
import net.Y5M2.team.vo.TeamListVO;
import net.Y5M2.team.vo.TeamVO;
import net.Y5M2.user.vo.UserVO;

public interface TeamBiz {

	public boolean addTeam(TeamVO teamVO, UserVO userInfo, ServletRequest request);

	public TeamListVO getAllTeam(SearchTeamVO searchTeam);
	
	public TeamVO getTeamAt(String teamId);
	
	public String getFileNmaeOfTeamBy(String teamId);

	public boolean updateTeamInfo(TeamVO teamVO, ServletRequest request, UserVO userInfo );

	public String getFileNameOfTeam(String teamId);
	
	public boolean deleteTeam(String teamId, UserVO userVO, ServletRequest request);

	public boolean dropTeam(String teamId, UserVO userVO, HttpServletRequest request);
	
	public boolean isExsistTeam(String teamName);


}
