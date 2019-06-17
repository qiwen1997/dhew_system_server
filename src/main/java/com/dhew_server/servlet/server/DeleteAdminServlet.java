package com.dhew_server.servlet.server;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dhew_server.service.server.DpAdminService;

@WebServlet("/DeleteAdminServlet")
public class DeleteAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public DeleteAdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		DpAdminService service = new DpAdminService();
		String Sadmin_id = request.getParameter("admin_id");
		Integer admin_id = Integer.valueOf(Sadmin_id);
		service.deleteAdmin(admin_id);
	}
}
