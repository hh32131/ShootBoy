package net.Y5M2.user.web.ajax;

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

public class DoCheckPasswordHint extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserBiz userBiz;
	
    public DoCheckPasswordHint() {
        super();
        userBiz = new UserBizImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String answer = Param.getStringParam(request, "answer");
		String email = Param.getStringParam(request, "email");
		UserVO userVO = new UserVO();
		userVO.setEmail(email);
		
		UserVO userInfo = userBiz.findPassword(userVO);
		
		PrintWriter out = response.getWriter();
		if(answer.equals(userInfo.getPasswordAnswer())){
			out.write(String.format( "비밀번호는 %s입니다.",userInfo.getPassword() ));
			out.flush();
			out.close();
		}
		else{
			out.write("답이 틀렸습니다.");
			out.flush();
			out.close();
		}
		
	}

}
