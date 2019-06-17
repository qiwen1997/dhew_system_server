package com.dhew_server.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dhew_server.vo.EmergencyContactVo;

public interface EmergencyContactDao {
	/**
	 * 获得所有紧急联系人信息
	 * @return
	 */
	public List<EmergencyContactVo> getAll();
	
	/**
	 * 获得用户手机对应的所有联系人信息
	 * @param user_phone
	 * @return
	 */
	public List<EmergencyContactVo> getContactByPhone(String user_phone);
	
	/**
	 * 获得用户手机对应的默认联系人
	 * @return
	 */
	public EmergencyContactVo getDefaultContactByPhone(String user_phone);
	
	/**
     * 根据紧急联系人id获取紧急联系人信息
     * @param eme_id
     * @return
     */
	public EmergencyContactVo getContactById(Integer eme_id);
	
	/**
     * 添加紧急联系人信息
     * @param contact
     */
	public void addContact(EmergencyContactVo contact);
	
	/**
     * 删除用户手机号以及紧急联系手机号对应的紧急联系人信息
     * @param user_phone
     * @param contact_phone
     */
	public void deleteContact(@Param("user_phone") String user_phone, @Param("contact_phone") String contact_phone);
	
	/**
     * 根据用户手机和紧急联系人id，更新联系人信息
     * @param contact
	 * @return 
     */
	public Integer updateContact(EmergencyContactVo contact);
	
	//有改动
	public Integer updatechange(EmergencyContactVo contact);
	public Integer updateall(String user_phone);
}
