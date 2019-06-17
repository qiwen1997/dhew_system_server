package com.dhew_server.servlet.android;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.dhew_server.dao.EmergencyContactDao;
import com.dhew_server.dao.HealthInfoDao;
import com.dhew_server.dao.MybatisUtil;
import com.dhew_server.vo.EmergencyContactVo;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class DefaultHeartServlet
 */
@WebServlet("/DefaultHeartServlet")
public class DefaultHeartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DefaultHeartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		SqlSession session = MybatisUtil.openSession();
		HealthInfoDao healthDao = session.getMapper(HealthInfoDao.class);
		String user_phone = request.getParameter("user_phone");
		String db_phone = "zhealth_" + user_phone;
		//System.out.println(user_phone);
		String heart = healthDao.getDefaultHeart(db_phone);
		if (heart != null) {
			int h = heart.indexOf(".");
			heart = heart.substring(0, h);
			out.print(Integer.parseInt(heart));
		} else {
			out.print(80);
		}
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		System.out.println("post返回心率默认值");
	}

}
