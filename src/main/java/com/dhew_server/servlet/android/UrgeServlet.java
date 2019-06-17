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

import com.dhew_server.dao.EmergencyContactDao;
import com.dhew_server.dao.MybatisUtil;
import com.dhew_server.dao.UserInfoDao;
import com.dhew_server.vo.EmergencyContactVo;
import com.dhew_server.vo.UserInfoVo;

public class UrgeServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		SqlSession session = MybatisUtil.openSession();
		EmergencyContactDao dao = session.getMapper(EmergencyContactDao.class);
		String user_phone = request.getParameter("user_phone");
		String contact_name = request.getParameter("contact_name");
		String contact_phone = request.getParameter("contact_phone");
		String default_phone = request.getParameter("default_phone");
		EmergencyContactVo user=new EmergencyContactVo(user_phone,
				contact_name,contact_phone,Integer.parseInt(default_phone));
		dao.addContact(user);
		int  u = user.getEme_id();
		System.out.println("-------"+user.getEme_id());
		if(u != 0){
			out.print("success");
			session.commit();
		}else{
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
	
	public UrgeServlet() {
		super();
	}

	public void destroy() {
		super.destroy();
	}
}