package com.sinnotech.hotel.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sinnotech.hotel.mapper.UserMapper;

@Repository
public class UserDAO {
	@Autowired
	SqlSession sqlSession;

	public List<Integer> getUserIDByBookContent(String content) {
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		List<Integer> matchedUserID = mapper.getUserIDByBookContent(content);
		return matchedUserID.size() != 0 ? matchedUserID : null;
	}

}
