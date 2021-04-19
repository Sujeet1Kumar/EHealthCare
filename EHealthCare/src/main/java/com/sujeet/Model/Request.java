package com.sujeet.Model;

public class Request {

	private String pid;
	private String did;
	private String status;

	public Request(String pid, String did, String status) {
		super();
		this.pid = pid;
		this.did = did;
		this.status = status;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
