package net.Y5M2.admin.biz;

import java.util.List;

import javax.servlet.ServletRequest;

import net.Y5M2.article.vo.BoardVO;
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
  
  public int getCountOfUsers(String userId);
  
  public int getCountOfBoards(String boardId);
  
  public BoardVO getBoardOne(String boardId);
}
