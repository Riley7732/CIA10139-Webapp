package com.test.activity.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.test.activity.entity.ActivityEntity;
import com.test.util.HibernateUtil;

public class ActivityDAOImpl implements ActivityDAO {

	private SessionFactory factory;

	public ActivityDAOImpl() {
		factory = HibernateUtil.getSessionFactory();
	}

	private Session getSession() {
		return factory.getCurrentSession();
	}

	@Override
	public int insert(ActivityEntity activity) {
		return (Integer) getSession().save(activity);
	}

	@Override
	public int update(ActivityEntity activity) {
		try {
			getSession().update(activity);
			return 1;
		} catch (Exception e) {
			return -1;
		}
	}

	@Override
	public ActivityEntity findByPK(Integer activityID) {
		return getSession().get(ActivityEntity.class, activityID);
	}

	@Override
	public List<ActivityEntity> getAll() {
		return getSession().createQuery("from ActivityEntity", ActivityEntity.class).list();
	}

	@Override
	public List<ActivityEntity> getByCompositeQuery(Map<String, String> map) {
		if (map.size() == 0)
			return getAll();

		CriteriaBuilder builder = getSession().getCriteriaBuilder();
		CriteriaQuery<ActivityEntity> criteria = builder.createQuery(ActivityEntity.class);
		Root<ActivityEntity> root = criteria.from(ActivityEntity.class);

		List<Predicate> predicates = new ArrayList<>();

		for (Map.Entry<String, String> row : map.entrySet()) {
			if ("activityName".equals(row.getKey())) {
				predicates.add(builder.like(root.get("activityName"), "%" + row.getValue() + "%"));
			}
			if ("activityCategoryID".equals(row.getKey())) {
				predicates.add(
						builder.equal(root.get("activityCategoryID"), Integer.valueOf(row.getValue())));
			}
		}

		// criteria.where() 方法用於設定 Criteria 查詢的 where 條件。
		// builder.and() 方法是用來組合多個查詢條件（Predicate）的邏輯與（AND）操作。
		// 這允許將多個條件結合成一個條件表達式，只有當所有條件同時滿足時，記錄才會被選取。
		criteria.where(builder.and(predicates.toArray(new Predicate[predicates.size()])));
		criteria.orderBy(builder.asc(root.get("activityID")));
		TypedQuery<ActivityEntity> query = getSession().createQuery(criteria);

		return query.getResultList();
	}

}
