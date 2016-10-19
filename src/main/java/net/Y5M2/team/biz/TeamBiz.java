package net.Y5M2.team.biz;

import java.util.List;

import javax.servlet.ServletRequest;

import net.Y5M2.team.vo.TeamVO;
import net.Y5M2.user.vo.UserVO;

public interface TeamBiz {

	public boolean addTeam(TeamVO teamVO, UserVO userInfo, ServletRequest request);

	public List<TeamVO> getAllTeam();
	
	public TeamVO getTeamAt(String teamId);
	
	public String getFileNmaeOfTeamBy(String teamId);

	public String getFileNameOfTeam(String teamId);

	public boolean updateTeamInfo(TeamVO teamVO);
	
	public boolean deleteTeam(String teamId);

}
