package com.user.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.bean.UserInfo;
import com.user.service.IUserService;
import com.user.service.impl.UserServiceImpl;

@WebServlet(urlPatterns = "/user/showlist")
public class ShowAllUserInfoServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		IUserService iUserService = new UserServiceImpl();
		List<UserInfo> infos = iUserService.getAllUserInfo();
		req.setAttribute("list", infos);
		req.getRequestDispatcher("/WEB-INF/usermanager/listUser.jsp").forward(req, resp);
	}
}
