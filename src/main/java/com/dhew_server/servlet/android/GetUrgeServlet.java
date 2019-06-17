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
import com.dhew_server.dao.UserLoginDao;
import com.dhew_server.vo.EmergencyContactVo;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class GetUrgeServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		SqlSession session = MybatisUtil.openSession();
		EmergencyContactDao dao = session.getMapper(EmergencyContactDao.class);
		String user_phone = request.getParameter("action");
		EmergencyContactVo vo=new EmergencyContactVo();
		System.out.println("!!!come here action:"+user_phone);
		if (!user_phone.equals("")) {
			List<EmergencyContactVo> list = dao.getContactByPhone(user_phone);
			EmergencyContactVo v;
			// 获得客户端请求参数
			JSONArray array = new JSONArray();
			for (int i = 0; i < list.size(); i++) {
				v = (EmergencyContactVo) list.get(i);
				System.out.println(v);
				JSONObject obj = new JSONObject();
				try {
					obj.put("eme_id", String.valueOf(v.getEme_id()));
					obj.put("user_phone", v.getUser_phone());
					obj.put("contact_name", v.getContact_name());
					obj.put("contact_phone", v.getContact_phone());
					obj.put("default_phone", String.valueOf(v.getDefault_phone()));
					
				} catch (Exception e) {
                     System.out.println("装填出错");
				}
				array.add(obj);
			}
			out.print(array.toString());
			out.flush();
			out.close();
		}else{
			
			System.out.println("出错了");
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

	public GetUrgeServlet() {
		super();
	}

	public void destroy() {
		super.destroy();
	}

}
