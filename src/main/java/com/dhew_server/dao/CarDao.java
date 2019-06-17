package com.dhew_server.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dhew_server.vo.CarVo;
import com.dhew_server.vo.EmergencyContactVo;

public interface CarDao {
	public List<CarVo> getContactByPhone(String user_phone);
	public void addContact(CarVo contact);
	public Integer deleteContact(@Param("car_id") String car_id);	
	public Integer updateContact(CarVo contact);
	public Integer updatechange(CarVo contact);
	public Integer updateall(String user_phone);	
}
