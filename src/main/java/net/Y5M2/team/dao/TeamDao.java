package net.Y5M2.team.dao;

import java.util.List;

import net.Y5M2.team.vo.SearchTeamVO;
import net.Y5M2.team.vo.TeamBoardVO;
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
    

    public int hitCountUpdate(String teamBoardId);
    
    public List<TeamBoardVO> getAllTeamBoards(SearchTeamVO searchTeam, TeamBoardVO teamBoardVO);
    public TeamBoardVO getTeamBoardAt(String teamBoardId);
    public int addTeamBoard(TeamBoardVO teamBoardVO);
    
    
    public TeamVO getTeamInfoForUpdate(String teamName);

    public int updateTeamInfo(TeamVO teamVO);
    
    public int deleteTeam(String teamId);
    
    public int getCountOfTeams(SearchTeamVO searchTeam);
    
    public int getCountOfTeam(String teamId);
    
    public int isExsistTeam(String teamName);
    
    public int deleteTeamBoard(String teamBoardId);
    
    public int modifyTeamBoard(TeamBoardVO teamBoardVO);
    
    public TeamBoardVO getTeamBoardForModify(String teamBoardId);


    public int getCountOfTeamBoard(SearchTeamVO searchTeam);
    
    public int getCountOfTeamBoards(TeamBoardVO teamBoardVO);





    
}