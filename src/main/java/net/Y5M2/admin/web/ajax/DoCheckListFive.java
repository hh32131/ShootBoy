package net.Y5M2.admin.web.ajax;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.Y5M2.constants.PageSelector;
import net.Y5M2.support.Param;

public class DoCheckListFive extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DoCheckListFive() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int articleValue = Param.getIntParam(request, "articleValue");

		PageSelector.BOARD_PAGE_SELECTOR = articleValue;
	}
}
