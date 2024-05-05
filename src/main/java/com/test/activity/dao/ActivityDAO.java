package com.test.activity.dao;

import java.util.List;
import java.util.Map;

import com.test.activity.entity.ActivityEntity;

public interface ActivityDAO {

	int insert(ActivityEntity activity);

	int update(ActivityEntity activity);

	ActivityEntity findByPK(Integer activityID);

	List<ActivityEntity> getAll();

	List<ActivityEntity> getByCompositeQuery(Map<String, String> map);

}
