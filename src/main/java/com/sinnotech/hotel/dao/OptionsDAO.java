package com.sinnotech.hotel.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sinnotech.hotel.dto.OptionsDTO;
import com.sinnotech.hotel.mapper.OptionMapper;

@Repository
public class OptionsDAO {
	@Autowired
	SqlSession sqlSession;

	public List<OptionsDTO> getBookingOptions() {
		OptionMapper mapper = sqlSession.getMapper(OptionMapper.class);
		return mapper.getBookingOptions();
	}

}
