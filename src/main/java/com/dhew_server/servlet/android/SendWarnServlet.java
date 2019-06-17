package com.dhew_server.servlet.android;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dhew_server.service.android.SendWarnService;
import com.dhew_server.vo.WarnInfoVo;

/**
 * Servlet implementation class SendWarnServlet
 */
@WebServlet("/SendWarnServlet")
public class SendWarnServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendWarnServlet() {
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
		String user_phone = request.getParameter("user_phone");
		WarnInfoVo warnVo = new WarnInfoVo();
		String contact_name = request.getParameter("contact_name");
		String contact_phone = request.getParameter("contact_phone");
		String warn_data = request.getParameter("warn_data");
		String warn_loc = request.getParameter("warn_loc");
		warnVo.setUser_phone(user_phone);
		warnVo.setContact_name(contact_name);
		warnVo.setContact_phone(contact_phone);
		warnVo.setWarn_data(warn_data);
		warnVo.setWarn_loc(warn_loc);
		String result = SendWarnService.sendWarn(warnVo);
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print(result);
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		System.out.println("post发送预警信息");
	}
}
