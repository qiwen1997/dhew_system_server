package com.dhew_server.daoTest;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.dhew_server.dao.EmergencyContactDao;
import com.dhew_server.dao.HealthInfoDao;
import com.dhew_server.dao.MybatisUtil;
import com.dhew_server.dao.UserInfoDao;
import com.dhew_server.dao.UserLoginDao;
import com.dhew_server.vo.DpAdminVo;
import com.dhew_server.vo.EmergencyContactVo;
import com.dhew_server.vo.UserInfoVo;
import com.dhew_server.vo.UserLoginVo;

public class UserInfoDaoTest {

	@Test
	public void test() throws ParseException {
		SqlSession session = MybatisUtil.openSession();
		UserInfoDao dao = session.getMapper(UserInfoDao.class);
		UserLoginDao daoLogin = session.getMapper(UserLoginDao.class);
		EmergencyContactDao daoEme = session.getMapper(EmergencyContactDao.class);
		HealthInfoDao daoHealth = session.getMapper(HealthInfoDao.class);
		//System.out.println(dao.getAll());
		//System.out.println(dao.getUserByPhone("15663602860"));
		
		for (int i = 4; i <= 4; i++) {
			Long phone = 18800000000L + i;
			String user_phone = String.valueOf(phone);
			String dp_id = "000002";
			String user_name = "nefu" + String.valueOf(i);
			String user_sex = "男";
			if (i % 4 == 0) {
				user_sex = "女";
			}
			int year = 1970 + i % 20;
			int month = i % 12 + 1;
			int day = i % 28 + 1;
			String birth = String.valueOf(year) + "-" + String.valueOf(month) + "-" + String.valueOf(day);
			Date user_birth = new SimpleDateFormat("yyyy-MM-dd").parse(birth);
			Double height = 0.0;
			if (user_sex == "男") {
				height = 168.0;	
			} else {
				height = 158.0;
			}
			height += i % 15; 
			Double weight = 0.0;
			if (user_sex == "男") {
				weight = 65.0;
			} else {
				weight = 45.0;
			}
			weight += i % 15; 
			String blood = "A";
			if (i % 4 == 1) {
				blood = "B";
			} else if (i % 4 == 2) {
				blood = "AB";
			} else if (i % 4 == 3) {
				blood = "O";
			}
			String user_realname = "东林驾驶员" + String.valueOf(i);
			UserLoginVo login = new UserLoginVo(user_phone, user_phone);
			UserInfoVo info = new UserInfoVo(i + 1, user_phone, dp_id, user_name, user_sex, user_birth, height, weight, blood, user_realname);
			System.out.println(login);
			System.out.println(info);
			String contact_name = "东林联系人" + String.valueOf(i);
			phone = 18810000000L + i;
			String contact_phone = String.valueOf(phone);
			EmergencyContactVo eme = new EmergencyContactVo(user_phone, contact_name, contact_phone, 1);
			System.out.println(eme);
			daoLogin.addUser(login);
			info.setUser_id(daoLogin.getUser(user_phone, user_phone).getUser_id());
			dao.addUserInfo(info);
			daoEme.addContact(eme);
			String db_phone = "zhealth_" + user_phone;
			daoHealth.createDatebaseByDbphone(db_phone);
			session.commit();
		}
		
		
		//UserInfoVo info = new UserInfoVo(null, "15547001088", "000002", "zxc", "男", new SimpleDateFormat("yyyy-MM-dd").parse("1974-02-08"), 171.5, 80.0, "A", "朱西春");
		//dao.addUserInfo(info);
		//dao.updateUserInfo(info);
		//dao.addUserInfo(info);
		//System.out.println(dao.getAll());
		//System.out.println(dao.getAllByDpid("000002"));
		
		//session.commit();
	}

}
