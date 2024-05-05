package com.test.activitycategory.dao;

import java.util.List;

import com.test.activitycategory.entity.ActivityCategoryEntity;

public interface ActivityCategoryDAO {

	int insert(ActivityCategoryEntity activityCategory);

	int update(ActivityCategoryEntity activityCategory);

	ActivityCategoryEntity findByPK(Integer activityCategoryID);

	List<ActivityCategoryEntity> getAll();

}
