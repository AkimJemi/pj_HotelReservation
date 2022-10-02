package com.sinnotech.hotel.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sinnotech.hotel.mapper.RoomInfoMapper;

@Repository
public class RoomInfoDAO {
	@Autowired
	SqlSession sqlSession;

	public List<Integer> getRoomIDByBookContent(String content) {
		RoomInfoMapper mapper = sqlSession.getMapper(RoomInfoMapper.class);
		List<Integer> roomInfo = mapper.getRoomIDByBookContent(content);
		return roomInfo.size() != 0 ? roomInfo : null;
	}

	

}
