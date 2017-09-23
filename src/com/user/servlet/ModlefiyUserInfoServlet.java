package com.user.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.bean.UserInfo;
import com.user.service.IUserService;
import com.user.service.impl.UserServiceImpl;

@WebServlet(urlPatterns = "/user/update")
public class ModlefiyUserInfoServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		IUserService iUserService = new UserServiceImpl();
		String id = req.getParameter("id");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String sex = req.getParameter("sex");
		String  registDate1 = req.getParameter("registDate");
		Date registDate = to_date(registDate1);
		String right_id = req.getParameter("right_id");
		iUserService.updateUserById(Integer.valueOf(id), username, password, sex, registDate, Integer.valueOf(right_id));
		req.getRequestDispatcher("/user/showlist").forward(req, resp);
	}
	private java.util.Date to_date(String date){
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return dateFormat.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
