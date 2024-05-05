package com.test.activitycategory.service;

import java.util.List;

import com.test.activitycategory.entity.ActivityCategoryEntity;

public interface ActivityCategoryService {

	ActivityCategoryEntity addActivityCategory(ActivityCategoryEntity activityCategory);

	ActivityCategoryEntity updateActivityCategory(ActivityCategoryEntity activityCategory);

	ActivityCategoryEntity getActivityCategoryByID(Integer activityCategoryID);

	List<ActivityCategoryEntity> getAllActivityCategory();

}
