package net.Y5M2.category.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.Y5M2.category.biz.CategoryBiz;
import net.Y5M2.category.biz.CategoryBizImpl;
import net.Y5M2.category.vo.CategoryVO;
import net.Y5M2.support.Param;

public class ViewCategoryListPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private CategoryBiz categoryBiz;
	public ViewCategoryListPageServlet() {
		super();
		categoryBiz = new CategoryBizImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String parentCategoryId = Param.getStringParam(request, "parentCategoryId");
		String categoryId = Param.getStringParam(request, "categoryId");
	
		String veiwPath = "/WEB-INF/view/board/write.jsp";
		
		List<CategoryVO> categories = null;
		
		RequestDispatcher rd = request.getRequestDispatcher(veiwPath);
		
		request.setAttribute("categories", categories);
		rd.forward(request, response);
		
		boolean isLeafNode = categoryBiz.isCategoryLeafNode(categoryId);
		if ( isLeafNode ) {
			categories = categoryBiz.getCategoryList(parentCategoryId);
		}
		else {
			categories = categoryBiz.getCategoryList(categoryId);
		}
	}

}
