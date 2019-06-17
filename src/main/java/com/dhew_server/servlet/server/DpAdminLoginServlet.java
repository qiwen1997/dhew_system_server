package com.dhew_server.servlet.server;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dhew_server.service.server.DpAdminService;
import com.dhew_server.vo.DpAdminVo;
import com.dhew_server.vo.DpInfoVo;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.sf.json.JSONObject;

@WebServlet("/DpAdminLoginServlet")
public class DpAdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public DpAdminLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DpAdminService dpAdminService = new DpAdminService();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String dp_user = request.getParameter("dp_user");
		String dp_password = request.getParameter("dp_password");
		DpAdminVo dpAdmin = dpAdminService.login(dp_user, dp_password);
		if (dpAdmin != null) {
			DpInfoVo dpInfo = dpAdminService.getDpInfo(dpAdmin.getDp_id());
			request.getSession().setAttribute("dpAdmin", dpAdmin);
			request.getSession().setAttribute("dpInfo", dpInfo);
			JSONObject json = new JSONObject();
			json.put("loginresult", "succeed");
			json.put("dpAdmin", dpAdmin);
			json.put("dpInfo", dpInfo);
			response.getWriter().print(json.toString());
		} else {
			JSONObject json = new JSONObject();
			json.put("loginresult", "failed");
			response.getWriter().print(json.toString());
		}
	}
}
