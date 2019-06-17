package com.dhew_server.servlet.server;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dhew_server.service.server.UserInfoService;
import com.dhew_server.service.server.WarnInfoService;
import com.dhew_server.vo.WarnInfoVo;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/WarnInfoByPhoneList")
public class WarnInfoByPhoneList extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public WarnInfoByPhoneList() {
        super();
    }
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		WarnInfoService warnInfoService = new WarnInfoService();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String user_phone = request.getParameter("user_phone");
		List<WarnInfoVo> list = warnInfoService.getAllByPhone(user_phone);
		System.out.println(list);
		ObjectMapper mapper = new ObjectMapper();
		String jsonStr = mapper.writeValueAsString(list);
		response.getWriter().print(jsonStr);
	}
}
