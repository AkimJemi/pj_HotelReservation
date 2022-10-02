package com.sinnotech.hotel.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.sinnotech.hotel.dto.BookingsDTO;
import com.sinnotech.hotel.dto.OptionsDTO;
import com.sinnotech.hotel.dto.Paging;

@Mapper
public interface BookMapper {

	List<BookingsDTO> getAllBookList();

	List<BookingsDTO> searchBookList(@Param("paging") Paging paging);

	BookingsDTO getBookInfo(@Param("id") int bookID);

	void updateBookInfo(@Param("book") BookingsDTO book);

	void deleteBookInfo(@Param("book") String room);

	int searchCount(Paging page);

	OptionsDTO getBookingOptions();

}
