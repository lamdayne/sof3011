package com.poly.dao;

import java.util.List;

import com.poly.models.User;

public interface UserDAO {
	void create(User entity);

	void update(User entity);

	void deleteById(String id);

	List<User> findAll();

	User findById(String id);

	List<User> findAllByEmailAndRole(String email, Boolean role);

	List<User> findByPageSize(int pageNumber, int pageSize);
}
