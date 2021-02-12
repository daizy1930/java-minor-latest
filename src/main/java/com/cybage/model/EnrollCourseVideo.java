package com.cybage.model;

import java.sql.Date;

public class EnrollCourseVideo {
	private int ecvId;
	private int userId;
	private int courseId;
	private int videoId;
	private int timeSeen;
	private int completed;
	public EnrollCourseVideo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EnrollCourseVideo(int ecvId, int userId, int courseId, int videoId, int timeSeen, int completed) {
		super();
		this.ecvId = ecvId;
		this.userId = userId;
		this.courseId = courseId;
		this.videoId = videoId;
		this.timeSeen = timeSeen;
		this.completed = completed;
	}
	
	public EnrollCourseVideo(int userId, int courseId, int videoId, int timeSeen, int completed) {
		super();
		this.ecvId = ecvId;
		this.userId = userId;
		this.courseId = courseId;
		this.videoId = videoId;
		this.timeSeen = timeSeen;
		this.completed = completed;
	}
	public int getEcvId() {
		return ecvId;
	}
	public void setEcvId(int ecvId) {
		this.ecvId = ecvId;
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
	public int getVideoId() {
		return videoId;
	}
	public void setVideoId(int videoId) {
		this.videoId = videoId;
	}
	public int getTimeSeen() {
		return timeSeen;
	}
	public void setTimeSeen(int timeSeen) {
		this.timeSeen = timeSeen;
	}
	public int getCompleted() {
		return completed;
	}
	public void setCompleted(int completed) {
		this.completed = completed;
	}
	
	
}
