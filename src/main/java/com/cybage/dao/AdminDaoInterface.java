package com.cybage.dao;

import java.sql.SQLException;
import java.util.List;

import com.cybage.model.Category;
import com.cybage.model.Course;
import com.cybage.model.Video;

public interface AdminDaoInterface {
	public int addCourse(Course c,int Category_id) throws SQLException;
	public boolean deleteCourse(int id) throws SQLException;
	public boolean deleteCategory(int id) throws SQLException;
	public boolean deleteVideo(int id) throws SQLException;
	public List<Course> getCourse() throws SQLException;
	public List<Category> getCategory() throws SQLException;
	public List<Video> getVideo() throws SQLException;
	public Course getCourseById(int id);
	public List<Course> getCourseByCid(int id);
	public boolean updateCourse(Course c) throws SQLException;
	public boolean updateVideo(Video v) throws SQLException;
	public int addVideo(Video v,int course_id) throws SQLException;
	public boolean updateCategory(Category c) throws SQLException;
	public int addCategory(Category c) throws SQLException;
	
}