package net.Y5M2.user.dao;

import net.Y5M2.team.vo.TeamVO;
import java.util.List;

import net.Y5M2.user.vo.SearchUserVO;
import net.Y5M2.user.vo.UserVO;

public interface UserDao {

	public int signUpUser(UserVO userVO);

	public int isExsist(String email);
	
	public UserVO getUserBy(UserVO userVO);

	public UserVO findPassword(UserVO userVO);
	
	public List<UserVO> getUserListOf();

	public int UpdateUserInfo(UserVO userInfo);

	public UserVO getUserInfoForModify(UserVO userInfo);

	public int UserTemaIdUpdate(String teamId, String userId);

	public int deleteUser(UserVO userVO);

	public List<UserVO> getAllUsers(SearchUserVO searchUser);

	public int getCountOfUsers(SearchUserVO searchUser);

	public int UserTemaIdDelete(String teamId);

	public int adminPageDeleteUser(String userId);

	public UserVO getUserOne(String userId);

<<<<<<< HEAD
<<<<<<< HEAD
=======
	public int getCountOfUsers();
=======
>>>>>>> dfa539019c4406e8296db3bbf8ff1c6ebfa3aa54
	public int deleteUserTwo(String userId);

	public int UserTeamIdDrop(String teamId, UserVO userVO);
	
<<<<<<< HEAD
=======
	public int getCountOfUsers();
>>>>>>> 09ad50b9ad28d50d4844e1de251d43e95057b0f5
=======
>>>>>>> e1fec08353118a70614c18f93f23ae3824311cc5
>>>>>>> dfa539019c4406e8296db3bbf8ff1c6ebfa3aa54
}
