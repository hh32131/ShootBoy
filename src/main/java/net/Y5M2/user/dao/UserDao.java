package net.Y5M2.user.dao;

import net.Y5M2.user.vo.UserVO;

public interface UserDao {

	public int signUpUser(UserVO userVO);

	public int isExsist(String email);
	public UserVO getUserBy(UserVO userVO);

}
