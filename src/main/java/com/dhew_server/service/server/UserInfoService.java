package com.dhew_server.service.server;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.dhew_server.dao.DpAdminDao;
import com.dhew_server.dao.MybatisUtil;
import com.dhew_server.dao.UserInfoDao;
import com.dhew_server.dao.UserLoginDao;
import com.dhew_server.vo.UserInfoVo;

public class UserInfoService {
	public List<Map<String, Object>> getAll() {
		try (SqlSession session = MybatisUtil.openSession()) {
			UserInfoDao dao = session.getMapper(UserInfoDao.class);
			return dao.getAllWithEme();
		}
	}	
	public List<Map<String, Object>> getAllByDpid(String dp_id) {
		try (SqlSession session = MybatisUtil.openSession()) {
			UserInfoDao dao = session.getMapper(UserInfoDao.class);
			return dao.getAllByDpidWithEme(dp_id);
		}
	}
	public int countUser(String dp_id) {
		try (SqlSession session = MybatisUtil.openSession()) {
			UserInfoDao dao = session.getMapper(UserInfoDao.class);
			return dao.countUser(dp_id);
		}
	}
	public int deleteUser(String user_phone) {
		try (SqlSession session = MybatisUtil.openSession()) {
			UserInfoDao dao = session.getMapper(UserInfoDao.class);
			UserLoginDao userdao = session.getMapper(UserLoginDao.class);
			String[] user = new String[1];
			user[0] = user_phone;
			int result = dao.deleteUserInfo(user);
			int loginresult = userdao.deleteUser(user);
			if (result > 0 && loginresult > 0) {
				session.commit();
			} else {
				session.rollback();
			}
			return result;
		}
	}
	
	public UserInfoVo getByPhone(String user_phone) {
		try (SqlSession session = MybatisUtil.openSession()) {
			UserInfoDao dao = session.getMapper(UserInfoDao.class);
			return dao.getUserByPhone(user_phone);
		}
	}
}