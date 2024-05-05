package com.test.activitysession;

import java.sql.Timestamp;
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

import com.test.activity.entity.ActivityEntity;
import com.test.activityorder.ActivityOrderEntity;

@Entity
@Table(name = "activity_session")
public class ActivitySessionEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "activity_session_id", updatable = false)
	private Integer activitySessionID;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "activity_id", referencedColumnName = "activity_id")
	private ActivityEntity activityID;
	
	@Column(name = "activity_start")
	private Timestamp activityStart;
	
	@Column(name = "activity_end")
	private Timestamp activityEnd;
	
	@Column(name = "activity_max_part")
	private Integer activityMaxPart;
	
	@Column(name = "activity_min_part")
	private Integer activityMinPart;
	
	@Column(name = "activity_entered_status")
	private Byte activityEnteredStatus;
	
	@Column(name = "activity_note")
	private String activityNote;
	
	@Column(name = "entered_total")
	private Integer enteredTotal;
	
	@Column(name = "entered_start")
	private Timestamp enteredStart;
	
	@Column(name = "entered_end")
	private Timestamp enteredEnd;
	
	@Column(name = "activity_session_status")
	private Boolean activitySessionStatus;
	
	@OneToMany(mappedBy = "activitySessionID", cascade = CascadeType.ALL)
	@OrderBy("activity_order_id asc")
	private Set<ActivityOrderEntity> activityOrderEntity;

	public Integer getActivitySessionID() {
		return activitySessionID;
	}

	public void setActivitySessionID(Integer activitySessionID) {
		this.activitySessionID = activitySessionID;
	}

	public ActivityEntity getActivityID() {
		return activityID;
	}

	public void setActivityID(ActivityEntity activityID) {
		this.activityID = activityID;
	}

	public Timestamp getActivityStart() {
		return activityStart;
	}

	public void setActivityStart(Timestamp activityStart) {
		this.activityStart = activityStart;
	}

	public Timestamp getActivityEnd() {
		return activityEnd;
	}

	public void setActivityEnd(Timestamp activityEnd) {
		this.activityEnd = activityEnd;
	}

	public Integer getActivityMaxPart() {
		return activityMaxPart;
	}

	public void setActivityMaxPart(Integer activityMaxPart) {
		this.activityMaxPart = activityMaxPart;
	}

	public Integer getActivityMinPart() {
		return activityMinPart;
	}

	public void setActivityMinPart(Integer activityMinPart) {
		this.activityMinPart = activityMinPart;
	}

	public Byte getActivityEnteredStatus() {
		return activityEnteredStatus;
	}

	public void setActivityEnteredStatus(Byte activityEnteredStatus) {
		this.activityEnteredStatus = activityEnteredStatus;
	}

	public String getActivityNote() {
		return activityNote;
	}

	public void setActivityNote(String activityNote) {
		this.activityNote = activityNote;
	}

	public Integer getEnteredTotal() {
		return enteredTotal;
	}

	public void setEnteredTotal(Integer enteredTotal) {
		this.enteredTotal = enteredTotal;
	}

	public Timestamp getEnteredStart() {
		return enteredStart;
	}

	public void setEnteredStart(Timestamp enteredStart) {
		this.enteredStart = enteredStart;
	}

	public Timestamp getEnteredEnd() {
		return enteredEnd;
	}

	public void setEnteredEnd(Timestamp enteredEnd) {
		this.enteredEnd = enteredEnd;
	}

	public Boolean getActivitySessionStatus() {
		return activitySessionStatus;
	}

	public void setActivitySessionStatus(Boolean activitySessionStatus) {
		this.activitySessionStatus = activitySessionStatus;
	}

	public Set<ActivityOrderEntity> getActivityOrderEntity() {
		return activityOrderEntity;
	}

	public void setActivityOrderEntity(Set<ActivityOrderEntity> activityOrderEntity) {
		this.activityOrderEntity = activityOrderEntity;
	}
		
}
