package com.user.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.bean.UserRight;
import com.user.service.IRightService;
import com.user.service.IUserService;
import com.user.service.impl.RightServiceImple;
import com.user.service.impl.UserServiceImpl;

@WebServlet(urlPatterns = "/user/add")
public class AddUserServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		IUserService iUserService = new UserServiceImpl();
		String username =req.getParameter("username");
		String password=req.getParameter("password");
		String sex=req.getParameter("sex");
		String right_id=req.getParameter("right_id");
		Date registDate = new Date();
		iUserService.regist(username, password, sex, registDate, Integer.valueOf(right_id));
		req.getRequestDispatcher("/user/showlist").forward(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	};
}
