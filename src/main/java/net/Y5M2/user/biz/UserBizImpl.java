package net.Y5M2.user.biz;

import javax.servlet.ServletRequest;
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
	public boolean isExsist(String email) {
		
		return userDao.isExsist(email) > 0;
	}
	public boolean getUserBy(UserVO userVO, HttpServletRequest request) {

		HttpSession session = request.getSession();
		UserVO userInfo = userDao.getUserBy(userVO);
		if(userInfo != null){
			session.setAttribute(Session.USER_INFO, userInfo);
			return true;
		}
		
		return false;
	}
	
	@Override
	public UserVO findPassword(UserVO userVO) {
		
		return userDao.findPassword(userVO);
	}

	
	@Override
	public boolean userInfoModify(UserVO userInfo, ServletRequest request) {
		UserVO originalUserInfo = userDao.getUserInfoForModify(userInfo);
		
		int modiUserCount = 6;
		if(originalUserInfo.getPassword().equals(userInfo.getPassword())){
			userInfo.setPassword(null);
			modiUserCount--;
		}
		if(originalUserInfo.getUserName().equals(userInfo.getUserName())){
			userInfo.setUserName(null);
			modiUserCount--;
		}
		if(originalUserInfo.getPhoneNumber().equals(userInfo.getPhoneNumber())){
			userInfo.setPhoneNumber(null);
			modiUserCount--;
		}
		if(originalUserInfo.getAge().equals(userInfo.getAge())){
			userInfo.setAge(null);
			modiUserCount--;
		}
		if(originalUserInfo.getPosition().equals(userInfo.getPosition())){
			userInfo.setPosition(null);
			modiUserCount--;
		}
		if(originalUserInfo.getLocationId().equals(userInfo.getLocationId())){
			userInfo.setLocationId(null);
			modiUserCount--;
		}
		if(modiUserCount==0){
			return true;
		}
		boolean isSuccess = userDao.UpdateUserInfo(userInfo)>0;
		if(isSuccess){
			HttpSession session = ((HttpServletRequest)request).getSession();
			session.removeAttribute(Session.USER_INFO);
			UserVO UserVO = userDao.getUserInfoForModify(userInfo);
			session.setAttribute(Session.USER_INFO, UserVO);
			
			return true;
		}
		else{
			return false;
		}
		
		/*return userDao.UpdateUserInfo(userInfo)>0;*/
	}

	@Override
	public boolean deleteUser(String userId) {
		return userDao.deleteUser(userId) > 0;
	}
	
}
