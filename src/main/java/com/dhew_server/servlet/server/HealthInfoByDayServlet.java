package com.dhew_server.servlet.server;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dhew_server.service.server.HealthInfoService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@WebServlet("/HealthInfoByDayServlet")
public class HealthInfoByDayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public HealthInfoByDayServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HealthInfoService service = new HealthInfoService();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String user_phone = request.getParameter("user_phone");
		String date = request.getParameter("date");
		JSONObject obj = service.getHalfHourByDay(user_phone, date);
		response.getWriter().print(obj.toString());
	}
}
