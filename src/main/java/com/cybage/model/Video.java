package com.cybage.model;

public class Video {
	private int id;
	private String name;
	private int duration;
	private String url;
	private String course;
	public int getId() {
		return id;
	}
	public Video(String name, int duration, String url) {
		super();
		this.name = name;
		this.duration = duration;
		this.url = url;
	}
	public Video(int id, String name, int duration, String url) {
		super();
		this.id = id;
		this.name = name;
		this.duration = duration;
		this.url = url;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public Video(int id, String name, int duration, String url, String course) {
		super();
		this.id = id;
		this.name = name;
		this.duration = duration;
		this.url = url;
		this.course = course;
	}
	public Video(String name, int duration, String url, String course) {
		super();
		this.name = name;
		this.duration = duration;
		this.url = url;
		this.course = course;
	}
	public Video() {
		super();
	}
	
}
