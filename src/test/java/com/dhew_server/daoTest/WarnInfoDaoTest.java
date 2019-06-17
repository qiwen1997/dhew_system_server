package com.dhew_server.daoTest;

import static org.junit.Assert.*;

import java.util.Date;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.dhew_server.dao.MybatisUtil;
import com.dhew_server.dao.WarnInfoDao;
import com.dhew_server.vo.WarnInfoVo;

public class WarnInfoDaoTest {

	@Test
	public void test() {
		SqlSession session = MybatisUtil.openSession();
		WarnInfoDao dao = session.getMapper(WarnInfoDao.class);
		//System.out.println(dao.getAll());
		//System.out.println(dao.getByUserPhone("15663602860"));
		WarnInfoVo warn = new WarnInfoVo(null, "15600000036", "driver36", "紧急联系人36", "15610000036", "黑龙江省哈尔滨市松北区黑龙江科技大学", "紧急联系人您好，手机号为15600000036的驾驶员车内温度异常，数值为45,请注意关注其驾驶状态", new Date());
		dao.addWarn(warn);
		/*System.out.println(dao.getAll());
		Integer[] warn_id = {5};
		dao.deleteWarn(warn_id);*/
		session.commit();
	}

}
