package com.cybage.service;

import java.util.List;

import com.cybage.dao.UserDao;
import com.cybage.model.Category;
import com.cybage.model.Course;
import com.cybage.model.EnrollCourse;
import com.cybage.model.User;
import com.cybage.model.Video;

public class UserServiceImpl implements UserService{

	private UserDao userDao;
	public UserServiceImpl(UserDao userDao) {
		this.userDao = userDao;
	}
	public int addUser(User user) throws Exception {
		
		return userDao.addUser(user);
	}

	public List<Course> getCourse(int id) throws Exception {
		List<Course> course = userDao.getCourse(id);
		return course;
	}

	public List<Category> getCategory() throws Exception {
	
		return userDao.getCategory();
	}

	public int addEnrollement(EnrollCourse e) throws Exception {
		
		return userDao.addEnrollement(e);
	}

	public int addVideoDetails(Video v) {
		
		return 0;
	}

	public List<Video> getVideo(int id) throws Exception{
		List<Video> video = userDao.getVideo(id);
		return video;
	}
	public int getentrollement(int user_id, int course_id) throws Exception {
		return userDao.getentrollement(user_id, course_id);
	}
	public List<Video> getEnrolledVideo(int id) throws Exception {
		// TODO Auto-generated method stub
		return userDao.getEnrolledVideo(id);
	}
	public int getUseridByName(String name) throws Exception {
		// TODO Auto-generated method stub
		return userDao.getUseridByName(name);
	}
	public List<Category> searchByCategory(String search) throws Exception {
		return userDao.searchByCategory(search);
	}

	public List<Course> searchByCourse(String search) throws Exception {
		return userDao.searchByCourse(search);
	}
	public int getCourseid(int id) throws Exception {
		// TODO Auto-generated method stub
		return userDao.getCourseid(id);
	}
	public boolean UpdateEnrollement(int course_id, int user_id) throws Exception {
		// TODO Auto-generated method stub
		return userDao.UpdateEnrollement(course_id, user_id);
	}
	public void gencert(String user_name, String course_name) {
		userDao.gencert(user_name, course_name);
		
	}
	public boolean insertCertiDetais(String username, String coursename, int course_id, int user_id)
			throws Exception {
		// TODO Auto-generated method stub
		return userDao.insertCertiDetais(username, coursename, course_id, user_id);
	}

}