package com.test.activitycategory.service;

import java.util.List;

import com.test.activitycategory.dao.ActivityCategoryDAO;
import com.test.activitycategory.dao.ActivityCategoryDAOImpl;
import com.test.activitycategory.entity.ActivityCategoryEntity;

public class ActivityCategoryServiceImpl implements ActivityCategoryService {

	private ActivityCategoryDAO dao;

	public ActivityCategoryServiceImpl() {
		dao = new ActivityCategoryDAOImpl();
	}

	@Override
	public ActivityCategoryEntity addActivityCategory(ActivityCategoryEntity activityCategory) {
		int activityCategoryID = dao.insert(activityCategory);
		return activityCategory;
	}

	@Override
	public ActivityCategoryEntity updateActivityCategory(ActivityCategoryEntity activityCategory) {
		int activityCategoryID = dao.update(activityCategory);
		return activityCategory;
	}

	@Override
	public ActivityCategoryEntity getActivityCategoryByID(Integer activityCategoryID) {
		return dao.findByPK(activityCategoryID);
	}

	@Override
	public List<ActivityCategoryEntity> getAllActivityCategory() {
		return dao.getAll();
	}

}
