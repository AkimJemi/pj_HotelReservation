package com.sinnotech.hotel.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sinnotech.hotel.dto.OptionsDTO;

@Mapper
public interface OptionMapper {

	List<OptionsDTO> getBookingOptions();	
}
