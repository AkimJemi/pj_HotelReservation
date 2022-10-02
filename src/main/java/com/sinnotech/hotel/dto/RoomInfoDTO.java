package com.sinnotech.hotel.dto;

import java.util.Date;

public class RoomInfoDTO {

	private int id;
	private String roomName;
	private int maxCount;
	private String info;
	private String options;
	private String images;
	private int price;
	private boolean deleteFlag;
	private Date createdAt;
	private Date updatedAt;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRoom_name() {
		return roomName;
	}

	public void setRoom_name(String room_name) {
		this.roomName = room_name;
	}

	public int getMax_count() {
		return maxCount;
	}

	public void setMax_count(int max_count) {
		this.maxCount = max_count;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getOptions() {
		return options;
	}

	public void setOptions(String options) {
		this.options = options;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public boolean isDeleteFlag() {
		return deleteFlag;
	}

	public void setDelete_flag(boolean deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public Date isCreated_at() {
		return createdAt;
	}

	public void setCreated_at(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date isUpdated_at() {
		return updatedAt;
	}

	public void setUpdated_at(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

}
