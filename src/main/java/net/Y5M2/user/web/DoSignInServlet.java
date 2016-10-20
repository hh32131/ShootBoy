package net.Y5M2.user.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.Y5M2.support.Param;
import net.Y5M2.user.biz.UserBiz;
import net.Y5M2.user.biz.UserBizImpl;
import net.Y5M2.user.vo.UserVO;

public class DoSignInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserBiz userBiz;
	
	public DoSignInServlet() {
		super();
		userBiz = new UserBizImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String userEmail = Param.getStringParam(request, "userEmail");
		String password = Param.getStringParam(request, "password");
		String Referer = Param.getStringParam(request, "Referer");
		
		if(userEmail==null){
			response.sendRedirect("/ShootBoy/signIn?errorCode=2");
		}
		if(password==null){
			response.sendRedirect("/ShootBoy/signIn?errorCode=2");
		}
		PrintWriter out = response.getWriter();
		UserVO userVO = new UserVO();
		userVO.setEmail(userEmail);
		userVO.setPassword(password);
		
		boolean isSuccess = userBiz.getUserBy(userVO, request);
		if(isSuccess){
			if(Referer.equals("")){
				out.write("<script type='text/javascript'>location.href='/ShootBoy/main'</script>");
				out.flush();
				out.close();
				/*response.sendRedirect("/ShootBoy/main");*/
			}
			
			else {
				out.write(String.format("<script type='text/javascript'>location.href='%s'</script>", Referer));
				out.flush();
				out.close();
				/*response.sendRedirect(Referer);*/
			}
		}
		else{
			
			out.write("<script type='text/javascript'> alert('비밀번호가 틀렸습니다.') ");
			out.write("</script>");
			out.flush();
			out.close();
			
		}
	}

}
