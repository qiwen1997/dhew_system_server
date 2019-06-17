package com.dhew_server.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.dhew_server.vo.UserInfoVo;

public interface UserInfoDao {
	/**
	 * 获得所有用户信息
	 * @return
	 */
	public List<UserInfoVo> getAll();
	
	/**
	 * 通过部门编号获得部门所有员工
	 * @param dp_id
	 * @return
	 */
	public List<UserInfoVo> getAllByDpid(String dp_id);
	
	/**
     * 通过手机号获得用户信息
     * @param user_phone
     * @return
     */
	public UserInfoVo getUserByPhone(String user_phone);
	
	/**
     * 添加用户信息
     * @param info
     */
	public void addUserInfo(UserInfoVo info);
	
	/**
     * 根据用户手机删除信息
     * @param user_phone
	 * @return 
     */
	public int deleteUserInfo(String[] user_phone);
	
	/**
     * 更新用户信息
     * @param info
     */
	public void updateUserInfo(UserInfoVo info);
	
	//新添加 无id更新
	public Integer updateU(UserInfoVo info);
	public Integer updatedp_id(@Param("user_phone")String user_phone,@Param("dp_id")String dp_id);
	public List<Map<String, Object>> getAllWithEme();
	public List<Map<String, Object>> getAllByDpidWithEme(String dp_id);
	//新添加
	public String getdpid(String user_phone);
	
	public int countUser(String dp_id);
}
