package com.test.activity.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import com.test.activitycategory.entity.ActivityCategoryEntity;
import com.test.activityphoto.ActivityPhotoEntity;

@Entity
@Table(name = "activity")
public class ActivityEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "activity_id", updatable = false)
	private Integer activityID;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "activity_category_id", referencedColumnName = "activity_category_id")
	private ActivityCategoryEntity activityCategoryID;
	
	@Column(name = "activity_name")
	private String activityName;
	
	@Column(name = "activity_price")
	private Integer activityPrice;
	
	@Column(name = "activity_info")
	private String activityInfo;
	
	@Column(name = "activity_notice")
	private String activityNotice;
	
	@Column(name = "activity_status")
	private Boolean activityStatus;
	
	@OneToMany(mappedBy = "activityID", cascade = CascadeType.ALL)
	@OrderBy("activity_photo_id asc")
	private Set<ActivityPhotoEntity> activityPhotoEntity;
	
	public ActivityEntity() {
		super();
	}
	
	public ActivityEntity(ActivityCategoryEntity activityCategoryID, String activityName, Integer activityPrice,
			String activityInfo, String activityNotice, Boolean activityStatus) {
		super();
		this.activityCategoryID = activityCategoryID;
		this.activityName = activityName;
		this.activityPrice = activityPrice;
		this.activityInfo = activityInfo;
		this.activityNotice = activityNotice;
		this.activityStatus = activityStatus;
	}
	
	public ActivityEntity(Integer activityID, ActivityCategoryEntity activityCategoryID, String activityName,
			Integer activityPrice, String activityInfo, String activityNotice, Boolean activityStatus) {
		super();
		this.activityID = activityID;
		this.activityCategoryID = activityCategoryID;
		this.activityName = activityName;
		this.activityPrice = activityPrice;
		this.activityInfo = activityInfo;
		this.activityNotice = activityNotice;
		this.activityStatus = activityStatus;
	}

	public Integer getActivityID() {
		return activityID;
	}

	public void setActivityID(Integer activityID) {
		this.activityID = activityID;
	}

	public void setActivityCategoryID(ActivityCategoryEntity activityCategoryID) {
		this.activityCategoryID = activityCategoryID;
	}

	public ActivityCategoryEntity getActivityCategoryID() {
		return activityCategoryID;
	}

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	public Integer getActivityPrice() {
		return activityPrice;
	}

	public void setActivityPrice(Integer activityPrice) {
		this.activityPrice = activityPrice;
	}

	public String getActivityInfo() {
		return activityInfo;
	}

	public void setActivityInfo(String activityInfo) {
		this.activityInfo = activityInfo;
	}

	public String getActivityNotice() {
		return activityNotice;
	}

	public void setActivityNotice(String activityNotice) {
		this.activityNotice = activityNotice;
	}

	public Boolean getActivityStatus() {
		return activityStatus;
	}

	public void setActivityStatus(Boolean activityStatus) {
		this.activityStatus = activityStatus;
	}

	public Set<ActivityPhotoEntity> getActivityPhotoEntity() {
		return activityPhotoEntity;
	}

	public void setActivityPhotoEntity(Set<ActivityPhotoEntity> activityPhotoEntity) {
		this.activityPhotoEntity = activityPhotoEntity;
	}
	
}
