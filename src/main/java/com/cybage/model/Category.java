package com.cybage.model;

import java.io.InputStream;

import javax.sql.rowset.serial.SerialBlob;

public class Category {
	private int id;
	private String name;
	private String category_url;
	private InputStream category_image;
	private String encode;
	private SerialBlob image;
	public SerialBlob getImage() {
		return image;
	}
	public void setImage(SerialBlob image) {
		this.image = image;
	}
	public Category(int id, String name, InputStream category_image) {
		super();
		this.id = id;
		this.name = name;
		this.category_image = category_image;
	}
	public int getId() {
		return id;
	}
	public Category(String name, InputStream category_image) {
		super();
		this.name = name;
		this.category_image = category_image;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public InputStream getCategory_image() {
		return category_image;
	}
	public void setCategory_image(InputStream category_image) {
		this.category_image = category_image;
	}
	public String getEncode() {
		return encode;
	}
	public void setEncode(String encode) {
		this.encode = encode;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory_url() {
		return category_url;
	}
	public void setCategory_url(String category_url) {
		this.category_url = category_url;
	}
	public Category(int id, String name, String category_url) {
		super();
		this.id = id;
		this.name = name;
		this.category_url = category_url;
	}

	public Category(String name, String category_url) {
		super();
		this.name = name;
		this.category_url = category_url;
	}
	public Category() {
		// TODO Auto-generated constructor stub
	}
	public Category(int id2, String name2, SerialBlob image) {
		super();
		this.id = id2;
		this.name = name2;
		this.image = image;
	}

}
