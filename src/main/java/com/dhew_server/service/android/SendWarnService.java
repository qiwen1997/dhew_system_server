package com.dhew_server.service.android;

import java.util.Date;
import org.apache.ibatis.session.SqlSession;
import com.dhew_server.dao.MybatisUtil;
import com.dhew_server.dao.UserInfoDao;
import com.dhew_server.dao.WarnInfoDao;
import com.dhew_server.vo.UserInfoVo;
import com.dhew_server.vo.WarnInfoVo;

public class SendWarnService {
	public static String sendWarn(WarnInfoVo warnVo) {
		try (SqlSession session = MybatisUtil.openSession()) {
			UserInfoDao userDao = session.getMapper(UserInfoDao.class);
			WarnInfoDao warnDao = session.getMapper(WarnInfoDao.class);
			UserInfoVo userVo = userDao.getUserByPhone(warnVo.getUser_phone());
			warnVo.setUser_name(userVo.getUser_name());
			warnVo.setWarn_time(new Date());
			warnDao.addWarn(warnVo);
			session.commit();
			return "success";
		} catch (Exception e){
			return "failed";
		}	
	}
}