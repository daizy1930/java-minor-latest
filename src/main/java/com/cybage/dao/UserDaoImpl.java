package com.cybage.dao;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.tomcat.util.codec.binary.Base64;

import com.cybage.model.*;
import com.cybage.util.DbUtil;

import java.io.FileOutputStream;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
//import com.itextpdf.text.pdf.PdfWriter;

public class UserDaoImpl implements UserDao {
	public static final Logger log = LogManager.getLogger(UserDaoImpl.class.getName());

	public int addUser(User user) throws Exception {
		System.out.println("Inside addUser in DaoImpl");

		Connection con;
		con = DbUtil.getCon();

		String sql = "INSERT INTO `java-minor`.`user` (`username`, `name`, `email`, `password`, `role`) VALUES(?,?,?,?,?)";

		PreparedStatement ps = con.prepareStatement(sql);

		ps.setString(1, user.getUsername());
		ps.setString(2, user.getName());
		ps.setString(3, user.getEmail());
		ps.setString(4, user.getPassword());
		ps.setString(5, user.getRole());
		return ps.executeUpdate();
	}

	public List<Course> getCourse(int id) throws Exception {
		Connection con = DbUtil.getCon();

		String sql = "select course_id, course_name, course_image, category_id, course_desc from course where category_id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		System.out.println("in course table category_id: " + id);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();

		List<Course> courses = new ArrayList<Course>();
		while (rs.next()) {
			Course course = new Course();
			course.setId(rs.getInt(1));
			course.setName(rs.getString(2));
			course.setCourse_image(rs.getBinaryStream(3));
			InputStream is = rs.getBinaryStream(3);
			byte[] a = rs.getBytes(3);
			String encode = Base64.encodeBase64String(a);
			System.out.println(encode);
			course.setEncode(encode);
			course.setCategory(rs.getString(4));
			course.setDesc(rs.getString(5));
			courses.add(course);
		}
		return courses;
	}

	public List<Category> getCategory() throws Exception {
		Connection con = DbUtil.getCon();
		String sql = "select category_id, category_name, category_image from category";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();

		List<Category> categories = new ArrayList<Category>();
		while (rs.next()) {
			Category category = new Category();
			category.setId(rs.getInt(1));
			category.setName(rs.getString(2));
			category.setCategory_url(rs.getString(3));
			InputStream is = rs.getBinaryStream(3);
			byte[] a = rs.getBytes(3);
			String encode = Base64.encodeBase64String(a);
			category.setEncode(encode);
			categories.add(category);
		}
		return categories;
	}

	public int addEnrollement(EnrollCourse e) throws Exception {
		System.out.println("inside add enrollement course");
		int count = 0;
		Connection con = DbUtil.getCon();
		String sql = "insert into enroll_course (user_id,course_id,completed_course,start_date) values (?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		int user_id = e.getUserId();
		int course_id = e.getCourseId();
		ps.setInt(1, user_id);
		ps.setInt(2, course_id);
		ps.setInt(3, 0);
		ps.setDate(4, e.getStartDate());
		System.out.println(user_id);
		System.out.println(course_id);

		if (ps.executeUpdate() == 1) {
			System.out.println("insidde execute");
			String sql1 = "select video_id from video where course_id=? ";
			PreparedStatement ps1 = con.prepareStatement(sql1);
			ps1.setInt(1, course_id);
			ResultSet rs = ps1.executeQuery();

			while (rs.next()) {
				int video_id = rs.getInt(1);
				String sql2 = "insert into enroll_course_video (user_id, course_id, video_id) values(?,?,?)";
				PreparedStatement ps2 = con.prepareStatement(sql2);
				ps2.setInt(1, user_id);
				ps2.setInt(2, course_id);
				ps2.setInt(3, video_id);

				ps2.executeUpdate();
			}

		} else {
			System.out.println("not doner");
		}

		return count;

	}

	public int addVideoDetails(Video v) {
		
		return 0;
	}

	public List<Video> getVideo(int id) throws Exception {
		Connection con = DbUtil.getCon();

		
		String sql = "select v.video_id, v.video_name, v.duration, v.video_url,c.course_name from video v,course c where v.course_id=c.course_id and v.course_id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();

		List<Video> videos = new ArrayList<Video>();
		while (rs.next()) {
			Video video = new Video();
			video.setId(rs.getInt(1));
			video.setName(rs.getString(2));
			video.setDuration(rs.getInt(3));
			video.setUrl(rs.getString(4));
			video.setCourse(rs.getString(5));

			videos.add(video);
		}
		return videos;
	}

	public int getentrollement(int user_id, int course_id) throws Exception {
		Connection con = DbUtil.getCon();
		String sql = "select start_date, end_date from enroll_course where user_id = ? and course_id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, user_id);
		ps.setInt(2, course_id);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			if(rs.getDate(2)!=null) {
				return 3;
			}
			return 1;
		} else {
			return 0;
		}

	}

	public List<Video> getEnrolledVideo(int id) throws Exception {
	
		String sql = "SELECT v.video_id ,v.course_id ,v.video_name,v.video_url,e.time_seen,e.completed_video from video v join enroll_course_video e where v.video_id=e.video_id and v.course_id=?";
		Connection con = DbUtil.getCon();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();

		List<Video> videos = new ArrayList<Video>();
		while (rs.next()) {
			Video v = new Video();
			v.setId(rs.getInt(1));
			v.setName(rs.getString(3));
			v.setUrl(rs.getString(4));
			videos.add(v);
		}
		System.out.println(videos.size());
		return videos;
	}

	public int getUseridByName(String name) throws Exception {
		String sql = "SELECT user_id from user where username=?";
		Connection con = DbUtil.getCon();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, name);
		ResultSet rs = ps.executeQuery();
		rs.next();
		return rs.getInt(1);
	}

	public List<Category> searchByCategory(String search) throws Exception {
	
		Connection con = DbUtil.getCon();
		String sql = "select category_id, category_name, category_image from category where category_name like ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, "%" + search + "%");
		ResultSet rs = ps.executeQuery();

		List<Category> categories = new ArrayList<Category>();
		while (rs.next()) {
			Category category = new Category();
			category.setId(rs.getInt(1));
			category.setName(rs.getString(2));
			category.setCategory_url(rs.getString(3));
			categories.add(category);
		}
		return categories;
	}

	public List<Course> searchByCourse(String search) throws Exception {
		
		Connection con = DbUtil.getCon();
		String sql = "select course_id, course_name, course_image, category_id, course_desc from course where course_name like ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, "%" + search + "%");
		ResultSet rs = ps.executeQuery();

		List<Course> courses = new ArrayList<Course>();
		while (rs.next()) {
			Course course = new Course();
			course.setId(rs.getInt(1));
			course.setName(rs.getString(2));
			course.setCourse_image(rs.getBinaryStream(3));
			course.setCategory(rs.getString(4));
			course.setDesc(rs.getString(5));
			courses.add(course);
		}
		return courses;
	}

	public String getCourseName(int id) {
		
		String sql = "select c.course_name from course c , video v where v.video_id=video_id ";
		return null;
	}

	public int getCourseid(int id) throws Exception {
		
		Connection con = DbUtil.getCon();
		String sql = "select course_id from video where video_id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		rs.next();

		return rs.getInt(1);
	}

	public boolean UpdateEnrollement(int course_id, int user_id) throws Exception {
		Connection con = DbUtil.getCon();
		String sql = "update enroll_course set completed_course=?,end_date=? where user_id=? and course_id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, 1);
		java.util.Date utilDate = new java.util.Date();
		Date startDate = new Date(utilDate.getTime());
		ps.setDate(2, startDate);
		ps.setInt(3, user_id);
		ps.setInt(4, course_id);
		int updateCount = ps.executeUpdate();
		if (updateCount > 0) {
			return true;
		}
		return false;

	}

	public void gencert(String user_name, String course_name) {
//		String FILE = "D:/TempProjectG6/src/main/webapp/Video/"+user_name+course_name+".pdf";
//		Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
//		Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL, BaseColor.RED);
//		Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD);
//		Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
//		try {
//			Document document = new Document();
//			PdfWriter.getInstance(document, new FileOutputStream(FILE));
//			document.open();
//
//			document.addTitle("My first PDF");
//			document.addSubject("Using iText");
//			document.addKeywords("Java, PDF, iText");
//			document.addAuthor("Lars Vogel");
//			document.addCreator("Lars Vogel");
//
//			Paragraph preface = new Paragraph();
//			// We add one empty line
//			addEmptyLine(preface, 1);
//			// Lets write a big header
//			preface.add(new Paragraph("Title of the document", catFont));
//
//			addEmptyLine(preface, 1);
//			// Will create: Report generated by: _name, _date
//			java.util.Date utilDate = new java.util.Date();
//			Date startDate = new Date(utilDate.getTime());
//			preface.add(new Paragraph("Report generated for: " + user_name + ", " + startDate, //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//					smallBold));
//			addEmptyLine(preface, 3);
//			preface.add(new Paragraph("This document describes something which is very important ", smallBold));
//
//			addEmptyLine(preface, 8);
//
//			preface.add(new Paragraph(
//					"This document is a preliminary version and not subject to your license agreement or any other agreement with vogella.com ;-).",
//					redFont));
//
//			document.add(preface);
//			// Start a new page
//			document.newPage();
//
//			document.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}

	  private static void addEmptyLine(Paragraph paragraph, int number) {
//		for (int i = 0; i < number; i++) {
//			paragraph.add(new Paragraph(" "));
//		}
	}

	public boolean insertCertiDetais(String username,String coursename,int cid,int uid) throws Exception {
		// TODO Auto-generated method stub
		Connection con = DbUtil.getCon();
		String sql = "insert into cert (user_id,course_id,certipath) values(?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, uid);
		ps.setInt(2,cid);
		ps.setString(3, username+coursename+".pdf");
		int addCount=ps.executeUpdate();
		if(addCount>0) {
			return true;
		}
		return false;
	}

}