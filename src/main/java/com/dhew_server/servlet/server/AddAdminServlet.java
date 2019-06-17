package com.dhew_server.servlet.server;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dhew_server.service.server.DpAdminService;
import com.dhew_server.vo.DpAdminVo;

import net.sf.json.JSONObject;

@WebServlet("/AddAdminServlet")
public class AddAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public AddAdminServlet() {
        super();
    }
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DpAdminService service = new DpAdminService();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		DpAdminVo admin = new DpAdminVo();
		JSONObject obj = JSONObject.fromObject(request.getParameter("addAdminJson"));
		admin.setDp_id(obj.getString("dp_id"));
		admin.setDp_user(obj.getString("dp_user"));
		admin.setDp_password(obj.getString("dp_password"));
		admin.setAdmin_name(obj.getString("admin_name"));
		admin.setAdmin_sex(obj.getString("admin_sex"));
		admin.setAdmin_phone(obj.getString("admin_phone"));
		admin.setSuper_admin(obj.getInt("super_admin"));
		admin.setAdmin_remark(obj.getString("admin_remark"));
		int result = service.addAdmin(admin);
		if (result > 0) {
			JSONObject json = new JSONObject();
			json.put("addresult", "succeed");
			response.getWriter().print(json.toString());
		} else {
			JSONObject json = new JSONObject();
			json.put("addresult", "failed");
			response.getWriter().print(json.toString());
		}
	}
}
