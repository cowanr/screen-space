package com.screenspace.service;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.screenspace.dao.userDao;
import com.screenspace.model.userModel;

/**
 * Servlet implementation class loginService
 */
@WebServlet("/loginService")
public class loginService extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private userDao user;

	protected void setUser(userDao usr) {
		this.user = usr;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String uname = request.getParameter("uname");
		String pass = request.getParameter("pass");
		HttpSession session = request.getSession();

		userModel user = this.user.getUser(uname, pass);
		
		if((user!=null) && (pass!=null)) {

			if (user.getUname().equals(uname) && user.getPass().equals(pass)) {

				session = request.getSession();
				session.setAttribute("uname", uname);
				session.setAttribute("pass", user.getPass());
				session.setAttribute("phone", user.getPhone());
				session.setAttribute("email", user.getEmail());

				response.sendRedirect("wdController");

			} else {
				session.setAttribute("error", "Either your username or password was not correct");
				response.sendRedirect("login.jsp");

			}

		}
		else {
			session.setAttribute("error", "Please enter a valid username and password!!");
			response.sendRedirect("login.jsp");
		}
	}

}
