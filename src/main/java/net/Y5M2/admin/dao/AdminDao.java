package net.Y5M2.admin.dao;

import java.util.List;

import net.Y5M2.team.vo.SearchTeamVO;
import net.Y5M2.team.vo.TeamBoardVO;

public interface AdminDao {

	public List<TeamBoardVO> getAllTeamBoards(SearchTeamVO searchTeam, String teamId);

	public int getCountOfTeamBoard(SearchTeamVO searchTeam);

	public TeamBoardVO getTeamBoardAt(String teamBoardId);

	public int writeTeamBoard(TeamBoardVO teamBoardVO);

	public int deleteTeamBoard(String teamBoardId);

	public int modifyTeamBoard(TeamBoardVO teamBoardVO);

	public TeamBoardVO getTeamBoardForModify(String teamBoardId);

	public int getCountOfTeamBoards(String teamBoardId);

	public void hitCountUpdate(String teamBoardId);

}
