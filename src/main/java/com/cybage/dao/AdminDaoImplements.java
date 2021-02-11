package com.cybage.dao;

import java.awt.image.DataBuffer;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.tomcat.util.codec.binary.Base64;

import com.cybage.controller.AdminController;
import com.cybage.model.Category;
import com.cybage.model.Course;
import com.cybage.model.User;
import com.cybage.model.Video;
import com.cybage.util.DbUtil;

public class AdminDaoImplements implements AdminDaoInterface{
	public static final Logger log = LogManager.getLogger(AdminController.class.getName());
	
	public int addCourse(Course c,int Category_id) throws SQLException {
		log.debug("Inside addCourse in AdminDao");
		String sql = "insert into course(course_name,category_id,course_desc,course_image) values(?,?,?,?)";
		Connection con = null;
		try {
			con = DbUtil.getCon();
		} catch (Exception e) {
			log.error("Error: "+e.getLocalizedMessage());
		}
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, c.getName());
		ps.setString(3, c.getDesc());
		ps.setBlob(4, c.getCourse_image());
		ps.setInt(2, Category_id);
		return ps.executeUpdate();
	}

	public boolean deleteCourse(int id) throws SQLException{
		log.debug("Inside deleteCourse in AdminDao");
		String sql = "delete from course where course_id=?";
		Connection con = null;
		try {
			con = DbUtil.getCon();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		int count=ps.executeUpdate();
		if(count>0){
			return true;
		}

		// TODO Auto-generated method stub
		return false;

	}

	public List<Course> getCourse() throws SQLException {
		log.debug("Inside getCourse in AdminDao");
		String sql = "SELECT * from category c, course ce where c.category_id=ce.category_id";

		Connection con = null;
		try {
			con = DbUtil.getCon();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();

		List<Course> courses = new ArrayList<Course>();
		while (rs.next()) {
			Course course = new Course();
			course.setCategory(rs.getString(2));
			course.setId(rs.getInt(4));
			course.setName(rs.getString(5));
			course.setDesc(rs.getString(7));
			course.setCourse_image(rs.getBinaryStream(8));
			InputStream is=rs.getBinaryStream(8);
			byte[] a = rs.getBytes(8);
			String encode=Base64.encodeBase64String(a);
			course.setEncode(encode);
			courses.add(course);
		}
		return courses;
	}

	public Course getCourseById(int id) {
		log.debug("Inside getCourseById in AdminDao");
		return null;
	}

	public List<Course> getCourseByCid(int id) {
		log.debug("Inside getCourseById in AdminDao");
		return null;
	}


	public List<Category> getCategory() throws SQLException {
		log.debug("Inside getCategory in AdminDao");
		String sql = "select * from category";

		Connection con = null;
		try {
			con = DbUtil.getCon();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();

		List<Category> categories = new ArrayList<Category>();
		while (rs.next()) {
			Category category=new Category();
			category.setName(rs.getString(2));
			category.setId(rs.getInt(1));
			category.setCategory_url(rs.getString(3));
			InputStream is=rs.getBinaryStream(3);
			byte[] a=rs.getBytes(3);
			String encode=Base64.encodeBase64String(a);
			category.setEncode(encode);	
			categories.add(category);
		}
		return categories;
	}

	public List<Video> getVideo() throws SQLException {
		log.debug("Inside getVideo in AdminDao");
		String sql = "select course_name, video_name, duration,video_url, video_id from course ce join video v on ce.course_id=v.course_id;";

		Connection con = null;
		try {
			con = DbUtil.getCon();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();

		List<Video> videos = new ArrayList<Video>();
		while (rs.next()) {
			Video v=new Video();
			v.setCourse(rs.getString(1));
			v.setName(rs.getString(2));
			v.setDuration(rs.getInt(3));
			v.setUrl(rs.getString(4));
			v.setId(rs.getInt(5));
			videos.add(v);
		}

		return videos;
	}


	public boolean updateVideo(Video v) throws SQLException{
		log.debug("Inside updateVideo in AdminDao");
		String sql="update video set video_name =? ,duration=?,video_url=? where video_id=?";
		Connection con = null;
		try {
			con = DbUtil.getCon();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, v.getName());
		ps.setInt(2, v.getDuration());
		ps.setString(3, v.getUrl());
		ps.setInt(4, v.getId());
		int updateCount=ps.executeUpdate();
		if(updateCount>0){
			return true;
		}
		return false;
		// TODO Auto-generated method stub

	}
	public boolean updateCourse(Course c) throws SQLException {
		Connection con = null;
		try {
			con = DbUtil.getCon();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if(c.getImage().getBinaryStream().read()==-1) {
				String sql="UPDATE `course` SET `course_name`=?,`course_desc`=? WHERE `course_id`=?";
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setString(1, c.getName());
				ps.setString(2, c.getDesc());

				ps.setInt(3, c.getId());
				int updateCount=ps.executeUpdate();
				if(updateCount>0){
					return true;
				}
				return false;
			}
			else {


				String sql="UPDATE `course` SET `course_name`=?,`course_desc`=?,`course_url`=? WHERE `course_id`=?";

				PreparedStatement ps=con.prepareStatement(sql);
				ps.setString(1, c.getName());
				ps.setString(2, c.getDesc());
				ps.setBlob(3, c.getImage());
				ps.setInt(4, c.getId());
				int updateCount=ps.executeUpdate();
				if(updateCount>0){
					return true;
				}
				return false;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;


		// TODO Auto-generated method stub



	}


	public int addVideo(Video v, int course_id) throws SQLException {
		System.out.println("hi");
		String sql = "INSERT INTO `video`(`course_id`, `video_name`, `duration`, `video_url`) VALUES (?,?,?,?)";
		Connection con = null;
		try {
			con = DbUtil.getCon();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, course_id);
		ps.setString(2, v.getName());
		ps.setInt(3, v.getDuration());
		ps.setString(4, v.getUrl());
		return ps.executeUpdate();



	}


	public boolean updateCategory(Category c) throws SQLException {
		Connection con = null;
		try {
			con = DbUtil.getCon();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int updateCount=0;
		try {
			if(c.getImage().getBinaryStream().read()==-1) {


				PreparedStatement ps=con.prepareStatement("update category set category_name=? where category_id=?");
				ps.setString(1, c.getName());
				ps.setInt(2, c.getId());

				// TODO Auto-generated method stub
				updateCount=ps.executeUpdate();


			}
			else {

				PreparedStatement ps=con.prepareStatement("update category set category_name=?,category_url=? where category_id=?");
				ps.setString(1, c.getName());
				ps.setBlob(2, c.getImage());

				ps.setInt(3, c.getId());

				// TODO Auto-generated method stub
				updateCount=ps.executeUpdate();

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(updateCount>0){
			return true;
		}
		return false;
		// TODO Auto-generated method stub



	}


	public int addCategory(Category c) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "insert into category(category_name,category_url) values(?,?)";
		Connection con = null;
		try {
			con = DbUtil.getCon();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, c.getName());
		ps.setBlob(2, c.getCategory_image());
		return ps.executeUpdate();
	}


	public boolean deleteCategory(int id) throws SQLException {
		String sql = "delete from category where category_id=?";
		Connection con = null;
		try {
			con = DbUtil.getCon();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		int count=ps.executeUpdate();
		if(count>0){
			return true;
		}

		// TODO Auto-generated method stub
		return false;
	}


	public boolean deleteVideo(int id) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "delete from video where video_id=?";
		Connection con = null;
		try {
			con = DbUtil.getCon();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		int count=ps.executeUpdate();
		if(count>0){
			return true;
		}

		// TODO Auto-generated method stub
		return false;

	}

}
