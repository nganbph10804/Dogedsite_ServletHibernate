package com.ass.admin.Dao;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class JpaUtils {
 public static EntityManager geteEntityManager() {
	 return Persistence.createEntityManagerFactory("DogedSite").createEntityManager();
 }
}
