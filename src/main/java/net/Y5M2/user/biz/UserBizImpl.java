package net.Y5M2.user.biz;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.Y5M2.constants.Session;
import net.Y5M2.user.dao.UserDao;
import net.Y5M2.user.dao.UserDaoImpl;
import net.Y5M2.user.vo.UserVO;

public class UserBizImpl implements UserBiz {

	private UserDao userDao;
	
	public UserBizImpl() {
		userDao = new UserDaoImpl();
	}
	
	@Override
	public boolean signUpUser(UserVO userVO) {
		
		return userDao.signUpUser(userVO)>0;
	}
	
	@Override
<<<<<<< HEAD
	public boolean isExsist(String email) {
		
		return userDao.isExsist(email) > 0;
=======
	public boolean getUserBy(UserVO userVO, HttpServletRequest request) {

		HttpSession session = request.getSession();
		UserVO userInfo = userDao.getUserBy(userVO);
		if(userInfo != null){
			session.setAttribute(Session.USER_INFO, userInfo);
			return true;
		}
		
		return false;
>>>>>>> d448ce0edae533fd6ed89e0ec272981fa678b4f4
	}
}
