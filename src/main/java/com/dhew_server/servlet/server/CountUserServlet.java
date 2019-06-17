package com.dhew_server.servlet.server;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dhew_server.service.server.UserInfoService;
import com.dhew_server.vo.DpAdminVo;

import net.sf.json.JSONObject;

@WebServlet("/CountUserServlet")
public class CountUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public CountUserServlet() {
        super();
    }
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserInfoService service = new UserInfoService();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String dp_id = request.getParameter("dp_id");
		int countUser = service.countUser(dp_id);
		JSONObject json = new JSONObject();
		json.put("countUser", countUser);
		response.getWriter().print(json.toString());
	}
}
