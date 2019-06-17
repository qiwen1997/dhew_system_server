package com.dhew_server.daoTest;
import static org.junit.Assert.*;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.dhew_server.dao.DpAdminDao;
import com.dhew_server.dao.MybatisUtil;
import com.dhew_server.vo.DpAdminVo;


public class DpAdminDaoTest {

	@Test
	public void test() {
		
		SqlSession session = MybatisUtil.openSession();
		DpAdminDao dao = session.getMapper(DpAdminDao.class);
		//System.out.println(dao.getAdmin("admin", "adm"));
		//System.out.println(dao.getAll());
	//	DpAdminVo admin = new DpAdminVo(null, "000002", "nefu", "nefu", 1);
		//dao.updateAdmin(admin);
		//String[] dp_user = {"nefu"};
		//Integer[] admin_id = {5};
		//dao.deleteAdmin(admin_id);
		//session.commit();
		//dao.deleteAdmin(dp_user);
		//System.out.println(dao.getAll());
//		session.commit();
		/*for (int i = 2; i <= 10; i++) {
			String dp_user = "admin" + String.valueOf(i);
			String dp_password = "admin" + String.valueOf(i);
			String admin_name = "超级管理员" + String.valueOf(i);
			Long phone = 13900000000L + i;
			String admin_phone = String.valueOf(phone);
			DpAdminVo admin = new DpAdminVo(null, "000000", dp_user, dp_password, i%2, admin_name, "男", admin_phone, null);
			System.out.println(admin);
			dao.addAdmin(admin);
		}*/
		for (int i = 1; i <= 10; i++) {
			String dp_user = "nefu" + String.valueOf(i);
			String dp_password = "nefu" + String.valueOf(i);
			String admin_name = "东林管理员" + String.valueOf(i);
			Long phone = 13800000000L + i;
			String admin_phone = String.valueOf(phone);
			DpAdminVo admin = new DpAdminVo(null, "000002", dp_user, dp_password, i%2, admin_name, "男", admin_phone, null);
			System.out.println(admin);
			dao.addAdmin(admin);
		}
		session.commit();
	}

}
