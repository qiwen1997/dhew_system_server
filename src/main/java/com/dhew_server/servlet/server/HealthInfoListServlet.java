package com.dhew_server.servlet.server;

import java.io.IOException;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dhew_server.service.server.HealthInfoService;
import com.dhew_server.vo.HealthInfoVo;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/HealthInfoListServlet")
public class HealthInfoListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public HealthInfoListServlet() {
        super();
    }
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HealthInfoService healthInfoService = new HealthInfoService();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String db_phone = request.getParameter("user_phone");
		List<HealthInfoVo> list = healthInfoService.getAllByPhone(db_phone);
		ObjectMapper mapper = new ObjectMapper();
		String jsonStr = mapper.writeValueAsString(list);
		response.getWriter().print(jsonStr);
	}
}
