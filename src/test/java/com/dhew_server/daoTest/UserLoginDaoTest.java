package com.dhew_server.daoTest;

import static org.junit.Assert.*;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.dhew_server.dao.MybatisUtil;
import com.dhew_server.dao.UserInfoDao;
import com.dhew_server.dao.UserLoginDao;
import com.dhew_server.vo.DpAdminVo;
import com.dhew_server.vo.UserLoginVo;

public class UserLoginDaoTest {

	@Test
	public void test() {
		SqlSession session = MybatisUtil.openSession();
		UserLoginDao dao = session.getMapper(UserLoginDao.class);
		//UserInfoDao
		/*System.out.println(dao.getAll());
		System.out.println(dao.getUser("15663602860", "zhuyuf"));
		UserLoginVo user = new UserLoginVo(null, "15547001088", "zhuxichun");
		dao.addUser(user);
		//dao.updateUser(user);
		
		System.out.println(dao.getAll());*/
		
		for (int i = 1; i <= 10; i++) {
			String dp_user = "nefu" + String.valueOf(i);
			String dp_password = "nefu" + String.valueOf(i);
			String admin_name = "东林管理员" + String.valueOf(i);
			Long phone = 15600000000L + i;
			Long con_phone = 15610000000L + i;
			String user_phone = String.valueOf(phone);
			
		}
		session.commit();
	}

}
