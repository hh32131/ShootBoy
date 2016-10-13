package net.Y5M2.team.biz;

import java.util.List;

import net.Y5M2.team.vo.TeamVO;

public interface TeamBiz {

	public boolean addTeam(TeamVO teamVO);

	public List<TeamVO> getAllTeam();
	
	public TeamVO getTeamAt(String teamId);
	
	public String getFileNmaeOfTeamBy(String teamId);

}
