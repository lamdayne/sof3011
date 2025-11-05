package com.poly.dao.impl;

import java.util.List;

import com.poly.dao.UserDAO;
import com.poly.models.User;
import com.poly.utils.XJpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class UserDAOImpl implements UserDAO {
	EntityManager em = XJpa.getEntityManager();

	@Override
	public void create(User entity) {
		// TODO Auto-generated method stub
		try {
			em.getTransaction().begin();
			em.persist(entity);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
	}

	@Override
	public void update(User entity) {
		// TODO Auto-generated method stub
		entity.setFullName("Nguyen Huy");
		try {
			em.getTransaction().begin();
			em.merge(entity);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
	}

	@Override
	public void deleteById(String id) {
		// TODO Auto-generated method stub
		User user = em.find(User.class, id);
		try {
			em.getTransaction().begin();
			em.remove(user);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		String findAllSql = "SELECT u FROM User u";
		TypedQuery<User> tq = em.createQuery(findAllSql, User.class);
		List<User> list = tq.getResultList();
		return list;
	}

	@Override
	public User findById(String id) {
		// TODO Auto-generated method stub
		return em.find(User.class, id);
	}

	@Override
	public List<User> findAllByEmailAndRole(String email, Boolean role) {
		// TODO Auto-generated method stub
		String findAllByEmailAndRoleSql = "SELECT u FROM User u WHERE u.email LIKE :search AND u.admin = :role";
		TypedQuery<User> query = em.createQuery(findAllByEmailAndRoleSql, User.class)
				.setParameter("search", "%" + email).setParameter("role", role);
		return query.getResultList();
	}

	@Override
	public List<User> findByPageSize(int pageNumber, int pageSize) {
		// TODO Auto-generated method stub
		String findByPageSizeSql = "SELECT u FROM User u";
		TypedQuery<User> tq = em.createQuery(findByPageSizeSql, User.class).setFirstResult(pageNumber * pageSize)
				.setMaxResults(pageSize);
		return tq.getResultList();
	}

}
