package com.dhew_server.servlet.android;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.dhew_server.dao.EmergencyContactDao;
import com.dhew_server.dao.MybatisUtil;
import com.dhew_server.vo.EmergencyContactVo;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class WarnGetEmergent
 */
@WebServlet("/WarnGetEmergentServlet")
public class WarnGetEmergentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WarnGetEmergentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
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
		EmergencyContactDao emeDao = session.getMapper(EmergencyContactDao.class);
		String user_phone = request.getParameter("user_phone");
		System.out.println(user_phone);
		EmergencyContactVo emeVo = emeDao.getDefaultContactByPhone(user_phone);
		if (emeVo != null) {
			JSONObject obj = new JSONObject();
			obj.put("contact_name", emeVo.getContact_name());
			obj.put("contact_phone", emeVo.getContact_phone());
			out.print(obj);
		} else {
			out.print("noeme");
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
		System.out.println("post查找联系人");
	}
}
