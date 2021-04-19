package com.sujeet.Model;

public class Doctor {
	private String id;
	private String password;
	private String role;
	private String name;
	private String mobile;
	private String email;
	private String exp;
	private String qual;
	private String spec;
	private String image;

	public Doctor(String id, String name, String mobile, String email, String exp, String qual, String spec, String image) {
		this.id=id;
		this.name=name;
		this.mobile=mobile;
		this.email=email;
		this.exp=exp;
		this.qual=qual;
		this.spec=spec;
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
	public String getExp() {
		return exp;
	}
	public void setExp(String exp) {
		this.exp = exp;
	}
	public String getQual() {
		return qual;
	}
	public void setQual(String qual) {
		this.qual = qual;
	}
	public String getSpec() {
		return spec;
	}
	public void setSpec(String spec) {
		this.spec = spec;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}

}