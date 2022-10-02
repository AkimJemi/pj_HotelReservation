package com.sinnotech.hotel.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinnotech.hotel.dao.BookDAO;
import com.sinnotech.hotel.dto.BookInfo;
import com.sinnotech.hotel.dto.BookingsDTO;
import com.sinnotech.hotel.dto.Paging;
import com.sinnotech.hotel.helper.PagingHelper;
import com.sinnotech.hotel.service.BookService;
import com.sinnotech.hotel.service.OptionsService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookDAO bookDao;
	@Autowired
	private OptionsService optionsService;
	
	@Autowired
	private PagingHelper pagingHelper;

	@Override
	public BookInfo getAllBookList() {
		BookInfo bookInfo = bookDao.getAllBookList();
		bookInfo.setOptions(optionsService.getBookingOptions());
		return bookInfo;
	}

	@Override
	public BookInfo searchBookList(Paging page) {
		Paging fliteredPaging = pagingHelper.fliterPaing(page);
		return bookDao.searchBookList(fliteredPaging);
	}

	@Override
	public BookingsDTO getBookInfo(Integer id) {
		return bookDao.getBookInfo(id);
	}

	@Override
	public BookingsDTO updateBookInfo(BookingsDTO bookingsDTO) {
		return bookDao.updateBookInfo(bookingsDTO) != null ? getBookInfo(bookingsDTO.getId()) : null;
	}

	@Override
	public boolean deleteBookInfo(Integer room) {
		return bookDao.deleteBookInfo(room) == true ? getBookInfo(room) == null ? true : false : false;
	}

}
