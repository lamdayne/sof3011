package com.poly.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import com.poly.dao.UserDAO;
import com.poly.dao.impl.UserDAOImpl;
import com.poly.models.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet({ "/user/index", "/user/showUser", "/user/edit/*", "/user/update", "/user/delete", "/user/create",
		"/user/reset" })
public class UserController extends HttpServlet {
	UserDAO userDao = new UserDAOImpl();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User entity = new User();
		try {
			BeanUtils.populate(entity, req.getParameterMap());
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<User> list = userDao.findAll();
		String path = req.getServletPath();
		String message = "Input information user";
		List<User> pageList = null;
		int pageSize = 5;
		int totalPage = list.size() / pageSize + (list.size() % pageSize == 0 ? 0 : 1);
		int currentPage = 0;
		pageList = userDao.findByPageSize(0, pageSize);
		if (path.contains("/user/index")) {
			String page = req.getParameter("page");
			if (page != null) {
				currentPage = Integer.parseInt(page) - 1;
				pageList = userDao.findByPageSize(currentPage, pageSize);
			}
//			req.getRequestDispatcher("/views/user.jsp").forward(req, resp);
		} else if (path.contains("/user/showUser")) {
			req.setAttribute("items", list);
			req.getRequestDispatcher("/views/list-user.jsp").forward(req, resp);
		} else if (path.contains("edit")) {
			String id = req.getPathInfo().substring(1);
			entity = userDao.findById(id);
			message = "Edit user " + entity.getId();
		} else if (path.contains("update")) {
			message = "Update user " + entity.getId();
			userDao.update(entity);
			entity = new User();
			resp.sendRedirect(req.getContextPath() + "/user/index");
			return;
		} else if (path.contains("delete")) {
			userDao.deleteById(entity.getId());
			entity = new User();
			resp.sendRedirect(req.getContextPath() + "/user/index");
			return;
		} else if (path.contains("create")) {
			userDao.create(entity);
			entity = new User();
			resp.sendRedirect(req.getContextPath() + "/user/index");
			return;
		} else if (path.contains("reset")) {
			entity = new User();
		}
		req.setAttribute("currentPage", currentPage + 1);
		req.setAttribute("totalPage", totalPage);
		req.setAttribute("message", message);
		req.setAttribute("pageList", pageList);
		req.setAttribute("user", entity);
		req.getRequestDispatcher("/views/user/form-user.jsp").forward(req, resp);
	}
}
