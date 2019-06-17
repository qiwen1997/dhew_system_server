package com.dhew_server.servlet.android;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.dhew_server.dao.CarDao;
import com.dhew_server.dao.EmergencyContactDao;
import com.dhew_server.dao.MybatisUtil;
import com.dhew_server.vo.CarVo;
import com.dhew_server.vo.EmergencyContactVo;

/**
 * 
 *
 * 添加车辆
 */
public class CarServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		SqlSession session = MybatisUtil.openSession();
		CarDao dao = session.getMapper(CarDao.class);
		// 获得客户端请求参数
		
		String user_phone = request.getParameter("user_phone");
		String brand = request.getParameter("brand");
		String plate = request.getParameter("plate");
		String type = request.getParameter("type");		
		CarVo user=new CarVo(user_phone,brand,plate,type,0);
		//System.out.println("！！！！！===============注册");
		dao.addContact(user);
		int  u = user.getCar_id();
		System.out.println("-------"+u);
		if(u != 0){
			// 响应客户端内容，登录成功
			//JSONObject json = JSONObject.fromObject(u);
			//System.out.println(json.toString());
			//out.println(json.toString());
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
	
	public CarServlet() {
		super();
	}

	public void destroy() {
		super.destroy();
	}
}