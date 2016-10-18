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

<<<<<<< HEAD
	public int UpdateUserInfo(UserVO userInfo);

	public UserVO getUserInfoForModify(UserVO userInfo);

	public int UserTemaIdUpdate(TeamVO teamVO, UserVO userInfo);

	public int deleteUser(String userId);

=======
	public List<UserVO> getAllUsers(SearchUserVO searchUser);

	public int getCountOfUsers(SearchUserVO searchUser);
>>>>>>> f2ae02d0b98d37ea5001dfc89aa05e71f2b2e643

}
