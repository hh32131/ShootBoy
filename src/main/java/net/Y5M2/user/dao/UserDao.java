package net.Y5M2.user.dao;

import net.Y5M2.user.vo.UserVO;

public interface UserDao {

	public int signUpUser(UserVO userVO);

<<<<<<< HEAD
	public int isExsist(String email);
=======
	public UserVO getUserBy(UserVO userVO);
>>>>>>> d448ce0edae533fd6ed89e0ec272981fa678b4f4

}
