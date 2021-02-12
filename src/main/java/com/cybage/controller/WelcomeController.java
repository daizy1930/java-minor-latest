package com.cybage.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cybage.dao.UserDao;
import com.cybage.dao.UserDaoImpl;
import com.cybage.model.Category;
import com.cybage.service.UserService;
import com.cybage.service.UserServiceImpl;

@WebServlet("/WelcomeController")
public class WelcomeController extends HttpServlet{
	public static final Logger log = LogManager.getLogger(AdminController.class.getName());
	private UserDao userDao = new UserDaoImpl();

	private UserService userService = new UserServiceImpl(userDao);
	public WelcomeController() {
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			log.debug("Inside WelcomeController ");
			List<Category> allCategories = null;
			try {
				allCategories = userService.getCategory();
				log.debug("allCategories:" + allCategories);
				if(allCategories == null) {
					log.debug("Bhai maltu nathi");
				}
			} catch (Exception e) {
				log.error("Error: " +e.getLocalizedMessage());
			}
			
			request.setAttribute("allCategories", allCategories);
			request.getRequestDispatcher("/index.jsp").forward(request, response);
				
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
