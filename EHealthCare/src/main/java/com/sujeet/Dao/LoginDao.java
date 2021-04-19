package com.sujeet.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.sujeet.Model.Doctor;
import com.sujeet.Model.Login;
import com.sujeet.Service.LoginService;

public class LoginDao {
	
	private static LoginDao loginDao=new LoginDao();

	public static LoginDao getLoginDao() {
		return loginDao;
	}
	
	private LoginDao() {
	}
	
	public Login login(Login login) {
		if(login.getRole().equalsIgnoreCase("Admin")) {
			login=AdminDao.getAdminDao().login(login);
		}
		else if(login.getRole().equalsIgnoreCase("Doctor")) {
			login=DoctorDao.getDoctorDao().login(login);
		}
		else if(login.getRole().equalsIgnoreCase("Patient")) {
			login=PatientDao.getPatientDao().login(login);
		}
		else {
			login=null;
		}
		return login;
	}
	
	public int insert(Login login) throws ClassNotFoundException, SQLException {
		int i=0;
		Connection con=Dao.getConnection();
		PreparedStatement ps=con.prepareStatement("insert into login values(?,?,?)");
		ps.setString(1, login.getId());
		ps.setString(2, login.getPassword());
		ps.setString(3, login.getRole());
		i=ps.executeUpdate();
		return i;
	}

}
