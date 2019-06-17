package com.dhew_server.daoTest;

import static org.junit.Assert.*;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.dhew_server.dao.EmergencyContactDao;
import com.dhew_server.dao.MybatisUtil;
import com.dhew_server.vo.EmergencyContactVo;

public class EmergencyContactDaoTest {

	@Test
	public void test() {
		SqlSession session = MybatisUtil.openSession();
		EmergencyContactDao dao = session.getMapper(EmergencyContactDao.class);
		System.out.println(dao.getAll());
		System.out.println(dao.getContactByPhone("15663602860"));
		System.out.println(dao.getContactById(4));
		//dao.deleteContact("15663602860", "4");
		EmergencyContactVo contact = new EmergencyContactVo("15663602860", "测试1", "1111", 0);
		dao.addContact(contact);
		System.out.println(dao.getAll());
		contact.setEme_id(8);
		contact.setContact_name("ceshi1");
		dao.updateContact(contact);
		System.out.println(dao.getAll());
		session.rollback();
		//session.commit();
	}

}
