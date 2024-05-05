package com.test.activityorder;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.test.activitysession.ActivitySessionEntity;

@Entity
@Table(name = "activity_order")
public class ActivityOrderEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "activity_order_id", updatable = false)
	private Integer activityOrderID;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "activity_session_id", referencedColumnName = "activity_session_id")
	private ActivitySessionEntity activitySessionID;
	
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "member_id", referencedColumnName = "member_id")
//	private Member memberID;
	
	@Column(name = "entered_adult_number")
	private Integer enteredAdultNumber;
	
	@Column(name = "entered_child_number")
	private Integer enteredChildNumber;
	
	@Column(name = "order_amount")
	private Integer orderAmount;
	
	@Column(name = "order_status")
	private Byte orderStatus;
	
	@Column(name = "order_time")
	private Timestamp orderTime;
	
	@Column(name = "order_note")
	private String orderNote;
	
	@Column(name = "refund_status")
	private Byte refundStatus;

	public Integer getActivityOrderID() {
		return activityOrderID;
	}

	public void setActivityOrderID(Integer activityOrderID) {
		this.activityOrderID = activityOrderID;
	}

	public ActivitySessionEntity getActivitySessionID() {
		return activitySessionID;
	}

	public void setActivitySessionID(ActivitySessionEntity activitySessionID) {
		this.activitySessionID = activitySessionID;
	}

	public Integer getEnteredAdultNumber() {
		return enteredAdultNumber;
	}

	public void setEnteredAdultNumber(Integer enteredAdultNumber) {
		this.enteredAdultNumber = enteredAdultNumber;
	}

	public Integer getEnteredChildNumber() {
		return enteredChildNumber;
	}

	public void setEnteredChildNumber(Integer enteredChildNumber) {
		this.enteredChildNumber = enteredChildNumber;
	}

	public Integer getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(Integer orderAmount) {
		this.orderAmount = orderAmount;
	}

	public Byte getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(Byte orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Timestamp getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Timestamp orderTime) {
		this.orderTime = orderTime;
	}

	public String getOrderNote() {
		return orderNote;
	}

	public void setOrderNote(String orderNote) {
		this.orderNote = orderNote;
	}

	public Byte getRefundStatus() {
		return refundStatus;
	}

	public void setRefundStatus(Byte refundStatus) {
		this.refundStatus = refundStatus;
	}
		
}
