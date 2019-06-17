package com.dhew_server.service.server;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dhew_server.dao.EmergencyContactDao;
import com.dhew_server.dao.MybatisUtil;
import com.dhew_server.dao.WarnInfoDao;
import com.dhew_server.vo.EmergencyContactVo;
import com.dhew_server.vo.WarnInfoVo;

public class WarnInfoService {
	public List<WarnInfoVo> getAllByPhone(String user_phone) {
		try (SqlSession session = MybatisUtil.openSession()) {
			WarnInfoDao dao = session.getMapper(WarnInfoDao.class);
			return dao.getByUserPhone(user_phone);
		}
	}
	public List<WarnInfoVo> getAllByDpid(String dp_id) {
		try (SqlSession session = MybatisUtil.openSession()) {
			WarnInfoDao dao = session.getMapper(WarnInfoDao.class);
			return dao.getByDpId(dp_id);
		}
	}
	
	public int countWarn(String dp_id) {
		try (SqlSession session = MybatisUtil.openSession()) {
			WarnInfoDao dao = session.getMapper(WarnInfoDao.class);
			return dao.countWarn(dp_id);
		}
	}
	
	public int countHourWarn(String dp_id) {
		try (SqlSession session = MybatisUtil.openSession()) {
			WarnInfoDao dao = session.getMapper(WarnInfoDao.class);
			return dao.countHourWarn(dp_id);
		}
	}
	
	public WarnInfoVo getRecentlyWarn(String user_phone) {
		try (SqlSession session = MybatisUtil.openSession()) {
			WarnInfoDao dao = session.getMapper(WarnInfoDao.class);
			return dao.getRecentlyWarn(user_phone);
		}
	}
	
	public EmergencyContactVo getContect(String user_phone) {
		try (SqlSession session = MybatisUtil.openSession()) {
			EmergencyContactDao dao = session.getMapper(EmergencyContactDao.class);
			return dao.getDefaultContactByPhone(user_phone);
		}
	}
}