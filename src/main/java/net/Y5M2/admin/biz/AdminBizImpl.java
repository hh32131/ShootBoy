package net.Y5M2.admin.biz;

import java.util.List;

import net.Y5M2.user.dao.UserDao;
import net.Y5M2.user.dao.UserDaoImpl;
import net.Y5M2.user.vo.UserVO;

public class AdminBizImpl implements AdminBiz {
	
	private UserDao userDao;
	
	public AdminBizImpl() {
		userDao = new UserDaoImpl();
	}
	
	@Override
	public List<UserVO> getAllUser() {
		
		return userDao.getUserListOf();
	}
}
