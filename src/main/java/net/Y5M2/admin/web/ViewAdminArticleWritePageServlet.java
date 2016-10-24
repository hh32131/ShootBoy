package net.Y5M2.admin.web;

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

public class ViewAdminArticleWritePageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CategoryBiz biz;
	
	public ViewAdminArticleWritePageServlet() {
		super();
		biz = new CategoryBizImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<CategoryVO> category = biz.getAllCategoryList();
		
		String viewPath = "/WEB-INF/view/admin/adminArticleWrite.jsp";
		
		RequestDispatcher rd = request.getRequestDispatcher(viewPath);
		
		request.setAttribute("category", category);
		
		rd.forward(request, response);
	}

}
