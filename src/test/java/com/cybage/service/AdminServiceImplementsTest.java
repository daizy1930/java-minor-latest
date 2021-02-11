package com.cybage.service;

import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import com.cybage.dao.AdminDaoImplements;
import com.cybage.dao.AdminDaoInterface;
import com.cybage.model.Category;
import com.cybage.model.Course;
import com.cybage.model.Video;

import junit.framework.TestCase;

public class AdminServiceImplementsTest extends TestCase {

	AdminDaoInterface ad = new AdminDaoImplements();
	AdminServiceInterface as = new AdminServiceImplements((AdminDaoImplements) ad);

//	@Test
//	public void testAddCategory() throws Exception{
//		int userid = (int) Math.round(Math.random() * 99999);
//		int addCount = as.addCategory(new Category(userid,"Web Developement","abc.jpg"));
//		assertEquals(1, addCount);
//		as.deleteCategory(userid);
//	}

//	@Test
//	public void testGetCategory() throws SQLException, Exception {
//		List<Category> category = as.getCategory();
//		assertEquals(5, category.size());
//	}

//	@Test
//	public void testDeleteCategory() throws Exception {
//		boolean category = as.deleteCategory(5);
//		assertEquals(true, category);
//	}

//	@Test
//	public void testUpdateCategory() throws Exception {
//		InputStream anyInputStream = new ByteArrayInputStream("test data".getBytes());
//		
//		byte[] b= IOUtils.toByteArray(anyInputStream);
//		SerialBlob blob = new javax.sql.rowset.serial.SerialBlob(b);
//		Category category = new Category(14, "new cat_name", blob);
//	
//		boolean status = as.updateCategory(category);
//		assertEquals(true, status);
//
//		Category updatedCategory = as.getCategoryById(category.getId());
////		assertEquals(updatedCategory, category);
//		assertEquals(updatedCategory.getId(), category.getId());
//		assertEquals(updatedCategory.getName(), category.getName());
////		assertEquals(updatedCategory.getImage(), category.getImage());
//	}

//	@Test
//	public void testAddCourse() throws Exception {
//		InputStream anyInputStream = new ByteArrayInputStream("test data".getBytes());
//		int addCount = as.addCourse(new Course(12,"ABC","description",anyInputStream), 14);
//		assertEquals(1, addCount);
//		as.deleteCourse(12);
//		
//	}
	
//	@Test
//	public void testGetCourse() throws Exception {
//		List<Course> course = as.getCourse();
//		assertEquals(5, course.size());
//	}
//	
//	@Test
//	public void testDeleteCourse() throws Exception {
//		boolean course = as.deleteCourse(6);
//		assertEquals(true, course);
//	}
	
//	@Test
//	public void testUpdateCourse() throws Exception {
//		InputStream anyInputStream = new ByteArrayInputStream("test data".getBytes());
//		
//		byte[] b= IOUtils.toByteArray(anyInputStream);
//		SerialBlob blob = new javax.sql.rowset.serial.SerialBlob(b);
//		Course course = new Course(4, "new course_name","new_course_desc", blob);
//	
//		boolean status = as.updateCourse(course);
//		assertEquals(true, status);
//	}
	
//	@Test
//	public void testAddVideo() throws Exception {
//		InputStream anyInputStream = new ByteArrayInputStream("test data".getBytes());
//		int addCount = as.addVideo(new Video("video1",12,"D://abc"), 2);
//		assertEquals(1, addCount);
//		as.deleteVideo(9);
//	}
	
//	@Test
//	public void testGetVideo() throws Exception {
//		List<Video> video = as.getVideo();
//		assertEquals(4, video.size());
//	}

//	@Test
//	public void testDeleteVideo() throws Exception {
//		boolean video = as.deleteVideo(8);
//		assertEquals(true, video);
//	}
//	
	@Test
	public void testUpdateVideo() throws Exception {
		Video video = new Video(4,"new course_name",1200, "D://xyz/");

		boolean status = as.updateVideo(video);
		assertEquals(true, status);
	
	}
	
	
}
