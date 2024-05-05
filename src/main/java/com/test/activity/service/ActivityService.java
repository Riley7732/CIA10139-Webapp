package com.test.activity.service;

import java.util.List;
import java.util.Map;

import com.test.activity.entity.ActivityEntity;

public interface ActivityService {

	ActivityEntity addActivity(ActivityEntity activity);

	ActivityEntity updateActivity(ActivityEntity activity);

	ActivityEntity getActivityByID(Integer activityID);

	List<ActivityEntity> getAllActivity();

	List<ActivityEntity> getEmpsByCompositeQuery(Map<String, String[]> map);

}
