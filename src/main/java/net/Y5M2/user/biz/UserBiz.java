package net.Y5M2.user.biz;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import net.Y5M2.user.vo.UserVO;

public interface UserBiz {

	public boolean signUpUser(UserVO userVO);


	public boolean isExsist(String email);
	
	public boolean getUserBy(UserVO userVO, HttpServletRequest request);

	public UserVO findPassword(UserVO userVO);
<<<<<<< HEAD


	public boolean userInfoModify(UserVO userInfo, ServletRequest request);
=======
	
	public boolean userInfoModify(UserVO userInfo);
>>>>>>> 9b8888493957e4f1cc3743ff0b646ae9d4272ae3


}
