package com.dhew_server.servlet.server;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dhew_server.service.server.UserInfoService;
import com.dhew_server.service.server.WarnInfoService;
import com.dhew_server.vo.EmergencyContactVo;
import com.dhew_server.vo.UserInfoVo;
import com.dhew_server.vo.WarnInfoVo;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.sf.json.JSONObject;

@WebServlet("/RecentlyWarnServlet")
public class RecentlyWarnServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public RecentlyWarnServlet() {
        super();
    }
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		WarnInfoService service = new WarnInfoService();
		UserInfoService userService = new UserInfoService();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String user_phone = request.getParameter("user_phone");
		WarnInfoVo warn = service.getRecentlyWarn(user_phone);
		EmergencyContactVo eme = service.getContect(user_phone);
		UserInfoVo user = userService.getByPhone(user_phone);
		JSONObject obj = new JSONObject();
		obj.put("user_id", user.getUser_id());
		obj.put("dp_id", user.getDp_id());
		obj.put("user_name", user.getUser_name());
		obj.put("user_sex", user.getUser_sex());
		obj.put("user_birth", user.getUser_birth());
		obj.put("user_weight", user.getUser_height());
		obj.put("user_weight", user.getUser_weight());
		obj.put("user_blood", user.getUser_blood());
		obj.put("user_realname", user.getUser_realname());
		obj.put("eme_id", eme.getEme_id());
		obj.put("user_phone", eme.getUser_phone());
		obj.put("default_contact_name", eme.getContact_name());
		obj.put("default_contact_phone", eme.getContact_phone());
		obj.put("default_phone", eme.getDefault_phone());
		if (warn == null) {
			obj.put("warn_id", "null");
			obj.put("contact_name", "null");
			obj.put("contact_phone","null");
			obj.put("warn_loc", "null");
			obj.put("warn_data", "null");
			obj.put("warn_time", "null");
		} else {
			obj.put("warn_id", warn.getWarn_id());
			obj.put("contact_name", warn.getContact_name());
			obj.put("contact_phone", warn.getContact_phone());
			obj.put("warn_loc", warn.getWarn_loc());
			obj.put("warn_data", warn.getWarn_data());
			obj.put("warn_time", warn.getWarn_time());
		}
		response.getWriter().print(obj.toString());
	}
}
