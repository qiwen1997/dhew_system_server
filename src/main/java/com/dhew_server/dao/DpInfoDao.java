package com.dhew_server.dao;

import java.util.List;

import com.dhew_server.vo.DpInfoVo;

public interface DpInfoDao {
	/**
	 * 获得所有部门信息
	 * @return
	 */
	public List<DpInfoVo> getAll();
	
	/**
	 * 根据部门编号获得某一部门信息
	 * @param dp_id
	 * @return
	 */
	public DpInfoVo getDpInfoById(String dp_id);
	
	/**
	 * 增加部门信息
	 * @param info
	 */
	public void addDpInfo(DpInfoVo info);
	
	/**
	 * 根据部门编号删除部门信息
	 * @param dp_id
	 */
	public void deleteDpInfo(String[] dp_id);
	
	/**
	 * 根据部门编号修改部门信息
	 * @param info
	 */
	public void updateDpInfo(DpInfoVo info);
}
