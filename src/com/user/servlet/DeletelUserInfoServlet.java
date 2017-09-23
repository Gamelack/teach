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

@WebServlet(urlPatterns = "/user/delete")
public class DeletelUserInfoServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		IUserService iUserService = new UserServiceImpl();
		String id  = req.getParameter("id");
		iUserService.deleteUserById(Integer.valueOf(id));
		//重新查询所有用户信息，然后跳转页面
		req.getRequestDispatcher("/user/showlist").forward(req, resp);
	}
}
