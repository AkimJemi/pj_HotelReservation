package com.sinnotech.hotel.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class BookingsDTO {
	private int id;
	private int userId;
	private int roomId;
	private int price;
	private boolean payFlag;
	private boolean cancelFlag;
	private int adultCnt;
	private int childrenCnt;
	private String startDate;
	private String endDate;
	private String options;
	private boolean deleteFlag;
	private Date createdAt;
	private Date updatedAt;
	private String createdAtForView;
	private String updatedAtForView;
	private String updatedAtForTime;
	
	public String getCreatedAtForView() {
		return createdAtForView;
	}
	public void setCreatedAtForView(String createdAtForView) {
		this.createdAtForView = createdAtForView;
	}
	public String getUpdatedAtForView() {
		return updatedAtForView;
	}
	public void setUpdatedAtForView(String updatedAtForView) {
		this.updatedAtForView = updatedAtForView;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getRoomId() {
		return roomId;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public boolean isPayFlag() {
		return payFlag;
	}
	public void setPayFlag(boolean payFlag) {
		this.payFlag = payFlag;
	}
	public boolean isCancelFlag() {
		return cancelFlag;
	}
	public void setCancelFlag(boolean cancelFlag) {
		this.cancelFlag = cancelFlag;
	}
	public int getAdultCnt() {
		return adultCnt;
	}
	public void setAdultCnt(int adultCnt) {
		this.adultCnt = adultCnt;
	}
	public int getChildrenCnt() {
		return childrenCnt;
	}
	public void setChildrenCnt(int childrenCnt) {
		this.childrenCnt = childrenCnt;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getOptions() {
		return options;
	}
	public void setOptions(String options) {
		this.options = options;
	}
	public boolean isDeleteFlag() {
		return deleteFlag;
	}
	public void setDeleteFlag(boolean deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		this.createdAtForView = sdf.format(createdAt);
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdd = new SimpleDateFormat("hh:mm:ss");
		this.updatedAtForView = sdf.format(updatedAt);
		this.updatedAtForTime = sdd.format(updatedAt);
		this.updatedAt = updatedAt;
	}
	public String getUpdatedAtForTime() {
		return updatedAtForTime;
	}
	public void setUpdatedAtForTime(String updatedAtForTime) {
		this.updatedAtForTime = updatedAtForTime;
	}
}
