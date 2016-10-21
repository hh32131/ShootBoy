package net.Y5M2.admin.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.Y5M2.article.biz.BoardBiz;
import net.Y5M2.article.biz.BoardBizImpl;

public class DoDeleteArticleAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private BoardBiz boardBiz;
	
    public DoDeleteArticleAdminServlet() {
        super();
        boardBiz = new BoardBizImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  String[] checkbox = request.getParameterValues("select-check");
	        
	        PrintWriter out = response.getWriter();
	        
	        if(checkbox==null || checkbox.length == 0) {
	            out.print("다시선택하세요. ");
	            return;
	        }
	        else {
	            for(int i=0; i < checkbox.length; i++){
	                boardBiz.deleteBoard(checkbox[i]);
	            }
	            out.print("삭제했습니다. ");
	        }
	        
	        out.flush();
	        out.close();
	    }
}
