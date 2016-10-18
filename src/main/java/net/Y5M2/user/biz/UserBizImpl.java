package net.Y5M2.user.biz;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.Y5M2.constants.Session;
import net.Y5M2.support.pager.Pager;
import net.Y5M2.support.pager.PagerFactory;
import net.Y5M2.user.dao.UserDao;
import net.Y5M2.user.dao.UserDaoImpl;
import net.Y5M2.user.vo.SearchUserVO;
import net.Y5M2.user.vo.UserListVO;
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
	public boolean userInfoModify(UserVO userInfo) {
		
		return false;
	}

	@Override
	public UserListVO getAllUsers(SearchUserVO searchUser) {
		
		int totalCount = userDao.getCountOfUsers(searchUser);
		Pager pager = PagerFactory.getPager(true);
		pager.setTotalArticleCount(totalCount);
		pager.setPageNumber(searchUser.getPageNo());
		
		searchUser.setStartRowNumber(pager.getStartArticleNumber());
		searchUser.setEndRowNumber(pager.getEndArticleNumber());
		
		List<UserVO> users = userDao.getAllUsers(searchUser);
		
		UserListVO userList = new UserListVO();
		userList.setPager(pager);
		userList.setUsers(users);
		
		return userList;
	}
	
}
