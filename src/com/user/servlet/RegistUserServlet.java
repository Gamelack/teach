package com.user.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.service.IUserService;
import com.user.service.impl.UserServiceImpl;

@WebServlet(urlPatterns="/user/regist")
public class RegistUserServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		IUserService iUserService = new UserServiceImpl();
		String username =req.getParameter("username");
		String password=req.getParameter("password");
		String sex=req.getParameter("sex");
//		String registDate1=req.getParameter("registDate");
		String right_id=req.getParameter("right_id");
//		Date registDate = toDate(registDate1);
		Date registDate = new Date();
		if(right_id==null){
			right_id="2";//青铜会员
		}
		iUserService.regist(username, password, sex, registDate, Integer.valueOf(right_id));
		resp.sendRedirect(req.getContextPath()+"/login.jsp");
		
	}
	private java.util.Date toDate(String date){
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
