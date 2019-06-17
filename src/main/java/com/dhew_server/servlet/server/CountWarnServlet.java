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

@WebServlet("/CountWarnServlet")
public class CountWarnServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public CountWarnServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		WarnInfoService service = new WarnInfoService();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String dp_id = request.getParameter("dp_id");
		int countWarn = service.countWarn(dp_id);
		JSONObject json = new JSONObject();
		json.put("countWarn", countWarn);
		response.getWriter().print(json.toString());
	}
}
