package com.cybage.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.sql.rowset.serial.SerialBlob;

import org.apache.commons.io.IOUtils;

import com.cybage.dao.AdminDaoImplements;
import com.cybage.exception.CategoryException;
import com.cybage.exception.CourseException;
import com.cybage.exception.VideoException;
import com.cybage.model.Category;
import com.cybage.model.Course;
import com.cybage.model.Video;
import com.cybage.service.AdminServiceImplements;
import com.mysql.cj.jdbc.Blob;

/**
 * Servlet implementation class AdminController
 */

@WebServlet("/AdminController/*")
@MultipartConfig()
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdminDaoImplements adao=new AdminDaoImplements();
	private AdminServiceImplements aservice=new AdminServiceImplements(adao);

    /**
     * Default constructor. 
     */
    public AdminController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException,CategoryException, CourseException,VideoException{
		// TODO Auto-generated method stub
		if(request.getPathInfo().equals("/Course_getway")){
			try {
				List<Category> categories=aservice.getCategory();
				request.setAttribute("categories",categories);
				request.getRequestDispatcher("/Admin/add-course.jsp").forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.getWriter().append("in getway");
		}
		if(request.getPathInfo().equals("/update_category")){
			
			
			String name=request.getParameter("name");
			int id=Integer.parseInt(request.getParameter("id"));
			InputStream inputStream = null;
			Part filePart = request.getPart("image");
			inputStream = filePart.getInputStream();
			byte[] b=IOUtils.toByteArray(inputStream);
			Category c=new Category(id,name,inputStream);
			try {
				SerialBlob blob = new javax.sql.rowset.serial.SerialBlob(b);
				c.setImage(blob);
				boolean status=aservice.updateCategory(c);
				if(status){
					response.sendRedirect("fetch_category");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.getWriter().append(name+id);
			
		}
		if(request.getPathInfo().equals("/add_category")){
			response.getWriter().append("adding categiry");
			String category_name = request.getParameter("cname");
			InputStream inputStream = null;
			Part filePart = request.getPart("cimage");
		
			inputStream = filePart.getInputStream();
			Category c=new Category(category_name,inputStream);
			try {
				int addCount = aservice.addCategory(c);
				if (addCount>0 ) {
					System.out.println("this is added");
					response.sendRedirect("fetch_category");
					
					throw new CategoryException("ERROR IN DATA ADDITION");
				}	
				response.sendRedirect("fetch_category");
//				
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			

		}
		if(request.getPathInfo().equals("/Video_getway")){
			try {
				List<Course> courses=aservice.getCourse();
				request.setAttribute("courses",courses);
				request.getRequestDispatcher("/Admin/add-video.jsp").forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.getWriter().append("in getway");
		}
		if(request.getPathInfo().equals("/update_course")){
			
		int id=Integer.parseInt(request.getParameter("course_id"));
			String course_name = request.getParameter("course_name");
			String course_desc = request.getParameter("course_desc");
			System.out.println("I am here");
			InputStream inputStream = null;
			Part filePart = request.getPart("image");
			inputStream = filePart.getInputStream();
		byte[] b=IOUtils.toByteArray(inputStream);
		
		
			
			Course course = new Course(id,course_name, course_desc, inputStream);
			try {
				SerialBlob blob = new javax.sql.rowset.serial.SerialBlob(b);
				course.setImage(blob);
				boolean status=aservice.updateCourse(course);
				if(status){
					response.sendRedirect("fetch");
									}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(request.getPathInfo().equals("/fetch_category")){
			response.getWriter().append("Fetching data");
		
			try {
			
				List<Category> categories=aservice.getCategory();
				System.out.println("in fetch category..in admincontroller");
				request.setAttribute("categories",categories);
				request.getRequestDispatcher("/Admin/Category.jsp").forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if(request.getPathInfo().equals("/fetch")){
			response.getWriter().append("Fetching data");
			
			try {
				List<Course> courses = aservice.getCourse();
				List<Category> categories=aservice.getCategory();
				request.setAttribute("courses", courses);
				request.setAttribute("categories",categories);
				request.getRequestDispatcher("/Admin/Course.jsp").forward(request, response);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}
		if(request.getPathInfo().equals("/fetch_video")){
			response.getWriter().append("Fetching data");
			
			try {
				
				List<Video> video = aservice.getVideo();
				
				request.setAttribute("videos",video);
				
				request.getRequestDispatcher("/Admin/Video.jsp").forward(request, response);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}
		if(request.getPathInfo().equals("/update_video")){
			
			String name=request.getParameter("videoname");
			String url=request.getParameter("url");
			int duration=Integer.parseInt(request.getParameter("duration"));
			int id=Integer.parseInt(request.getParameter("id"));
			Video vid=new Video(id, name, duration, url);
			try {
				boolean status=aservice.updateVideo(vid);
				if(status){
					
					response.sendRedirect("fetch_video");
				}
				else{
					
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			response.getWriter().append(name+url+duration);
			
		}
		if(request.getPathInfo().equals("/add_video")){
			int id=Integer.parseInt(request.getParameter("course"));
			String name=request.getParameter("vname");
			String url=request.getParameter("video_url");
			int duration=Integer.parseInt(request.getParameter("duration"));
			Video vid=new Video(name,duration,url);
			try {
				int addCount=aservice.addVideo(vid, id);
				if(addCount <= 0){
					
					throw new VideoException("ERROR IN VIDEO ADDITION");
					
				}
				response.sendRedirect("fetch_video");
			} catch (Exception e) {
				System.err.println(e.getLocalizedMessage());
			}
			
		}
		if (request.getPathInfo().equals("/add_course")) {
			System.out.println("add method");
			int id=Integer.parseInt(request.getParameter("category"));
			String course_name = request.getParameter("cname");
			String course_desc = request.getParameter("cdesc");
			InputStream inputStream = null;
			Part filePart = request.getPart("cimage");
		
			inputStream = filePart.getInputStream();
			Course course = new Course(course_name, course_desc, inputStream);
			try {
				int addCount = aservice.addCourse(course,id);
				if (addCount <= 0) {
					throw new VideoException("ERROR IN COURSE ADDITION");
				}
				response.sendRedirect("fetch");
//				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		if(request.getPathInfo().equals("/delete_course")){
			try {
				boolean status=aservice.deleteCourse(Integer.parseInt(request.getParameter("id")));
				if(status){
					response.sendRedirect("fetch");
				}
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(request.getPathInfo().equals("/delete_category")){
			try {
				boolean status=aservice.deleteCategory(Integer.parseInt(request.getParameter("id")));
				if(status){
					response.sendRedirect("fetch_category");
				}
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		}
		if(request.getPathInfo().equals("/delete_video")){
			try {
				boolean status=aservice.deleteVideo(Integer.parseInt(request.getParameter("id")));
				if(status){
					response.sendRedirect("fetch_video");
				}
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}