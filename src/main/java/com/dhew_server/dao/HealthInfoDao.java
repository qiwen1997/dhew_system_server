package com.dhew_server.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.dhew_server.vo.HealthInfoVo;

public interface HealthInfoDao {
	/**
	 * 创建用户手机号数据库
	 * db_phone格式 zhealth_手机号
	 * @param db_phone
	 */
	public void createDatebaseByDbphone(@Param("db_phone") String db_phone);
	
	/**
	 * 根据用户手机号删除用户数据库
	 * @param db_phone
	 */
	public void deleteDatebaseByDbphone(@Param("db_phone") String db_phone);
	
	/**
	 * 根据用户手机号删除用户数据库
	 * @param db_phone
	 */
	public void updateDatebaseByDbphone(@Param("old_db_phone") String old_db_phone, @Param("new_db_phone") String new_db_phone);
	
	/**
	 * 获得用户手机号数据库对应的健康信息
	 * @param user_phone
	 * @return
	 */
	public List<HealthInfoVo> getAll(@Param("db_phone") String db_phone);
	
	/**
	 * 获得用户手机号数据库对应的起止时间内的健康信息
	 * 起止时间类型为String，格式为 yyyy-MM-dd HH:mm:ss
	 * @param db_phone
	 * @param start_time
	 * @param end_time
	 * @return
	 */
	public List<HealthInfoVo> getByTime(@Param("db_phone") String db_phone, @Param("start_time") String start_time ,@Param("end_time") String end_time);
	
	/**
	 * 向某用户手机号数据库添加健康信息
	 * @param db_phone
	 * @param health
	 */
	public int addHealth(@Param("db_phone") String db_phone, @Param("health") HealthInfoVo health);
	
	/**
	 * 根据起止时间删除用户手机号数据库健康信息
	 * @param db_phone
	 * @param start_time
	 * @param end_time
	 */
	public void deleteHealthByTime(@Param("db_phone") String db_phone, @Param("start_time") String start_time ,@Param("end_time") String end_time);
	
	/**
	 * 根据健康信息id删除用户手机号数据库健康信息
	 * @param db_phone
	 * @param id
	 */
	public void deleteHealthById(@Param("db_phone") String db_phone, @Param("array") Integer[] id);
	
	public HealthInfoVo getByDay(@Param("db_phone") String db_phone, @Param("day") String day);
	
	public List<Map<String, Object>> getHalfHourByDay(@Param("db_phone") String db_phone, @Param("date") String date);
	
	public String getDefaultHeart(@Param("db_phone") String db_phone);
}
