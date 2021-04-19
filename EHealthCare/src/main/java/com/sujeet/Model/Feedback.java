package com.sujeet.Model;

public class Feedback {

	private String pid;
	private String did;
	private String rate;
	private String comment;
	private String pname;
	private String dname;
	private String dimage;
	private String pimage;

	public Feedback(String pid, String did, String rate, String comment,String pname, String dname, String pimage, String dimage) {
		super();
		this.pid = pid;
		this.did = did;
		this.rate = rate;
		this.comment = comment;
		this.pname = pname;
		this.dname = dname;
		this.pimage = pimage;
		this.dimage = dimage;
	}
	
	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getDimage() {
		return dimage;
	}

	public void setDimage(String dimage) {
		this.dimage = dimage;
	}

	public String getPimage() {
		return pimage;
	}

	public void setPimage(String pimage) {
		this.pimage = pimage;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getDid() {
		return did;
	}

	public void setDid(String did) {
		this.did = did;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
}
