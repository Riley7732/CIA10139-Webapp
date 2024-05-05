package com.test.activitycategory.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import com.test.activity.entity.ActivityEntity;

@Entity
@Table(name = "activity_category")
public class ActivityCategoryEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "activity_category_id", updatable = false)
	private Integer activityCategoryID;

	@Column(name = "activity_category_name")
	private String activityCategoryName;

	@Column(name = "activity_category_info")
	private String activityCategoryInfo;

	@OneToMany(mappedBy = "activityCategoryID", cascade = CascadeType.ALL)
	@OrderBy("activity_id asc")
	private Set<ActivityEntity> activityEntity;

	public ActivityCategoryEntity() {
		super();
	}

	public ActivityCategoryEntity(String activityCategoryName, String activityCategoryInfo) {
		super();
		this.activityCategoryName = activityCategoryName;
		this.activityCategoryInfo = activityCategoryInfo;
	}

	public ActivityCategoryEntity(Integer activityCategoryID, String activityCategoryName,
			String activityCategoryInfo) {
		super();
		this.activityCategoryID = activityCategoryID;
		this.activityCategoryName = activityCategoryName;
		this.activityCategoryInfo = activityCategoryInfo;
	}

	public Integer getActivityCategoryID() {
		return activityCategoryID;
	}

	public void setActivityCategoryID(Integer activityCategoryID) {
		this.activityCategoryID = activityCategoryID;
	}

	public String getActivityCategoryName() {
		return activityCategoryName;
	}

	public void setActivityCategoryName(String activityCategoryName) {
		this.activityCategoryName = activityCategoryName;
	}

	public String getActivityCategoryInfo() {
		return activityCategoryInfo;
	}

	public void setActivityCategoryInfo(String activityCategoryInfo) {
		this.activityCategoryInfo = activityCategoryInfo;
	}

	public Set<ActivityEntity> getActivityEntity() {
		return activityEntity;
	}

	public void setActivityEntity(Set<ActivityEntity> activityEntity) {
		this.activityEntity = activityEntity;
	}

}
