package com.sujeet.Dao;

import com.sujeet.Model.Login;

public class AdminDao {
	private static AdminDao adminDao=new AdminDao();
	
	public static AdminDao getAdminDao() {
		return adminDao;
	}
	
	private AdminDao() {
	}
	
	public Login login(Login login) {
		if(login.getId().equals("1111")&&login.getPassword().equals("Admin")&&login.getRole().equals("Admin")) {
			System.out.println("verified");
		}
		else {
			System.out.println("not verified");
			login=null;
		}
		return login;
	}
}
