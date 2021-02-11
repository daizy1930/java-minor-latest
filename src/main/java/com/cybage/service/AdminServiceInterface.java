package com.cybage.service;

import java.sql.SQLException;
import java.util.List;

import com.cybage.model.Category;
import com.cybage.model.Course;
import com.cybage.model.Video;

public interface AdminServiceInterface {
	public int addCourse(Course c,int category_id) throws Exception;
	public boolean deleteCourse(int id) throws Exception;
	public boolean deleteCategory(int id) throws Exception;
	public boolean deleteVideo(int id) throws Exception;
	public List<Course> getCourse() throws Exception;
	public Course getCourseById(int id);
	public List<Course> getCourseByCid(int id);
	public boolean updateCourse(Course c) throws Exception;
	public List<Category> getCategory() throws SQLException, Exception;
	public List<Video> getVideo() throws Exception;
	public boolean updateVideo(Video v) throws Exception;
	public int addVideo(Video vid,int Course_id) throws Exception;
	public boolean updateCategory(Category c) throws Exception;
	public int addCategory(Category c) throws Exception;

}