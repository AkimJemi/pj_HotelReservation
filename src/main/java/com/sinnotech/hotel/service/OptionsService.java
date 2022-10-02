package com.sinnotech.hotel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinnotech.hotel.dao.OptionsDAO;
import com.sinnotech.hotel.dto.OptionsDTO;
import com.sinnotech.hotel.serviceImpl.OptionServiceImpl;

@Service
public class OptionsService implements OptionServiceImpl{
	
	@Autowired
	OptionsDAO optionDao;

	@Override
	public List<OptionsDTO> getBookingOptions() {
		return optionDao.getBookingOptions();
	}
	
	
	

}
