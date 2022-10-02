package com.sinnotech.hotel.dto;

import java.util.List;

import com.sinnotech.hotel.util.Util;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
public class Paging {
	public final static String NO = "no";
	public final static String ROOM = "room";
	public final static String USER = "user";
	public final static String DATE = "date";

	private String title;
	private String content;
	private Integer contentForId;
	private List<Integer> contentsUserID;

	private int startPage;
	private int curentPage;
	private int endPage;
	private int total;

	public Paging() {
	}

	public Paging(int startPage, int endPage, int total) {
		this.startPage = startPage;
		this.endPage = endPage;
		this.total = total;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
		System.out.println("Paging.setContent()");
		System.out.println(content);
		if (Util.CheckNumber(content)) {
			System.out.println("test");
			this.contentForId = Integer.parseInt(content);
		}
	}

	public Integer getContentForId() {
		return contentForId;
	}

	public void setContentForId(Integer contentForId) {
		this.contentForId = contentForId;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getCurentPage() {
		return curentPage;
	}

	public void setCurentPage(int curentPage) {
		this.curentPage = curentPage;
	}

	public List<Integer> getContentsUserID() {
		return contentsUserID;
	}

	public void setContentsUserID(List<Integer> contentsUserID) {
		this.contentsUserID = contentsUserID;
	}
}
