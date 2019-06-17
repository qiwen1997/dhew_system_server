package com.dhew_server.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dhew_server.vo.UserLoginVo;

public interface UserLoginDao {
	/**
	 * 查询所有用户账号
	 * @return
	 */
	public List<UserLoginVo> getAll();
	
	/**
	 * 用户登录验证
	 * @param user_phone
	 * @param user_password
	 * @return
	 */
	public UserLoginVo getUser(@Param("user_phone") String user_phone, @Param("user_password") String user_password);
	
	/**
	 * 添加用户账号
	 * @param user
	 */
	public void addUser(UserLoginVo user);
	
	/**
	 * 根据用户手机删除用户账号
	 * @param user_phone
	 */
	public int deleteUser(String[] user_phone);
	
	/**
	 * 修改用户账号手机和密码
	 * @param user
	 */
	public void updateUser(UserLoginVo user);

}
