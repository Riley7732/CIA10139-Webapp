package com.test.activity.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.test.activity.dao.ActivityDAO;
import com.test.activity.dao.ActivityDAOImpl;
import com.test.activity.entity.ActivityEntity;

public class ActivityServiceImpl implements ActivityService {
	
	private ActivityDAO dao;
	
	public ActivityServiceImpl() {
		dao = new ActivityDAOImpl();
	}

	@Override
	public ActivityEntity addActivity(ActivityEntity activity) {
		int activityID = dao.insert(activity);
		return activity;
	}

	@Override
	public ActivityEntity updateActivity(ActivityEntity activity) {
		int activityID = dao.update(activity);
		return activity;
	}

	@Override
	public ActivityEntity getActivityByID(Integer activityID) {
		return dao.findByPK(activityID);
	}

	@Override
	public List<ActivityEntity> getAllActivity() {
		return dao.getAll();
	}

	@Override
	public List<ActivityEntity> getEmpsByCompositeQuery(Map<String, String[]> map) {
		Map<String, String> query = new HashMap<>();
		// Map.Entry即代表一組key-value
		Set<Map.Entry<String, String[]>> entry = map.entrySet();
		
		for (Map.Entry<String, String[]> row : entry) {
			String key = row.getKey();
			// 因為請求參數裡包含了action，做個去除動作
			if ("action".equals(key)) {
				continue;
			}
			// 若是value為空即代表沒有查詢條件，做個去除動作
			String value = row.getValue()[0]; // getValue拿到一個String陣列, 接著[0]取得第一個元素檢查
			if (value == null || value.isEmpty()) {
				continue;
			}
			query.put(key, value);
		}
		
		System.out.println(query);
		
		return dao.getByCompositeQuery(query);
	}

}
