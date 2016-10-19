package net.Y5M2.team.dao;

import java.util.List;

import net.Y5M2.team.vo.SearchTeamVO;
import net.Y5M2.team.vo.TeamVO;

public interface TeamDao {

	public int addTeam(TeamVO teamVO);
	
	
	/**
	 * 서치하기위한 유저용  
	 */
	public List<TeamVO> getAllTeam(SearchTeamVO searchTeam);
	
	/**
	 * admin 용
	 */
	public List<TeamVO> getAllTeams();
	
	
	public TeamVO getTeamAt(String teamId);

	public TeamVO getTeamInfoForUpdate(String teamName);

	public int updateTeamInfo(TeamVO teamVO);
	
	public int deleteTeam(String teamId);
	
	public int getCountOfTeams(SearchTeamVO searchTeam);
	
}
