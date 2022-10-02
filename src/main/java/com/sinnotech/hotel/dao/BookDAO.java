package com.sinnotech.hotel.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sinnotech.hotel.dto.BookInfo;
import com.sinnotech.hotel.dto.BookingsDTO;
import com.sinnotech.hotel.dto.Paging;
import com.sinnotech.hotel.mapper.BookMapper;

@Repository
public class BookDAO {
	@Autowired
	SqlSession sqlSession;

	public BookInfo getAllBookList() {
		BookMapper mapper = sqlSession.getMapper(BookMapper.class);
		BookInfo bookInfo = new BookInfo();
		bookInfo.setBookDTOList(mapper.getAllBookList());
		return bookInfo;
	}

//	private Paging bookListPaging(Paging page) {
////		BookMapper mapper = sqlSession.getMapper(BookMapper.class);
////		page.setTotal(mapper.searchCount(page));
//		if (page != null) {
//			page.setTotal(55);
//			page.setStartPage(3 >= page.getCurentPage() && page.getCurentPage() > 1 ? 1 : page.getCurentPage() - 2);
//			page.setEndPage(Math.round(page.getTotal()) < 5 ? page.getTotal()
//					: page.getCurentPage() >= Math.round(page.getTotal()) ? page.getCurentPage()
//							: page.getCurentPage() + 2);
//			return page;
//		} else {
//			Paging pages = new Paging();
//			pages.setTotal(3);
//			pages.setCurentPage(1);
//			pages.setStartPage(3 >= pages.getCurentPage() && pages.getCurentPage() > 1 ? 1 : pages.getCurentPage() - 2);
//			pages.setEndPage(Math.round(pages.getTotal()) < 5 ? pages.getTotal()
//					: pages.getCurentPage() >= Math.round(pages.getTotal()) ? pages.getCurentPage()
//							: pages.getCurentPage() + 2);
//			return pages;
//		}
//
//	}

	public BookInfo searchBookList(Paging page) {
		BookMapper mapper = sqlSession.getMapper(BookMapper.class);
		BookInfo bookInfo = new BookInfo();
		List<BookingsDTO> bookList = mapper.searchBookList(page);
		System.out.println(page.getContentsUserID());
		bookInfo.setBookDTOList(bookList);
		bookInfo.setPaging(page);
		return bookInfo;
	}

	public BookingsDTO getBookInfo(Integer BookId) {
		BookMapper mapper = sqlSession.getMapper(BookMapper.class);
		return mapper.getBookInfo(BookId);
	}

	public BookingsDTO updateBookInfo(BookingsDTO bookingsDTO) {
		BookMapper mapper = sqlSession.getMapper(BookMapper.class);
		mapper.updateBookInfo(bookingsDTO);
		BookingsDTO updatedBookings = getBookInfo(bookingsDTO.getId());
		if (bookingsDTO.getUpdatedAt() != updatedBookings.getUpdatedAt())
			return updatedBookings;
		else
			return null;

	}

	public boolean deleteBookInfo(Integer roomID) {
//		BookMapper mapper = sqlSession.getMapper(BookMapper.class);
//		return mapper.deleteBookInfo(room) == 1 ? getBookInfo(room) == null ? true : false : false;
		return false;
	}

}
