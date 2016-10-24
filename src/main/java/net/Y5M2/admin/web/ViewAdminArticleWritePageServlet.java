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
<<<<<<< HEAD

=======
	
>>>>>>> e73764ea7a70014e2107664083f2144c4fdf9228
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
<<<<<<< HEAD

		List<CategoryVO> category = biz.getAllCategoryList();

		String viewPath = "/WEB-INF/view/admin/adminArticleWrite.jsp";

		RequestDispatcher rd = request.getRequestDispatcher(viewPath);

		request.setAttribute("category", category);

=======
		
		List<CategoryVO> category = biz.getAllCategoryList();
		
		String viewPath = "/WEB-INF/view/admin/adminArticleWrite.jsp";
		
		RequestDispatcher rd = request.getRequestDispatcher(viewPath);
		
		request.setAttribute("category", category);
		
>>>>>>> e73764ea7a70014e2107664083f2144c4fdf9228
		rd.forward(request, response);
	}

}