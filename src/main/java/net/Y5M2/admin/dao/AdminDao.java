package net.Y5M2.admin.dao;

import java.util.List;

import net.Y5M2.team.vo.SearchTeamVO;
import net.Y5M2.team.vo.TeamBoardVO;

public interface AdminDao {

	List<TeamBoardVO> getAllTeamBoards(SearchTeamVO searchTeam, TeamBoardVO teamBoardVO);

}
