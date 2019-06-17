package com.dhew_server.dao;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtil {
	static SqlSessionFactory factory = null;
	static {
		String resource = "configuration.xml";
		//读取核心配置文件的数据
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//创建session工厂
		factory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	public static SqlSession openSession() {
		return factory.openSession();
	}
}
