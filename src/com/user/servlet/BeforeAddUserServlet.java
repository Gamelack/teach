package com.user.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.bean.UserRight;
import com.user.service.IRightService;
import com.user.service.impl.RightServiceImple;

@WebServlet(urlPatterns = "/user/beforeAdd")
public class BeforeAddUserServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		IRightService iRightService = new RightServiceImple();
		List<UserRight> list = iRightService.getAllRightList();
		req.setAttribute("allRight", list);
		req.getRequestDispatcher("/WEB-INF/usermanager/addUser.jsp").forward(req, resp);;
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	};
}
