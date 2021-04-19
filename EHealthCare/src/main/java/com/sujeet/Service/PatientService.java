package com.sujeet.Service;

import java.util.ArrayList;
import java.util.List;

import com.sujeet.Dao.DoctorDao;
import com.sujeet.Dao.PatientDao;
import com.sujeet.Model.Patient;
import com.sujeet.Utility.Constant;

public class PatientService {
	private static PatientService patientService = new PatientService();
	
	public static PatientService getPatientService() {
	return patientService;
	}

	private PatientService() {
	}
	
	public String insert(Patient patient) {
		String msg = "";
		try {
			msg = (PatientDao.getPatientDao().insert(patient) > 0) ? "Successfully Added" : "Adding Failed";
			System.out.println(msg);
		}
		catch (Exception e) {
			msg = Constant.getMessage(e);
		}
		return msg;
	}
	
	public String update(Patient patient) {
		String msg="";
		try {
			msg = (PatientDao.getPatientDao().update(patient) > 0) ? "Successfully Added" : "Updation Failed";
			System.out.println(msg);
		}
		catch (Exception e) {
			msg = Constant.getMessage(e);
		}
		return msg;
	}
	
	public List<Patient> searchByName() {
		try {
			return PatientDao.getPatientDao().searchByName();
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return new ArrayList<>();
	}

	public Patient getPatientById(String id) {
		Patient patient = null;
		try {
			patient = PatientDao.getPatientDao().getPatientById(id);
			}
		catch(Exception e) {
			System.out.println(e);
		}
		return patient;
		}

	public List<Patient> getAllPatient() {
		try {
			return PatientDao.getPatientDao().getAllPatient();
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return new ArrayList<>();
	}
	
	public String updateProfileImage(String id, String image) {
		String i="";
		try {
			i = (PatientDao.getPatientDao().updateProfileImage(id, image) > 0) ? "Success" : "Failed";
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return i;
	}
	
	public String insertProfileImage(Patient patient) {
		String i="";
		try {
			i = (PatientDao.getPatientDao().insertProfileImage(patient) > 0) ? "Success" : "Failed";
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return i;
	}

	public String delete(String id) {
		int i=0;
		try {
			i = (PatientDao.getPatientDao().delete(id));
		}
		catch (Exception e) {
			System.out.println(e);
		}
		i = 1;
		System.out.println(i);
		return "i";
	}
	
}
