package com.sujeet.Service;

import com.sujeet.Dao.LoginDao;
import com.sujeet.Model.Login;
import com.sujeet.Utility.Constant;

public class LoginService {

	private static LoginService loginService=new LoginService();
	
	private LoginService() {
	}
	
	public static LoginService getLoginService() {
		return loginService;
	}
	
	public Login login(Login login) {
		return LoginDao.getLoginDao().login(login);
	}
	
	public String addLogin(Login login) {
		String msg="";
		try {
			msg=(LoginDao.getLoginDao().insert(login) > 0)?"Successfully Added":"Added Failed";
		}
		catch(Exception e) {
			msg=Constant.getMessage(e);
			System.out.println(e);
		}
		return msg;
	}

}
