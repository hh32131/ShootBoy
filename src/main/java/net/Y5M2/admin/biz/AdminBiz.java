package net.Y5M2.admin.biz;

import java.util.List;

import javax.servlet.ServletRequest;

import net.Y5M2.article.vo.BoardVO;
import net.Y5M2.team.vo.SearchTeamVO;
import net.Y5M2.team.vo.TeamBoardListVO;
import net.Y5M2.team.vo.TeamBoardVO;
import net.Y5M2.team.vo.TeamListVO;
import net.Y5M2.team.vo.TeamVO;
import net.Y5M2.user.vo.UserVO;

public interface AdminBiz {

	public List<UserVO> getAllUser();

	public List<TeamVO> getAllTeams();

	public List<BoardVO> getAllBoard();

	public boolean deleteUser(String userId);

	public UserVO getUserOne(String userId);

	public boolean userInfoModify(UserVO userInfo, ServletRequest request);

	public int getCountOfTeam(String teamId);

	public int getCountOfUsers();

	public int getCountOfBoards();

	public BoardVO getBoardOne(String boardId);
	
	

	public TeamBoardListVO getAllTeamBoards(SearchTeamVO searchTeam, String teamId);

	public int getCountOfTeamBoard(SearchTeamVO searchTeam);

	public TeamBoardVO getTeamBoardAt(String teamBoardId);

	public boolean writeTeamBoard(TeamBoardVO teamBoardVO);

	public boolean deleteTeamBoard(String teamBoardId);

	public boolean modifyTeamBoard(TeamBoardVO teamBoardVO);
	
	public TeamBoardVO getTeamBoardForModify(String teamBoardId);

	public String getFileNameOfTeamBoardBy(String teamBoardId);

	public int getCountOfTeamBoards(String teamBoardId);

}
