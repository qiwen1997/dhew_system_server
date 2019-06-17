package com.dhew_server.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.dhew_server.vo.DpAdminVo;

public interface DpAdminDao {
	/**
	 * 获得所有管理员账号信息
	 * @return
	 */
	public List<DpAdminVo> getAll();
	
	/**
	 * 获得管理员登录信息
	 * @param dp_user
	 * @param dp_password
	 * @return
	 */
	public DpAdminVo getAdmin(@Param("dp_user") String dp_user, @Param("dp_password") String dp_password);

	/**
	 * 添加管理员账号
	 * @param admin
	 */
	public int addAdmin(DpAdminVo admin);

	/**
	 * 根据id批量删除管理员信息
	 * @param dp_user
	 */
	public int deleteAdmin(Integer[] admin_id);
	
	/**
	 * 修改管理员账号，根据账号名修改编号和密码
	 * @param admin
	 */
	public void updateAdmin(DpAdminVo admin);
	public int countAdmin(String dp_id);
	public List<Map<String, Object>> getAllByDpid(String dp_id);
	public DpAdminVo getAdminByUser(String dp_user);
}
