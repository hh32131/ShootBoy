package net.Y5M2.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.Y5M2.constants.Session;
import net.Y5M2.user.vo.UserVO;

public class AdminFilter implements Filter {

    public AdminFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpSession session = ((HttpServletRequest)request).getSession();
		UserVO userVO = (UserVO) session.getAttribute(Session.USER_INFO);
		if(!userVO.getLevelId().equals("1")){
			PrintWriter out = response.getWriter();
			out.append("<script type='text/javascript'> alert('관리자용 페이지입니다.'); ");
			out.append("location.href='/ShootBoy/main'; ");
			out.append("</script>");
			out.flush();
			out.close();
			
		}
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
