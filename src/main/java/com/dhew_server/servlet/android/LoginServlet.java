package com.dhew_server.servlet.android;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.dhew_server.dao.MybatisUtil;
import com.dhew_server.dao.UserLoginDao;
import com.dhew_server.vo.UserLoginVo;

/**
 * 
 *
 * 响应 Android客户端发来的请求
 */
public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		SqlSession session = MybatisUtil.openSession();
		UserLoginDao dao = session.getMapper(UserLoginDao.class);
		String username = request.getParameter("account");
		String password = request.getParameter("password");
		System.out.println("用户名"+username+"密码"+password+"===============登陆");
		UserLoginVo ulv=dao.getUser(username, password);
		if(ulv!=null){
			out.print("success");
		}else{
			out.print("0");
		}
		out.flush();
		out.close();
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
		System.out.println("！！！===============登陆");
	}
	public void init() throws ServletException {
	}
	
	public LoginServlet() {
		super();
	}

	public void destroy() {
		super.destroy();
	}
}
