package com.sinnotech.hotel.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sinnotech.hotel.dao.RoomInfoDAO;
import com.sinnotech.hotel.dao.UserDAO;
import com.sinnotech.hotel.dto.Paging;

@Component
public class PagingHelper {
	@Autowired
	UserDAO userDao;
	@Autowired
	RoomInfoDAO roomInfoDao;

	public Paging fliterPaing(Paging page) {
		switch (page.getTitle()) {
		case Paging.NO:
			break;
		case Paging.ROOM:
			page.setContentsUserID(roomInfoDao.getRoomIDByBookContent(page.getContent()));
			break;
		case Paging.DATE:
			break;
		case Paging.USER:
			page.setContentsUserID(userDao.getUserIDByBookContent(page.getContent()));
			break;
		}
		return page;
	}

}
