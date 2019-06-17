package com.dhew_server.servlet.android;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

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
import com.dhew_server.vo.HealthInfoVo;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class AddHealthInfoServlet
 */
@WebServlet("/AddHealthInfoServlet")
public class AddHealthInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddHealthInfoServlet() {
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
		HealthInfoDao dao = session.getMapper(HealthInfoDao.class);
		String user_phone = request.getParameter("user_phone");
		String db_phone = "zhealth_" + user_phone;
		String xinlv = request.getParameter("xinlv");
		String tem = request.getParameter("tem");
		String room = request.getParameter("room");
		String hum = request.getParameter("hum");
		HealthInfoVo info = new HealthInfoVo(null, new Date(), xinlv, tem, room, hum);
		int result = dao.addHealth(db_phone, info);		
		if (result > 0) {
			out.print("success");
			session.commit();
		} else {
			out.print("fail");
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
		System.out.println("post添加健康信息");
	}
}
