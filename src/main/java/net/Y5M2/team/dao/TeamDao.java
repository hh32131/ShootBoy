package net.Y5M2.team.dao;

import java.util.List;

import net.Y5M2.team.vo.TeamVO;

public interface TeamDao {

	public int addTeam(TeamVO teamVO);
	
	public List<TeamVO> getAllTeam();
	
}
