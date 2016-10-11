package net.Y5M2.user.biz;

import net.Y5M2.user.vo.UserVO;

public interface UserBiz {

	public boolean signUpUser(UserVO userVO);

	public boolean isExsist(String email);

}
