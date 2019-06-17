package com.dhew_server.service.server;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.dhew_server.dao.DpAdminDao;
import com.dhew_server.dao.DpInfoDao;
import com.dhew_server.dao.MybatisUtil;
import com.dhew_server.vo.DpAdminVo;
import com.dhew_server.vo.DpInfoVo;

public class DpAdminService {
	public DpAdminVo login(String dp_user, String dp_password) {
		try (SqlSession session = MybatisUtil.openSession()) {
			DpAdminDao dao = session.getMapper(DpAdminDao.class);
			return dao.getAdmin(dp_user, dp_password);
		}
	}
	
	public DpInfoVo getDpInfo(String dp_id) {
		try (SqlSession session = MybatisUtil.openSession()) {
			DpInfoDao dao = session.getMapper(DpInfoDao.class);
			return dao.getDpInfoById(dp_id);
		}
	}
	
	public int countAdmin(String dp_id) {
		try (SqlSession session = MybatisUtil.openSession()) {
			DpAdminDao dao = session.getMapper(DpAdminDao.class);
			return dao.countAdmin(dp_id);
		}
	}
	
	public List<Map<String, Object>> getAllByDpid(String dp_id) {
		try (SqlSession session = MybatisUtil.openSession()) {
			DpAdminDao dao = session.getMapper(DpAdminDao.class);
			return dao.getAllByDpid(dp_id);
		}
	}
	
	public int addAdmin(DpAdminVo admin) {
		try (SqlSession session = MybatisUtil.openSession()) {
			DpAdminDao dao = session.getMapper(DpAdminDao.class);
			int result = dao.addAdmin(admin);
			if (result > 0) {
				session.commit();
			} else {
				session.rollback();
			}
			return result;
		}
	}
	
	public int deleteAdmin(Integer admin_id) {
		try (SqlSession session = MybatisUtil.openSession()) {
			DpAdminDao dao = session.getMapper(DpAdminDao.class);
			Integer[] admin = new Integer[1];
			admin[0] = admin_id;
			int result = dao.deleteAdmin(admin);
			if (result > 0) {
				session.commit();
			} else {
				session.rollback();
			}
			return result;
		}
	}
	
	public DpAdminVo getAdmin(String dp_user) {
		try (SqlSession session = MybatisUtil.openSession()) {
			DpAdminDao dao = session.getMapper(DpAdminDao.class);
			return dao.getAdminByUser(dp_user);
		}
	}
}
