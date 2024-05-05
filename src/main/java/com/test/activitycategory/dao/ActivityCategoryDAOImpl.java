package com.test.activitycategory.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.test.activitycategory.entity.ActivityCategoryEntity;
import com.test.util.HibernateUtil;

public class ActivityCategoryDAOImpl implements ActivityCategoryDAO {
	
	// SessionFactory 為 thread-safe，可宣告為屬性讓請求執行緒們共用
	private SessionFactory factory;

	public ActivityCategoryDAOImpl() {
		factory = HibernateUtil.getSessionFactory();
	}

	// Session 為 not thread-safe，所以此方法在各個增刪改查方法裡呼叫
	// 以避免請求執行緒共用了同個 Session
	private Session getSession() {
		return factory.getCurrentSession();
	}

	@Override
	public int insert(ActivityCategoryEntity activityCategory) {
		return (Integer) getSession().save(activityCategory);
	}

	@Override
	public int update(ActivityCategoryEntity activityCategory) {
		try {
			getSession().update(activityCategory);
			return 1;
		} catch (Exception e) {
			return -1;
		}
	}

	@Override
	public ActivityCategoryEntity findByPK(Integer activityCategoryID) {
		return getSession().get(ActivityCategoryEntity.class, activityCategoryID);
	}

	@Override
	public List<ActivityCategoryEntity> getAll() {
		return getSession().createQuery("from ActivityCategoryEntity", ActivityCategoryEntity.class).list();
	}

//	public static void main(String[] args) {
//		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//		try {
//			session.beginTransaction();
//			ActivityCategoryDAOImpl dao = new ActivityCategoryDAOImpl();
//			dao.findByPK(10);
//			session.getTransaction().commit();
//			System.out.print(dao);
//		} catch (Exception e) {
//			session.getTransaction().rollback();
//			e.printStackTrace();
//		} finally {
//			HibernateUtil.shutdown();
//		}
//	}

}
