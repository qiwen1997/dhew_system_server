package com.dhew_server.servlet.android;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.dhew_server.dao.EmergencyContactDao;
import com.dhew_server.dao.MybatisUtil;
import com.dhew_server.vo.EmergencyContactVo;

public class UpdateUrgeServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		SqlSession session = MybatisUtil.openSession();
		EmergencyContactDao dao = session.getMapper(EmergencyContactDao.class);
		String action = request.getParameter("action");
		String eme_id = request.getParameter("eme_id");
		String contact_name = request.getParameter("contact_name");
		String contact_phone = request.getParameter("contact_phone");
		if(action.equals("1")) {
			EmergencyContactVo user=new EmergencyContactVo();
			user.setEme_id(Integer.parseInt(eme_id));
			user.setContact_name(contact_name);
			user.setContact_phone(contact_phone);
			int u=dao.updateContact(user);
			System.out.println("-------"+u);
			if(u != 0){
				out.print("success");
				session.commit();
			}else{
				out.print("0");
				session.rollback();
			 }
			out.flush();
			out.close();
		}else if(action.equals("2")) {
			String user_phone = request.getParameter("user_phone");
			int x=dao.updateall(user_phone);
			EmergencyContactVo v=new EmergencyContactVo(Integer.parseInt(eme_id),user_phone,
					contact_name,contact_phone);
			v.setDefault_phone(1);
			int y=dao.updatechange(v);
			if(y != 0){
				out.print("success");
				session.commit();
			}else{
				out.print("0");
				session.rollback();
			 }
			out.flush();
			out.close();
		}
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
		System.out.println("！！！===============登陆");
	}
	public void init() throws ServletException {
	}
	
	public UpdateUrgeServlet() {
		super();
	}

	public void destroy() {
		super.destroy();
	}
}