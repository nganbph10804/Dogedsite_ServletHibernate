package com.ass.admin.Dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.ass.admin.domain.FavoriteReport;
import com.ass.admin.domain.FavoriteUserReport;
import com.ass.model.Order;

public  class Orderdao extends AbtractEntityDao<Order>{
		
		
					public Orderdao() {
						super(Order.class); 
					}
					public List<FavoriteUserReport> reportFavoriteUserByVideo(String videoId){
						String jpql="select new com.ass.admin.domain.FavoriteUserReport(f.user.username, f.user.fullname,"
									+"f.user.email,f.likedDate) from Favorite f where f.video.videoId = :videoId";
						EntityManager em = JpaUtils.geteEntityManager();
						
						List<FavoriteUserReport> list= null;
						try {
							TypedQuery<FavoriteUserReport> query= em.createQuery(jpql, FavoriteUserReport.class);
							
							query.setParameter("videoId",videoId);
							list= query.getResultList();
						}finally {
							em.close();
						}
						return list;
					}
					
					public List<FavoriteReport> reportFavoritesByVideos(){
						String jpql= "select new com.ass.admin.domain.FavoriteReport(f.video.title,count(f),min(f.likedDate),max(f.likedDate))"
								+"from Favorite f group by f.video.title";
						
						EntityManager em = JpaUtils.geteEntityManager();
						
						List<FavoriteReport> list=null;
						try {
							TypedQuery<FavoriteReport> query= em.createQuery(jpql,FavoriteReport.class);
							list=query.getResultList();
						}catch (Exception e) {
							e.printStackTrace();
						}
						finally  {
							em.close();
						}
						
						return list;
					}
}
