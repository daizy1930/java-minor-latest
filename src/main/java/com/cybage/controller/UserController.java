package com.cybage.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cybage.dao.UserDao;
import com.cybage.dao.UserDaoImpl;
import com.cybage.exception.UserException;
import com.cybage.model.Category;
import com.cybage.model.Course;
import com.cybage.model.EnrollCourse;
import com.cybage.model.User;
import com.cybage.model.Video;
import com.cybage.service.UserService;
import com.cybage.service.UserServiceImpl;

@WebServlet("/UserController/*")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static final Logger log = LogManager.getLogger(UserException.class.getName());
	private UserDao userDao = new UserDaoImpl();

	private UserService userService = new UserServiceImpl(userDao);

	public UserController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, UserException {
		HttpSession session = request.getSession();
		PrintWriter pw = response.getWriter();
//		pw.append("Served at: ").append(request.getContextPath());
		String path = request.getPathInfo();
		System.out.println(path);
		if (path.equals("/main")) {
			int id = 0;
			String username = request.getRemoteUser();

			try {
				id = userService.getUseridByName(username);
				System.out.println(id);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			List<Category> allCategories = null;
			try {
				allCategories = userService.getCategory();

			} catch (Exception e) {
				e.printStackTrace();
			}
			session.setAttribute("user_id", id);
			request.setAttribute("allCategories", allCategories);
			request.getRequestDispatcher("/user/landing.jsp").forward(request, response);

		}
		if (path.equals("/search")) {
			String text = request.getParameter("search");
			int searchresult = 0;
			int user_id = (Integer)session.getAttribute("user_id");
			List<Course> enrolledcoursesearch = new ArrayList<Course>();
			List<Course> newcoursesearch = new ArrayList<Course>();
			List<Course> searchedcourses = null;
			try {
				searchedcourses = userService.searchByCourse(text);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			List<Category> searchedcategories = null;
			try {
				searchedcategories = userService.searchByCategory(text);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			if(searchedcategories.size() == 0 && searchedcourses.size() == 0) {
				searchresult = 0;
				request.setAttribute("searchresult", searchresult);
			}
			for (int i = 0; i < searchedcourses.size(); i++) {
	            int course_id = searchedcourses.get(i).getId();
	            try {
				int result = userService.getentrollement(user_id, course_id);
						if(result==1) {
							enrolledcoursesearch.add(searchedcourses.get(i));
						}else{
							newcoursesearch.add(searchedcourses.get(i));	
						}		
	            	} catch (Exception e1) {
	            		e1.getLocalizedMessage();
	            		}
	        }
			request.setAttribute("searchedcourses", searchedcourses);
			request.setAttribute("enrolledcoursesearch", enrolledcoursesearch);
			request.setAttribute("newcoursesearch", newcoursesearch);
			request.setAttribute("searchedcategories", searchedcategories);
			request.getRequestDispatcher("/user/showsearch.jsp").forward(request, response);
			
			
		}
		if (path.equals("/show-courses")) {
			int category_id = Integer.parseInt(request.getParameter("category_id"));
			int user_id = (Integer) session.getAttribute("user_id");
			List<Course> course = null;
			List<Course> enrolledcourse = new ArrayList<Course>();
			List<Course> newcourse = new ArrayList<Course>();
			List<Course> completed =new ArrayList<Course>();
			try {
				course = userService.getCourse(category_id);

			} catch (Exception e) {
				e.printStackTrace();
			}

			for (int i = 0; i < course.size(); i++) {
				int course_id = course.get(i).getId();
				try {
					int result = userService.getentrollement(user_id, course_id);
					if (result == 1) {
						enrolledcourse.add(course.get(i));
					} if(result== 0){
						newcourse.add(course.get(i));
					}
					if(result==3) {
						completed.add(course.get(i));
					}
				} catch (Exception e1) {
					e1.getLocalizedMessage();
				}
			}
			request.setAttribute("enrolledcourse", enrolledcourse);
			request.setAttribute("newcourse", newcourse);
			request.setAttribute("completed", completed);
			request.getRequestDispatcher("/user/allcoursesforuser.jsp").forward(request, response);

		}

		if (path.equals("/start-course")) {
			int course_id = Integer.parseInt(request.getParameter("course_id"));
			int user_id = (Integer) session.getAttribute("user_id");

			java.util.Date utilDate = new java.util.Date();
			Date startDate = new Date(utilDate.getTime());

			EnrollCourse enroll = new EnrollCourse(user_id, course_id, startDate, null);
			try {
				userService.addEnrollement(enroll);
			} catch (Exception e) {
				e.getLocalizedMessage();
			}
			List<Video> video = null;
			Video v = null;
			try {
				video = userService.getVideo(course_id);
				v = video.get(0);
			} catch (Exception e) {
				e.printStackTrace();
			}
			request.setAttribute("video", video);
			request.setAttribute("firstVideo", v);
			request.getRequestDispatcher("/user/videodetails.jsp").forward(request, response);
		}
		if (path.equals("/continue-course")) {
			System.out.println("in continue course");
			int course_id = Integer.parseInt(request.getParameter("course_id"));
			List<Video> video = null;
			
			try {
				video = userService.getVideo(course_id);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			request.setAttribute("video", video);
			request.getRequestDispatcher("/user/videodetails.jsp").forward(request, response);
		}
		if (path.equals("/start-video")) {
			System.out.println("inside viewvideo of usercontroller");
			System.out.println("inside /start-video of usercontroller");
			int video_id = Integer.parseInt(request.getParameter("video_id"));
			System.out.println("video_id: " + video_id);
//			List<Video> video = null;
//			try {
//				video = userService.getVideo(1);
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			request.setAttribute("video", video);
//			request.getRequestDispatcher("/user/videodetails.jsp").forward(request, response);
		}

		if (path.equals("/reg")) {
			System.out.println("In reg method in UserController");

			String name = request.getParameter("name");

			String username = request.getParameter("username");
			String email = request.getParameter("email");
			String password = request.getParameter("password");

			User user = new User(name, username, email, password, "user");
			try {
				int addCount;
				addCount = userService.addUser(user);
				System.out.println("No. of users added..." + addCount);
				if (addCount <= 0) {
					throw new UserException("Could not Add User");
				}
				response.sendRedirect(request.getContextPath()+"/AppController/login");

			} catch (Exception e) {
				System.err.println(e.getLocalizedMessage());
			}

		}
		if (path.equals("/continue-course")) {
			int id = Integer.parseInt(request.getParameter("course_id"));
			List<Video> video = null;
			try {
				video = userService.getVideo(id);
			} catch (Exception e) {
				e.printStackTrace();
			}
			request.setAttribute("video", video);
			
		}

		if (path.equals("/completed_course")) {
			System.out.println("in try");
			/* response.getWriter().append(request.getParameter("course_name")); */
			String name = request.getParameter("course_name");
			int video_id = Integer.parseInt(request.getParameter("video_id"));
			int course_id = 0;
			boolean status;
			try {
				course_id = userService.getCourseid(video_id);
				int user_id = (Integer) session.getAttribute("user_id");
				
				status=userService.UpdateEnrollement(course_id,user_id);
				userService.gencert(request.getRemoteUser(), name);
				userService.insertCertiDetais(request.getRemoteUser(), name, course_id, user_id);
				request.getRequestDispatcher("/UserController/main").forward(request, response);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		}
		if (path.equals("/pdf-complete")) {
			String name = request.getParameter("course_name");
			String username = request.getRemoteUser();
			request.setAttribute("pdf-loc", username+name);
			request.getRequestDispatcher("/user/cer.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}