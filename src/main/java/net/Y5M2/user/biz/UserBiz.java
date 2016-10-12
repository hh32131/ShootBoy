package net.Y5M2.user.biz;

import javax.servlet.http.HttpServletRequest;

import net.Y5M2.user.vo.UserVO;

public interface UserBiz {

	public boolean signUpUser(UserVO userVO);

<<<<<<< HEAD
	public boolean isExsist(String email);
=======
	public boolean getUserBy(UserVO userVO, HttpServletRequest request);
>>>>>>> d448ce0edae533fd6ed89e0ec272981fa678b4f4

}
