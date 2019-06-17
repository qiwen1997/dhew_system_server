package com.dhew_server.servlet.android;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.dhew_server.dao.MybatisUtil;
import com.dhew_server.dao.UserInfoDao;
import com.dhew_server.dao.UserLoginDao;
import com.dhew_server.vo.UserInfoVo;
import com.dhew_server.vo.UserLoginVo;
/**
 * 
 *
 * 响应 Android客户端发来的请求
 */
public class InfoServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		SqlSession session = MybatisUtil.openSession();
		UserInfoDao dao = session.getMapper(UserInfoDao.class);
		// 获得客户端请求参数
		String user_id = request.getParameter("user_id");
		String user_phone = request.getParameter("user_phone");
		String user_name = request.getParameter("user_name");
		String user_sex = request.getParameter("user_sex");
		String user_birth = request.getParameter("user_birth");
		String user_height = request.getParameter("user_height");
		String user_weight = request.getParameter("user_weight");
		String user_blood = request.getParameter("user_blood");
		String user_realname = request.getParameter("user_realname");
		Integer id=Integer.parseInt(user_id);
		DateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = sdf.parse(user_birth);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		double height=Double.valueOf(user_height);
		double weight=Double.valueOf(user_weight);
		UserInfoVo user=new UserInfoVo(id,user_phone,user_name,
				user_sex,date,height,weight,user_blood,user_realname);
		System.out.println("！！！！！===============注册");
		dao.addUserInfo(user);
		int  u = user.getUser_id();
		System.out.println("-------"+user.getUser_id());
		if(u != 0){
			out.print("success");
			session.commit();
		}else{
			// 响应客户端内容，登录失败
			out.print("0");
			session.rollback();
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
	
	public InfoServlet() {
		super();
	}

	public void destroy() {
		super.destroy();
	}
}