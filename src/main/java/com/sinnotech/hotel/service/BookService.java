package com.sinnotech.hotel.service;

import com.sinnotech.hotel.dto.BookInfo;
import com.sinnotech.hotel.dto.BookingsDTO;
import com.sinnotech.hotel.dto.Paging;

public interface BookService {

	BookInfo getAllBookList();

	BookInfo searchBookList(Paging page);

	BookingsDTO getBookInfo(Integer roomID);

	BookingsDTO updateBookInfo(BookingsDTO bookingsDTO);

	boolean deleteBookInfo(Integer roomID);

}
