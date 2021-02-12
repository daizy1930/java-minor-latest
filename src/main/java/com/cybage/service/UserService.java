package com.cybage.service;

import java.util.List;

import com.cybage.model.*;

public interface UserService {
	public int addUser(User user) throws Exception;
	public List<Course> getCourse(int id) throws Exception;
	public List<Category> getCategory() throws Exception;
	public int addEnrollement(EnrollCourse e) throws Exception;
//	getenrooll
	public int addVideoDetails(Video v);
	public List<Video> getVideo(int id) throws Exception;
	public int getentrollement(int user_id, int course_id) throws Exception;
	public List<Video >getEnrolledVideo(int id) throws Exception;
	public int getUseridByName(String name) throws Exception;
	public List<Category> searchByCategory(String search) throws Exception;
	public List<Course> searchByCourse(String search) throws Exception;
	public int getCourseid(int id) throws Exception;
	public boolean UpdateEnrollement(int course_id,int user_id) throws Exception;
	public void gencert(String user_name,String course_name);
	public boolean insertCertiDetais(String username,String coursename,int course_id,int user_id) throws Exception;
}