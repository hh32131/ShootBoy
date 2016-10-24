package net.Y5M2.admin.web;

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
import net.Y5M2.category.biz.CategoryBiz;
import net.Y5M2.category.biz.CategoryBizImpl;
import net.Y5M2.category.vo.CategoryVO;
import net.Y5M2.support.Param;

public class ViewAdminArticleModifyPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BoardBiz boardBiz;
	private CategoryBiz biz;
	
	public ViewAdminArticleModifyPageServlet() {
		super();
		boardBiz = new BoardBizImpl();
		biz = new CategoryBizImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String boardId = Param.getStringParam(request, "boardId");
		BoardVO board = boardBiz.getBoardForModify(boardId);
		List<CategoryVO> category = biz.getAllCategoryList();
		
		String content = board.getBoardContent();
		content = content.replaceAll("<br/>", "\n");
		board.setBoardContent(content);
		
		String viewPath = "/WEB-INF/view/admin/adminArticleModify.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(viewPath);
		request.setAttribute("board", board);
		request.setAttribute("category", category);
		rd.forward(request, response);
		
	}

}
