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

public class DoSignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserBiz userBiz;
	
	
	public DoSignUpServlet() {
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
		String password1 = Param.getStringParam(request, "password1");
		String password2 = Param.getStringParam(request, "password2");
		String passwordHintKey = Param.getStringParam(request, "passwordHintKey");
		String passwordHintValue = Param.getStringParam(request, "passwordHintValue");
		String phoneNumber= Param.getStringParam(request, "phoneNumber");
		String age = Param.getStringParam(request, "age");
		String position = Param.getStringParam(request, "position");
		String leafCategory = Param.getStringParam(request, "leafCategory");
		
		
		if (email == null) {
			response.sendRedirect("/ShootBoy/signUp?errorCode=2");
			return;
		}
		if (userName == null) {
			response.sendRedirect("/ShootBoy/signUp?errorCode=3");
			return;
		}
		if (password1 == null) {
			response.sendRedirect("/ShootBoy/signUp?errorCode=4");
			return;
		}
		if (password2 == null) {
			response.sendRedirect("/ShootBoy/signUp?errorCode=5");
			return;
		}
		if (passwordHintKey == null) {
			response.sendRedirect("/ShootBoy/signUp?errorCode=6");
			return;
		}
		if (passwordHintValue == null) {
			response.sendRedirect("/ShootBoy/signUp?errorCode=7");
			return;
		}
		if (phoneNumber == null) {
			response.sendRedirect("/ShootBoy/signUp?errorCode=8");
			return;
		}
		if (age == null) {
			response.sendRedirect("/ShootBoy/signUp?errorCode=9");
			return;
		}
		if (position == null) {
			response.sendRedirect("/ShootBoy/signUp?errorCode=10");
			return;
		}
		if(leafCategory==null){
			response.sendRedirect("/ShootBoy/signUp?errorCode=11");
			return;
		}
		
		if (!password1.equals(password2)) {
			response.sendRedirect("/ShootBoy/signUp?errorCode=12");
			return;
		}
		
		
		
		UserVO userVO = new UserVO();
		userVO.setEmail(email);
		userVO.setUserName(userName);
		userVO.setPassword(password1);
		userVO.setPasswordHint(passwordHintKey);
		userVO.setPasswordAnswer(passwordHintValue);
		userVO.setPhoneNumber(phoneNumber);
		userVO.setAge(age);
		userVO.setPosition(position);
		userVO.setLocationId(leafCategory);
		
		boolean isSuccess = userBiz.signUpUser(userVO);
		
		if(isSuccess){
			response.sendRedirect("/ShootBoy/main");
		}
		else{
			response.sendRedirect("/ShootBoy/signUp?errorCode=1");
		}

	}

}
