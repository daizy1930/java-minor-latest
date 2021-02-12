package com.cybage.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cybage.model.User;

@ServletSecurity(value = @HttpConstraint(rolesAllowed = { "admin", "user" }))

@WebServlet("/AppController/*")
public class AppController extends HttpServlet {
	public static final Logger log = LogManager.getLogger(AdminController.class.getName());
	private static final long serialVersionUID = 1L;

	public AppController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String path = request.getPathInfo();
		if(path.equals("/login")) {
			log.debug("Inside login in AppController ");
			if (request.isUserInRole("admin")) {
				log.debug("Inside admin of login in AppController ");
				request.getRequestDispatcher("/Admin/AdminDashboard.jsp").forward(request, response);
			}
			if (request.isUserInRole("user")) {
				log.debug("Inside user of login in AppController ");
				request.getRequestDispatcher("/user/landing.jsp").forward(request, response);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
