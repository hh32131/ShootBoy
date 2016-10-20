package net.Y5M2.admin.biz;

import java.util.List;

import net.Y5M2.article.vo.BoardVO;
import net.Y5M2.team.vo.TeamVO;
import net.Y5M2.user.vo.UserVO;

public interface AdminBiz {

  public List<UserVO> getAllUser();
  
  public List<TeamVO> getAllTeams();

  public List<BoardVO> getAllBoard();
<<<<<<< HEAD

  public boolean deleteUser(String userId);
  
  public UserVO getUserOne(String userId);
  
=======
  
  public int getCountOfTeam(String teamId);
>>>>>>> 5978e8e2db6741fc5a7bd5d677ae919e69c37e91
}
