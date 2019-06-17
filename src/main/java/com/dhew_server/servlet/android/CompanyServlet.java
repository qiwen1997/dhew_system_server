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

import com.dhew_server.dao.DpInfoDao;
import com.dhew_server.dao.EmergencyContactDao;
import com.dhew_server.dao.MybatisUtil;
import com.dhew_server.dao.UserInfoDao;
import com.dhew_server.vo.DpInfoVo;
import com.dhew_server.vo.EmergencyContactVo;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class CompanyServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		SqlSession session = MybatisUtil.openSession();
		UserInfoDao udao = session.getMapper(UserInfoDao.class);
		DpInfoDao ddao=session.getMapper(DpInfoDao.class);
		String action=request.getParameter("action");
		System.out.println("!!!come here action:"+action);
		if(action.equals("1")) {
			String user_phone=request.getParameter("user_phone");
			String dp_id=request.getParameter("dp_id");
			DpInfoVo vo=ddao.getDpInfoById(dp_id);
			if(!vo.getDp_name().equals("")) {
				int y=udao.updatedp_id(user_phone, dp_id);
				out.print("success");
				session.commit();
			}else {
				out.print("0");
				session.rollback();
			}
			out.flush();
			out.close();
		}
		if(action.equals("0")) {
			String user_phone = request.getParameter("x");
			if (!user_phone.equals("")) {
				String id=udao.getdpid(user_phone);
				DpInfoVo vo=ddao.getDpInfoById(id);
				// 获得客户端请求参数
				JSONArray array = new JSONArray();
					JSONObject obj = new JSONObject();
					try {
						obj.put("dp_id",id);
						obj.put("dp_name", vo.getDp_name());
					} catch (Exception e) {
	                     System.out.println("装填出错");
					}
					array.add(obj);
				out.print(array.toString());
				out.flush();
				out.close();
			}else{
				System.out.println("出错了");
				out.flush();
				out.close();
			}
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
		System.out.println("！！！===============登陆");
	}

	public void init() throws ServletException {
	}

	public CompanyServlet() {
		super();
	}

	public void destroy() {
		super.destroy();
	}
}