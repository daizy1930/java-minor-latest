package com.cybage.model;

import java.sql.Date;

public class EnrollCourse {
	private int e_id;
	private int userId;
	private int courseId;
	private Date startDate;
	private Date endDate;

	public int getE_id() {
		return e_id;
	}

	public void setE_id(int e_id) {
		this.e_id = e_id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public EnrollCourse(int e_id, int userId, int courseId, Date startDate, Date endDate) {
		super();
		this.e_id = e_id;
		this.userId = userId;
		this.courseId = courseId;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public EnrollCourse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EnrollCourse(int userId, int courseId, Date startDate, Date endDate) {
		super();

		this.userId = userId;
		this.courseId = courseId;
		this.startDate = startDate;
		this.endDate = endDate;
	}

}
