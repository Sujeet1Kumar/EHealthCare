package com.sujeet.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.sujeet.Model.Doctor;
import com.sujeet.Model.Login;
import com.sujeet.Service.LoginService;

public class DoctorDao {

	private static DoctorDao doctorDao=new DoctorDao();
	
	public static DoctorDao getDoctorDao() {
		return doctorDao;
	}
	
	private DoctorDao() {
		
	}

	public Login login(Login login) {
		Connection con;
		try {
			con = Dao.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from login where id=? and password=? and role=?");
			ps.setString(1, login.getId());
			ps.setString(2, login.getPassword());
			ps.setString(3, login.getRole());
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				System.out.println("valid user");
			}
			else {
				System.out.println("invalid");
				login=null;
			}
		} catch (Exception e) {
			System.out.println(e);
			login=null;
		}
		
		return login;
	}
	
	public List<Doctor> searchByName() throws ClassNotFoundException, SQLException {
		List<Doctor> doctors = new ArrayList<>();
		PreparedStatement ps = Dao.getConnection().prepareStatement("select * from doctor");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			doctors.add(new Doctor(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8)));
		}
		System.out.println(doctors);
		return doctors;
	}
	
	public int insert(Doctor doctor) throws ClassNotFoundException, SQLException {
		PreparedStatement ps = Dao.getConnection().prepareStatement("insert into doctor values(?,?,?,?,?,?,?,?)");
		ps.setString(1, doctor.getId());
		ps.setString(2, doctor.getName());
		ps.setString(3, doctor.getMobile());
		ps.setString(4, doctor.getEmail());
		ps.setString(5, doctor.getExp());
		ps.setString(6, doctor.getQual());
		ps.setString(7, doctor.getSpec());
		ps.setString(8, doctor.getImage());
		System.out.println("doctor insert");
		System.out.println("doctor id "+doctor.getId());
		return ps.executeUpdate();
	}
	
	
	public int update(Doctor doctor) throws ClassNotFoundException, SQLException {
		System.out.println("update preparedstatement reached");
		PreparedStatement ps = Dao.getConnection().prepareStatement("update doctor set name=?, mobile=?, email=?, exp=?, qual=?, spec=? where id=?");
		ps.setString(1, doctor.getName());
		ps.setString(2, doctor.getMobile());
		ps.setString(3, doctor.getEmail());
		ps.setString(4, doctor.getExp());
		ps.setString(5, doctor.getQual());
		ps.setString(6, doctor.getSpec());
		ps.setString(7, doctor.getId());
		System.out.println("doctor update Dao");
		System.out.println("doctor id "+doctor.getId());
		return ps.executeUpdate();
	}
	
	public int updateProfileImage(String id, String image) throws ClassNotFoundException, SQLException {
		PreparedStatement ps = Dao.getConnection().prepareStatement("update doctor set image=? where id=?");
		ps.setString(1, image);
		ps.setString(2, id);
		return ps.executeUpdate();
	}
	
	public Doctor getDoctorById(String id) throws ClassNotFoundException, SQLException {
		Doctor doctor = null;
		PreparedStatement ps=Dao.getConnection().prepareStatement("select * from doctor where id=?");
		ps.setString(1, id);
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
			doctor = new Doctor(id, rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8));
			System.out.println(id);
			System.out.println("doctor dao if");
		}
		return doctor;
	}
	
	public List<Doctor> getAllDoctor() throws ClassNotFoundException, SQLException {
		List<Doctor> doctors = new ArrayList<>();
		PreparedStatement ps = Dao.getConnection().prepareStatement("select * from doctor");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			doctors.add(new Doctor(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8)));
		}
		System.out.println("database "+doctors);
		return doctors;
	}
	
	public int delete(String id) throws ClassNotFoundException, SQLException {
		PreparedStatement ps=Dao.getConnection().prepareStatement("delete from doctor where id=?");
		ps.setString(1, id);
		ps.executeUpdate();
		ps=Dao.getConnection().prepareStatement("delete from login where id=?");
		ps.setString(1, id);
		return ps.executeUpdate();
	}
	
}
