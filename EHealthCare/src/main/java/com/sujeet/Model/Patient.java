package com.sujeet.Model;

public class Patient {
	private String id;
	private String password;
	private String role;
	private String name;
	private String mobile;
	private String email;
	private String address;
	private String gender;
	private String issue;
	private String image;

	public Patient(String id, String name, String mobile, String email, String address, String gender, String issue, String image) {
		this.id=id;
		this.name=name;
		this.mobile=mobile;
		this.email=email;
		this.address=address;
		this.gender=gender;
		this.issue=issue;
		this.image=image;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getIssue() {
		return issue;
	}

	public void setIssue(String issue) {
		this.issue = issue;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}