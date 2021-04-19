package com.sujeet.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sujeet.Dao.Dao;
import com.sujeet.Dao.DoctorDao;
import com.sujeet.Model.Doctor;
import com.sujeet.Model.Request;
import com.sujeet.Utility.Constant;

public class DoctorService {
	private static DoctorService doctorService = new DoctorService();
	
	public static DoctorService getDoctorService() {
		return doctorService;
	}
	
	private DoctorService() {
	}
	
	public String insert(Doctor doctor) {
		String msg = "";
		try {
			msg = (DoctorDao.getDoctorDao().insert(doctor) > 0) ? "Successfully Added" : "Adding Failed";
			System.out.println(msg);
		}
		catch (Exception e) {
			msg = Constant.getMessage(e);
		}
		return msg;
	}
	
	public String update(Doctor doctor) {
		String msg="";
		try {
			msg = (DoctorDao.getDoctorDao().update(doctor) > 0) ? "Successfully Updated" : "Updation Failed";
			System.out.println(msg);
		}
		catch (Exception e) {
			msg = Constant.getMessage(e);
		}
		return msg;
	}
	
	public List<Doctor> searchByName() {
		try {
			return DoctorDao.getDoctorDao().searchByName();
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return new ArrayList<>();
	}

	public Doctor getDoctorById(String id) {
		Doctor doctor = null;
		try {
			doctor = DoctorDao.getDoctorDao().getDoctorById(id);
			}
		catch(Exception e) {
			System.out.println(e);
		}
		return doctor;
		}

	public List<Doctor> getAllDoctor() {
		try {
			return DoctorDao.getDoctorDao().getAllDoctor();
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return new ArrayList<>();
	}
	
	public String updateProfileImage(String id, String image) {
		String i="";
		try {
			i = (DoctorDao.getDoctorDao().updateProfileImage(id, image) > 0) ? "Success" : "Failed";
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return i;
	}
	
	public String delete(String id) {
		int i=0;
		try {
			i = (DoctorDao.getDoctorDao().delete(id));
		}
		catch (Exception e) {
			System.out.println(e);
		}
		i = 1;
		System.out.println(i);
		return "i";
	}

}
