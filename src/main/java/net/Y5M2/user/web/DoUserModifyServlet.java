package net.Y5M2.user.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.Y5M2.support.Param;
import net.Y5M2.user.biz.UserBiz;
import net.Y5M2.user.biz.UserBizImpl;
import net.Y5M2.user.vo.UserVO;

public class DoUserModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserBiz userBiz;
	
	public DoUserModifyServlet() {
		super();
		userBiz = new UserBizImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = Param.getStringParam(request, "email");
		String userName = Param.getStringParam(request, "userName");
		String password = Param.getStringParam(request, "password");
		String phoneNumber = Param.getStringParam(request, "phoneNumber");
		String age = Param.getStringParam(request, "age");
		String position = Param.getStringParam(request, "position");
		String leafCategory = Param.getStringParam(request, "leafCategory");
		
		if(userName == null){
			response.sendRedirect("/ShootBoy/userModify?errorCode=2");
		}
		if(password == null){
			response.sendRedirect("/ShootBoy/userModify?errorCode=3");
		}
		if(phoneNumber == null){
			response.sendRedirect("/ShootBoy/userModify?errorCode=4");
		}
		
		
		
		UserVO userInfo = new UserVO();
		userInfo.setEmail(email);
		userInfo.setUserName(userName);
		userInfo.setPassword(password);
		userInfo.setPhoneNumber(phoneNumber);
		userInfo.setAge(age);
		userInfo.setPosition(position);
		userInfo.setLocationId(leafCategory);
		
		boolean isSuccess = userBiz.userInfoModify(userInfo, request);
		
		if(isSuccess){
			response.sendRedirect("/ShootBoy/detailUserInfo");
		}
		else{
			response.sendRedirect("/ShootBoy/userModify?errorCode=1");
		}
		
		
		
	}

}
