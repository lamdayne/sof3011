package com.poly.controller;

import java.util.Scanner;

import com.poly.dao.UserDAO;
import com.poly.dao.impl.UserDAOImpl;
import com.poly.models.User;

public class test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		User user = new User("lamdayne", "12345", "Nguyen Lam", "lamdayne@hotmail.com", true);
		User entity = new User("staff", "12345", "Nguyen Huy", "lamdayne@fpt.edu.vn", false);
		UserDAO userDao = new UserDAOImpl();
//		userDao.create(user);
//		userDao.create(entity);
//		userDao.update(user);
//		userDao.deleteById("lamdayne");
//		System.out.println(userDao.findAll().get(0).toString());
//		System.out.println(userDao.findAllByEmailAndRole("@fpt.edu.vn", false).get(0).toString());
//		System.out.println(userDao.findById("lamdayne").getEmail());
		for (User u : userDao.findByPageSize(1, 5)) {
			System.out.println(u.toString());
		}
	}
}
