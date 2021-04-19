package com.sujeet.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sujeet.Model.Doctor;
import com.sujeet.Model.Login;
import com.sujeet.Model.Patient;
import com.sujeet.Service.LoginService;

public class PatientDao {

	private static PatientDao patientDao=new PatientDao();
	
	public static PatientDao getPatientDao() {
		// TODO Auto-generated method stub
		return patientDao;
	}
	
	private PatientDao() {
		
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

	public List<Patient> searchByName() throws ClassNotFoundException, SQLException {
		List<Patient> patients = new ArrayList<>();
		PreparedStatement ps = Dao.getConnection().prepareStatement("select * from patient");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			patients.add(new Patient(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8)));
		}
		System.out.println(patients);
		return patients;
	}
	
	public int insert(Patient patient) throws ClassNotFoundException, SQLException {
		PreparedStatement ps = Dao.getConnection().prepareStatement("insert into patient values(?,?,?,?,?,?,?,?)");
		ps.setString(1, patient.getId());
		ps.setString(2, patient.getName());
		ps.setString(3, patient.getMobile());
		ps.setString(4, patient.getEmail());
		ps.setString(5, patient.getAddress());
		ps.setString(6, patient.getGender());
		ps.setString(7, patient.getIssue());
		ps.setString(8, patient.getImage());
		System.out.println("patient insert");
		System.out.println("patient id "+patient.getId());
		return ps.executeUpdate();
	}
	
	
	public int update(Patient patient) throws ClassNotFoundException, SQLException {
		System.out.println("update preparedstatement reached");
		PreparedStatement ps = Dao.getConnection().prepareStatement("update patient set name=?, mobile=?, email=?, address=?, gender=?, issue=? where id=?");
		ps.setString(1, patient.getName());
		ps.setString(2, patient.getMobile());
		ps.setString(3, patient.getEmail());
		ps.setString(4, patient.getAddress());
		ps.setString(5, patient.getGender());
		ps.setString(6, patient.getIssue());
		ps.setString(7, patient.getId());
		System.out.println("patient update Dao");
		System.out.println("patient id "+patient.getId());
		return ps.executeUpdate();
	}
	
	public int updateProfileImage(String id, String image) throws ClassNotFoundException, SQLException {
		PreparedStatement ps = Dao.getConnection().prepareStatement("update patient set image=? where id=?");
		ps.setString(1, image);
		ps.setString(2, id);
		return ps.executeUpdate();
	}
	
	public int insertProfileImage(Patient patient) throws ClassNotFoundException, SQLException {
		PreparedStatement ps = Dao.getConnection().prepareStatement("insert into patient values(?,?,?,?,?,?,?,?)");
		ps.setString(1, patient.getId());
		ps.setString(2, patient.getName());
		ps.setString(3, patient.getMobile());
		ps.setString(4, patient.getEmail());
		ps.setString(5, patient.getAddress());
		ps.setString(6, patient.getGender());
		ps.setString(7, patient.getIssue());
		ps.setString(8, patient.getImage());
		System.out.println("image insert");
		System.out.println("patient id "+patient.getId());
		return ps.executeUpdate();
	}
	
	public Patient getPatientById(String id) throws ClassNotFoundException, SQLException {
		Patient patient = null;
		PreparedStatement ps=Dao.getConnection().prepareStatement("select * from patient where id=?");
		ps.setString(1, id);
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
			patient = new Patient(id, rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8));
			System.out.println(id);
			System.out.println(rs.getString(2));
			System.out.println("patient dao if");
		}
		return patient;
	}
	
	public List<Patient> getAllPatient() throws ClassNotFoundException, SQLException {
		List<Patient> patients = new ArrayList<>();
		PreparedStatement ps = Dao.getConnection().prepareStatement("select * from patient");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			patients.add(new Patient(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8)));
			
		}
		System.out.println("database "+patients);
		return patients;
	}

	
	public int delete(String id) throws ClassNotFoundException, SQLException {
		
		PreparedStatement ps=Dao.getConnection().prepareStatement("delete from patient where id=?");
		ps.setString(1, id);
		ps.executeUpdate();
		
		ps=Dao.getConnection().prepareStatement("delete from login where id=?");
		ps.setString(1, id);
		
		return ps.executeUpdate();
	}
}
