package com.dhew_server.servlet.android;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.dhew_server.dao.HealthInfoDao;
import com.dhew_server.dao.MybatisUtil;
import com.dhew_server.dao.UserInfoDao;
import com.dhew_server.dao.UserLoginDao;
import com.dhew_server.vo.UserInfoVo;
import com.dhew_server.vo.UserLoginVo;

/**
 * 响应 Android客户端发来的请求
 */
public class RegisterServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		SqlSession session = MybatisUtil.openSession();
		UserLoginDao dao = session.getMapper(UserLoginDao.class);
		HealthInfoDao dd=session.getMapper(HealthInfoDao.class);
		// 获得客户端请求参数
		String username = request.getParameter("account");
		String password = request.getParameter("password");
		UserLoginVo user=new UserLoginVo(username,password);
		System.out.println("！！！！！===============注册");
		UserLoginVo ulv=dao.getUser(username, password);
		StringBuffer sb=new StringBuffer("zhealth_");
		sb.append(username);
		if(ulv==null) {
		dao.addUser(user);
		dd.createDatebaseByDbphone(sb.toString());
		int  u = user.getUser_id();
		System.out.println("-------"+user.getUser_id());
		if(u != 0){
			// 响应客户端内容，登录成功
			out.print(String.valueOf(u));
			session.commit();
		}else{
			// 响应客户端内容，登录失败
			out.print("0");
			session.rollback();
		 }
		}else {
			out.print("-1");
		}
		out.flush();
		out.close();
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
		System.out.println("！！！===============登陆");
	}
	public void init() throws ServletException {
	}
	
	public RegisterServlet() {
		super();
	}

	public void destroy() {
		super.destroy();
	}

}
