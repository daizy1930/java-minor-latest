
package com.cybage.service;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;

import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.cybage.dao.AdminDaoImplements;
import com.cybage.dao.AdminDaoInterface;
import com.cybage.model.Category;
import com.cybage.model.Course;
import com.cybage.model.Video;

class AdminServiceImplementsMock {
	private AdminDaoInterface ado = Mockito.mock(AdminDaoInterface.class);

	private AdminServiceInterface as = new AdminServiceImplements(ado);

	@Test
	public void testAddCategory() throws Exception {
		Category category = new Category(101, "Cybage", "cyb.png");
		Mockito.when(ado.addCategory(category)).thenReturn(1);

		int addCount = as.addCategory(category);
		assertEquals(1, addCount);
	}

	@Test
	public void testGetCategory() throws SQLException, Exception {
		List<Category> categories = Arrays.asList(new Category(101, "first", "first.jpeg"),
				new Category(101, "first", "first.jpeg"), new Category(101, "first", "first.jpeg"));
		Mockito.when(ado.getCategory()).thenReturn(categories);

		List<Category> fromServiceCategory = as.getCategory();
		assertIterableEquals(categories, fromServiceCategory);
	}

	@Test
	public void testDeleteCategory() throws Exception {
		Mockito.when(ado.deleteCategory(5)).thenReturn(true);

		boolean del = as.deleteCategory(5);
		assertEquals(true, del);
	}

	@Test
	public void testUpdateCategory() throws Exception {
		InputStream anyInputStream = new ByteArrayInputStream("test data".getBytes());
//		
		byte[] b = IOUtils.toByteArray(anyInputStream);
		SerialBlob blob = new javax.sql.rowset.serial.SerialBlob(b);
		Category category = new Category(7, "new cat_name", blob);
		Mockito.when(ado.updateCategory(category)).thenReturn(true);

		boolean status = as.updateCategory(category);
		assertEquals(true, status);
	}

	@Test
	public void testAddCourse() throws Exception {
		InputStream anyInputStream = new ByteArrayInputStream("test data".getBytes());
		Course course = new Course("ABC", "description", anyInputStream);
		Mockito.when(ado.addCourse(course, 14)).thenReturn(1);
		int addCount = as.addCourse(course, 14);
		System.out.println(addCount);
		assertEquals(1, addCount);
	}

	@Test
	public void testGetCourse() throws Exception {
		InputStream anyInputStream = new ByteArrayInputStream("test data".getBytes());
		List<Course> course = Arrays.asList(new Course(101, "first", "firts_name", anyInputStream),
				new Course(101, "first", "second_desc", anyInputStream),
				new Course(101, "first", "third_data", anyInputStream));
		Mockito.when(ado.getCourse()).thenReturn(course);

		List<Course> fromServiceCourse = as.getCourse();
		assertEquals(course, fromServiceCourse);
	}

	@Test
	public void testDeleteCourse() throws Exception {
		Mockito.when(ado.deleteCourse(5)).thenReturn(true);

		boolean del = as.deleteCourse(5);
		assertEquals(true, del);
	}

	@Test
	public void testUpdateCourse() throws Exception {
		InputStream anyInputStream = new ByteArrayInputStream("test data".getBytes());
//		
		byte[] b = IOUtils.toByteArray(anyInputStream);
		SerialBlob blob = new javax.sql.rowset.serial.SerialBlob(b);
		Course course = new Course(7, "new course_name", "new_course_desc", anyInputStream);
		Mockito.when(ado.updateCourse(course)).thenReturn(true);
		
		boolean status = as.updateCourse(course);
		assertEquals(true, status);
	}

	@Test
	public void testAddVideo() throws Exception {
		InputStream anyInputStream = new ByteArrayInputStream("test data".getBytes());
		Video video = new Video("video1", 12000, "D://abc");
		Mockito.when(ado.addVideo(video, 2)).thenReturn(1);
		int addCount = as.addVideo(video, 2);

		assertEquals(1, addCount);
	}

	@Test
	public void testGetVideo() throws Exception {
		InputStream anyInputStream = new ByteArrayInputStream("test data".getBytes());
		List<Video> video = Arrays.asList(new Video(11, "first", 1200, "d://"), 
									new Video(11, "first", 1200, "d://"),
									new Video(11, "first", 1200, "d://"));
		Mockito.when(ado.getVideo()).thenReturn(video);

		List<Video> fromServiceVideo = as.getVideo();
		assertEquals(video, fromServiceVideo);
	}

	@Test
	public void testDeleteVideo() throws Exception {
		Mockito.when(ado.deleteVideo(5)).thenReturn(true);

		boolean del = as.deleteVideo(5);
		assertEquals(true, del);
	}
	
	@Test
	public void testUpdateVideo() throws Exception {
		InputStream anyInputStream = new ByteArrayInputStream("test data".getBytes());
//		
		byte[] b = IOUtils.toByteArray(anyInputStream);
		SerialBlob blob = new javax.sql.rowset.serial.SerialBlob(b);
		Video video = new Video(7, "new video_name",1500,"new_video_url");
		Mockito.when(ado.updateVideo(video)).thenReturn(true);
		
		boolean status = as.updateVideo(video);
		assertEquals(true, status);
	}
}
