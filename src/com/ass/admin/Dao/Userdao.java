package com.ass.admin.Dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import com.ass.model.User;

public class Userdao extends AbtractEntityDao<User> {

	public Userdao() {
		super(User.class);
		
	}
			
	public void changePassword(String username, String oldPassword, String newPassword)
	throws Exception{
		EntityManager em = JpaUtils.geteEntityManager();
		
		EntityTransaction trans= em.getTransaction();
		
		String jpql="select u from User u where u.username = :username  and u.password = :password";
		
		try {
			trans.begin();
			
			TypedQuery<User> query = em.createQuery(jpql,User.class);
			query.setParameter("username", username);
			query.setParameter("password", oldPassword);
			
			User user = query.getSingleResult();
			if(user==null) {
				throw new Exception(" Current passwrord or user name are incorrect!");
				
				
			}
			user.setPassword(newPassword);
			em.merge(user);
			
			
			trans.commit();
			
			
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			throw e;
		}finally {
			em.close();
		}
	}
	
	public User findByUsernameAndMail(String username,String email) {
		EntityManager em = JpaUtils.geteEntityManager();
		
		String jpql= "select u from User u where u.username=:username and u.email=:email";
		
		
		try {
			TypedQuery<User> query= em.createQuery(jpql,User.class);
			query.setParameter("username",username);
			query.setParameter("email",email);
			
			return query.getSingleResult();
			
		} finally {
			em.close();
		}
	}
}
