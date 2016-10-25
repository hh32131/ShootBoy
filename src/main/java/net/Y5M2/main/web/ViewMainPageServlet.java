package net.Y5M2.main.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.Y5M2.article.biz.BoardBiz;
import net.Y5M2.article.biz.BoardBizImpl;
import net.Y5M2.article.vo.BoardVO;
import net.Y5M2.category.vo.CategoryVO;
import net.Y5M2.support.Param;

public class ViewMainPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private BoardBiz boardBiz;
	
	public ViewMainPageServlet() {
		super();
		boardBiz = new BoardBizImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				
		List<BoardVO> boards = boardBiz.getAllBoard();
		
		String viewPath = "/WEB-INF/view/main.jsp";
		request.setAttribute("boards", boards);
		RequestDispatcher rd = request.getRequestDispatcher(viewPath);
		rd.forward(request, response);
	}
}
