package com.sinnotech.hotel.dto;

import java.util.List;

public class BookInfo {
	List<BookingsDTO> BookDTOList;
	Paging paging;
	List<OptionsDTO> options;
	
	
	
	public List<OptionsDTO> getOptions() {
		return options;
	}
	public void setOptions(List<OptionsDTO> options) {
		this.options = options;
	}
	public void setBookDTOList(List<BookingsDTO> bookDTOList) {
		BookDTOList = bookDTOList;
	}
	public List<BookingsDTO> getBookDTOList() {
		return BookDTOList;
	}
	public Paging getPaging() {
		return paging;
	}
	public void setPaging(Paging paging) {
		this.paging = paging;
	}
	

}
