package com.poly.controller;

import java.io.IOException;
import java.util.List;

import com.poly.dao.UserDAO;
import com.poly.dao.impl.UserDAOImpl;
import com.poly.models.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet({ "/user/index" })
public class UserController extends HttpServlet {
	UserDAO userDao = new UserDAOImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<User> list = userDao.findAll();
		req.setAttribute("items", list);
		req.getRequestDispatcher("/views/list-user.jsp").forward(req, resp);
	}
}
