package net.Y5M2.match.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.Y5M2.match.web.CalendarHelper.CalDate;

public class ViewMatchApply extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ViewMatchApply() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CalDate nowYearAndMonth = CalendarHelper.getCalendarDate(2016, 2);
		int maxDate = CalendarHelper.getMaxDate(nowYearAndMonth);
		
		String viewPath = "/WEB-INF/view/match/matchApply.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(viewPath);
		request.setAttribute("nowYearAndMonth", nowYearAndMonth);
		request.setAttribute("maxDate", maxDate);
		rd.forward(request, response);	
	}

}
