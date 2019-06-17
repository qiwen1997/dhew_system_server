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
import com.dhew_server.vo.UserInfoVo;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class ClientMemberServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String action = request.getParameter("action");
		SqlSession session = MybatisUtil.openSession();
		UserInfoDao dao = session.getMapper(UserInfoDao.class);
		System.out.println("!!!come here action:" + action);
		if (action.equals("1")) {
			String user_phone = request.getParameter("username");
			UserInfoVo user=dao.getUserByPhone(user_phone);
			JSONArray array = new JSONArray();
			JSONObject obj = new JSONObject();
			try {
				obj.put("user_name", user.getUser_name());
				System.out.println(user.getUser_name());
				obj.put("user_realname", user.getUser_realname());
				obj.put("user_sex", user.getUser_sex());
				Date date=user.getUser_birth();
				String dateStr = new SimpleDateFormat("yyyy-MM-dd").format(date);
				obj.put("user_birth", dateStr);
				obj.put("user_height", String.valueOf(user.getUser_height()));
				obj.put("user_weight", String.valueOf(user.getUser_weight()));
				obj.put("user_blood", user.getUser_blood());
			} catch (Exception e) {
				System.out.println("装填失败");	
			}
			array.add(obj);
			out.print(array.toString());
			out.flush();
			out.close();
			System.out.println(array.toString());
		
		}else if (action.equals("2")) {
			String user_phone = request.getParameter("user_phone");
			String user_name = request.getParameter("user_name");
			String user_sex = request.getParameter("user_sex");
			String user_birth = request.getParameter("user_birth");
			String user_height = request.getParameter("user_height");
			String user_weight = request.getParameter("user_weight");
			String user_blood = request.getParameter("user_blood");
			String user_realname = request.getParameter("user_realname");
			DateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			Date date = null;
			try {
				date = sdf.parse(user_birth);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			double height=Double.valueOf(user_height);
			double weight=Double.valueOf(user_weight);
			UserInfoVo user=new UserInfoVo(user_phone,user_name,
					user_sex,date,height,weight,user_blood,user_realname);
			System.out.println("！！！！！===============注册");
			int  u = dao.updateU(user);
			System.out.println("-------"+u);
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
   }

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
		System.out.println("！！！===============登陆");
	}

	public void init() throws ServletException {
	}

	public ClientMemberServlet() {
		super();
	}

	public void destroy() {
		super.destroy();
	}
	 public String Code(String str)
	   {
	        String str2;
	        try{
			byte b[]=str.getBytes("ISO-8859-1");
			str2=new String(b,"UTF-8");
	        }
	      catch(Exception e)
	      {
	      str2=str;
	     
	      }
	   
	    return str2;
	   }
}
