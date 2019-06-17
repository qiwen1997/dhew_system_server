package com.dhew_server.servlet.server;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dhew_server.service.server.WarnInfoService;
import com.dhew_server.vo.DpAdminVo;

import net.sf.json.JSONObject;

@WebServlet("/CountHourWarnServlet")
public class CountHourWarnServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public CountHourWarnServlet() {
        super();
    }
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		WarnInfoService service = new WarnInfoService();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String dp_id = request.getParameter("dp_id");
		int countHourWarn = service.countHourWarn(dp_id);
		JSONObject json = new JSONObject();
		json.put("countHourWarn", countHourWarn);
		response.getWriter().print(json.toString());
	}
}
