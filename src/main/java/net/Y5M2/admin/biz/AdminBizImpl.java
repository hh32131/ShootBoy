package net.Y5M2.admin.biz;

<<<<<<< HEAD
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
=======
public class AdminBizImpl implements AdimBiz {

>>>>>>> 4bd2750d751a25eec6674f3b7966c0d7f850a8fe
}
