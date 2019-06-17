package com.dhew_server.dao;

import java.util.List;

import com.dhew_server.vo.WarnInfoVo;

public interface WarnInfoDao {
	/**
	 * 获得所有预警信息
	 * @return
	 */
	public List<WarnInfoVo> getAll();
	
	/**
	 * 获得用户手机号对应的全部预警信息
	 * @param user_phone
	 * @return
	 */
	public List<WarnInfoVo> getByUserPhone(String user_phone);
	
	/**
	 * 添加预警信息
	 * @param warn
	 */
	public void addWarn(WarnInfoVo warn);
	
	/**
	 * 根据预警信息id删除预警信息
	 * @param warnid
	 */
	public void deleteWarn(Integer[] warnid);
	
	public int countWarn(String dp_id);
	
	public int countHourWarn(String dp_id);
	
	public List<WarnInfoVo> getByDpId(String dp_id);
	
	public WarnInfoVo getRecentlyWarn(String user_phone);
}
