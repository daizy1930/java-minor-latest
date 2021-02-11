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

import com.cybage.model.User;

@ServletSecurity(value = @HttpConstraint(rolesAllowed = { "admin", "user" }))

@WebServlet("/AppController/*")
public class AppController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AppController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String path = request.getPathInfo();
		if(path.equals("/login")) {
			if (request.isUserInRole("admin")) {
				
				request.getRequestDispatcher("/Admin/AdminDashboard.jsp").forward(request, response);
			}
			if (request.isUserInRole("user")) {
				request.getRequestDispatcher("/user/view-user.jsp").forward(request, response);
			}
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
