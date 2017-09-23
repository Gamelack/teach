package com.user.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.bean.UserInfo;
import com.user.bean.UserRight;
import com.user.service.IRightService;
import com.user.service.IUserService;
import com.user.service.impl.RightServiceImple;
import com.user.service.impl.UserServiceImpl;

@WebServlet(urlPatterns = "/user/beforeUpdate")
public class BeforeModlefiyUserInfoServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		IUserService iUserService = new UserServiceImpl();
		IRightService iRightService = new RightServiceImple();
		//所有的权限列表
		List<UserRight> list = iRightService.getAllRightList();
		String id = req.getParameter("id");
		IUserService iu = new UserServiceImpl();
		UserInfo userInfo = iu.getUserById(Integer.valueOf(id));
		req.setAttribute("userinfo", userInfo);
		req.setAttribute("allright", list);
		req.getRequestDispatcher("/WEB-INF/usermanager/modifyUser.jsp").forward(req, resp);
	}
	
}
