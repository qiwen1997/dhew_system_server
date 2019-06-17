package com.dhew_server.servlet.server;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dhew_server.service.server.WarnInfoService;
import com.dhew_server.vo.DpAdminVo;
import com.dhew_server.vo.WarnInfoVo;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/WarnInfoListServlet")
public class WarnInfoListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public WarnInfoListServlet() {
        super();
    }
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		WarnInfoService warnInfoService = new WarnInfoService();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String dp_id = request.getParameter("dp_id");
		List<WarnInfoVo> list = warnInfoService.getAllByDpid(dp_id);
		ObjectMapper mapper = new ObjectMapper();
		String jsonStr = mapper.writeValueAsString(list);
		response.getWriter().print(jsonStr);
	}
}
