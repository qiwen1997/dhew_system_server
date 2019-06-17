package com.dhew_server.daoTest;

import static org.junit.Assert.*;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.dhew_server.dao.DpInfoDao;
import com.dhew_server.dao.MybatisUtil;
import com.dhew_server.vo.DpInfoVo;

public class DpInfoDaoTest {

	@Test
	public void test() {
		SqlSession session = MybatisUtil.openSession();
		DpInfoDao dao = session.getMapper(DpInfoDao.class);
		System.out.println(dao.getAll());
		System.out.println(dao.getDpInfoById("000002"));
		DpInfoVo info = new DpInfoVo("000000", "超级管理员");
		dao.addDpInfo(info);
		System.out.println(dao.getAll());
		dao.updateDpInfo(new DpInfoVo("000002", "林大"));
		System.out.println(dao.getAll());
		String[] dp_id = {"000002"};
		dao.deleteDpInfo(dp_id);
		System.out.println(dao.getAll());
	}

}
