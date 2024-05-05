package com.test.activityphoto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.test.activity.entity.ActivityEntity;

@Entity
@Table(name = "activity_photo")
public class ActivityPhotoEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "activity_photo_id", updatable = false)
	private Integer activityPhotoID;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "activity_id", referencedColumnName = "activity_id")
	private ActivityEntity activityID;
	
	@Column(name = "activity_photo", columnDefinition = "LONGBLOB")
	private byte[] activityPhoto;

	public Integer getActivityPhotoID() {
		return activityPhotoID;
	}

	public void setActivityPhotoID(Integer activityPhotoID) {
		this.activityPhotoID = activityPhotoID;
	}

	public ActivityEntity getActivityID() {
		return activityID;
	}

	public void setActivityID(ActivityEntity activityID) {
		this.activityID = activityID;
	}

	public byte[] getActivityPhoto() {
		return activityPhoto;
	}

	public void setActivityPhoto(byte[] activityPhoto) {
		this.activityPhoto = activityPhoto;
	}

}
