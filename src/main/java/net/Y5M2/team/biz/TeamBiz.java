package net.Y5M2.team.biz;


import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import net.Y5M2.article.vo.BoardVO;
import net.Y5M2.team.vo.SearchTeamVO;
import net.Y5M2.team.vo.TeamBoardListVO;
import net.Y5M2.team.vo.TeamBoardVO;
import net.Y5M2.team.vo.TeamListVO;
import net.Y5M2.team.vo.TeamVO;
import net.Y5M2.user.vo.UserVO;

public interface TeamBiz {

	public boolean addTeam(TeamVO teamVO, UserVO userInfo, ServletRequest request);
	
	public boolean addTeamBoard(TeamBoardVO teamBoardVO);

	public TeamListVO getAllTeam(SearchTeamVO searchTeam);
	
	public TeamBoardVO getTeamBoardAt(String teamBoardId);

	
	
	public TeamBoardListVO getAllTeamBoards(SearchTeamVO searchTeam, TeamBoardVO teamBoardVO);
	
	
	public TeamVO getTeamAt(String teamId);
	
	public String getFileNmaeOfTeamBy(String teamId);

	public boolean updateTeamInfo(TeamVO teamVO, ServletRequest request, UserVO userInfo );

	public String getFileNameOfTeam(String teamId);
	
	public boolean deleteTeam(String teamId, UserVO userVO, ServletRequest request);

	public boolean dropTeam(String teamId, UserVO userVO, HttpServletRequest request);
	
	public boolean deleteTeam(String teamId);
	
	public int getCountOfTeam(String teamId);
	
	public boolean isExsistTeam(String teamName);
	
	public boolean deleteTeamBoard(String teamBoardId);
	
	public boolean modifyTeamBoard(TeamBoardVO teamBoardVO);
	
	public TeamBoardVO getTeamBoardForModify(String teamBoardId);
	
	public String getFileNameOfTeamBoardBy(String teamBoardId);





}
