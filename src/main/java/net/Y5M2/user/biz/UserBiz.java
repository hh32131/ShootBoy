package net.Y5M2.user.biz;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import net.Y5M2.user.vo.SearchUserVO;
import net.Y5M2.user.vo.UserListVO;
import net.Y5M2.user.vo.UserVO;

public interface UserBiz {

	public boolean signUpUser(UserVO userVO);


	public boolean isExsist(String email);
	
	public boolean getUserBy(UserVO userVO, HttpServletRequest request);

	public UserVO findPassword(UserVO userVO);
<<<<<<< HEAD
=======
	
>>>>>>> f2ae02d0b98d37ea5001dfc89aa05e71f2b2e643

	public boolean userInfoModify(UserVO userInfo, ServletRequest request);

<<<<<<< HEAD
	public boolean deleteUser(String userId);
=======
	
	public UserListVO getAllUsers(SearchUserVO searchUser);
>>>>>>> f2ae02d0b98d37ea5001dfc89aa05e71f2b2e643

}
