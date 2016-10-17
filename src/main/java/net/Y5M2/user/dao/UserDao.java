package net.Y5M2.user.dao;

<<<<<<< HEAD
import net.Y5M2.team.vo.TeamVO;
=======
import java.util.List;

>>>>>>> 9b8888493957e4f1cc3743ff0b646ae9d4272ae3
import net.Y5M2.user.vo.UserVO;

public interface UserDao {

	public int signUpUser(UserVO userVO);

	public int isExsist(String email);
	
	public UserVO getUserBy(UserVO userVO);

	public UserVO findPassword(UserVO userVO);
	
	public List<UserVO> getUserListOf();

	public int UpdateUserInfo(UserVO userInfo);

	public UserVO getUserInfoForModify(UserVO userInfo);

	public int UserTemaIdUpdate(TeamVO teamVO, UserVO userInfo);


}
