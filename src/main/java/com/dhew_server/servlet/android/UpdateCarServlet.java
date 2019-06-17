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

public class UpdateCarServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		SqlSession session = MybatisUtil.openSession();
		CarDao dao = session.getMapper(CarDao.class);
		String action = request.getParameter("action");
		String car_id = request.getParameter("car_id");
		String brand = request.getParameter("brand");
		String plate = request.getParameter("plate");
		String type = request.getParameter("type");
		if(action.equals("1")) {
			CarVo user=new CarVo();
			user.setCar_id(Integer.parseInt(car_id));
			user.setBrand(brand);
			user.setPlate(plate);
			user.setType(type);
			int u=dao.updateContact(user);
			System.out.println("-------"+u);
			if(u != 0){
				// 响应客户端内容，登录成功
				out.print("success");
				session.commit();
			}else{
				// 响应客户端内容，登录失败
				out.print("0");
				session.rollback();
			 }
			out.flush();
			out.close();
		}else if(action.equals("2")) {
			String user_phone = request.getParameter("user_phone");
			int x=dao.updateall(user_phone);
			System.out.println("xxxxxxxx"+x);
			CarVo v=new CarVo(Integer.parseInt(car_id),user_phone,
					brand,plate,type);
			v.setDefault(1);
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
		}else if(action.equals("3")) {
			String user_phone = request.getParameter("user_phone");
			int y=dao.deleteContact(car_id);
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
	
	public UpdateCarServlet() {
		super();
	}

	public void destroy() {
		super.destroy();
	}
}