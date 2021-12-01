package com.screenspace.service;

import java.io.IOException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.screenspace.dao.userDao;
import com.screenspace.model.userModel;

/**
 * Servlet implementation class signupService
 */
@WebServlet("/signupService")
public class signupService extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//System.out.println("signup service Fetched!");
	
		try {
		boolean valid = true;

		String uname = request.getParameter("uname");
		String pass = request.getParameter("pass");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");

		if(!isValidUname(uname)) {
			valid = false;
			request.setAttribute("uname_error", uname);
		}

		if(!isValidPassword(pass)) {
			valid = false;
			request.setAttribute("pass_error", pass);
		}
		if(!isValidPhone(phone)) {
			valid = false;
			request.setAttribute("phone_error", phone);
		}

		if(!isValidEmail(email)) {
			valid = false;
			request.setAttribute("email_error", email);
		}

		if(valid) {
		userDao uDao = new userDao();
		
		uDao.setUser(uname, pass, phone, email);
		
		HttpSession session = request.getSession();
		session.setAttribute("uname", uname);
		session.setAttribute("pass", pass);
		session.setAttribute("phone", phone);
		session.setAttribute("email", email);
		
		response.sendRedirect("wdController");
		} else {
			RequestDispatcher rd;
			rd = getServletContext().getRequestDispatcher("/");
			request.setAttribute("email", email);
			request.setAttribute("uname", uname);
			request.setAttribute("pass", pass);
			request.setAttribute("phone", phone);
			rd.forward(request, response);
		}
		}catch(Exception e) {
			
			RequestDispatcher rd = request.getRequestDispatcher("loginService");
			rd.forward(request, response);
		}
		
	}

	private boolean isValidEmail(String email) {
		String strPattern = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		return email.matches(strPattern);
	}

	private boolean isValidPhone(String phone) {
		String strPattern = "^[0-9]{10}$";
		return phone.matches(strPattern);
	}

	private boolean isValidPassword(String pass) {
		String strPattern = "^[a-zA-Z0-9]{8,20}$";
		return pass.matches(strPattern);
	}

	private boolean isValidUname(String uname) {
		String strPattern = "^[a-zA-Z0-9]{8,20}$";
		return uname.matches(strPattern);
	}

	}


