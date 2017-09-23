package com.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.bean.UserInfo;
import com.user.service.IUserService;
import com.user.service.impl.UserServiceImpl;

@WebServlet(urlPatterns="/user/login")
public class LoginUserServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		IUserService iUserService = new UserServiceImpl();
		UserInfo userinfo  = iUserService.login(username, password);
		if(userinfo!=null){
			req.getSession().setAttribute("userinfo", userinfo);
			//跳转到主页
			req.setAttribute("loginMSG", username+"登录成功");
			//重新查询所有用户信息，然后跳转页面
			req.getRequestDispatcher("/user/showlist").forward(req, resp);
		}else{
			//重新登录
			req.setAttribute("loginMSG", "登录失败，用户名密码错误");
			req.getRequestDispatcher("/login.jsp").forward(req, resp);
		}
	}
}
