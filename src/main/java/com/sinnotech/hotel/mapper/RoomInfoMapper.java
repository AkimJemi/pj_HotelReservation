package com.sinnotech.hotel.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface RoomInfoMapper {

	List<Integer> getRoomIDByBookContent(@Param("content") String content);

}
