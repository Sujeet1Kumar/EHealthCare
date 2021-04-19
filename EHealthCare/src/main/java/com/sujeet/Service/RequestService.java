package com.sujeet.Service;

import java.util.ArrayList;
import java.util.List;

import com.sujeet.Dao.DoctorDao;
import com.sujeet.Dao.PatientDao;
import com.sujeet.Dao.RequestDao;
import com.sujeet.Model.Doctor;
import com.sujeet.Model.Patient;
import com.sujeet.Model.Request;
import com.sujeet.Utility.Constant;

public class RequestService {
	private static RequestService requestService = new RequestService();
	
	public static RequestService getRequestService() {
		return requestService;
	}
	
	private RequestService() {
	}
	
	public String insert(Request request) {
		String msg = "";
		try {
			msg = (RequestDao.getRequestDao().insert(request) > 0) ? "Request Send" : "Request Failed";
			System.out.println(msg);
		}
		catch (Exception e) {
			msg = Constant.getMessage(e);
		}
		return msg;
	}

	public String remove(Request request) {
		String msg = "";
		try {
			msg = (RequestDao.getRequestDao().remove(request) > 0) ? "Successfully Removed" : "Failed";
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return msg;
	}
	
	public List<Request> getAllRequest(String did) {
		try {
			return RequestDao.getRequestDao().getAllRequest(did);
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return new ArrayList<>();
	}

	public Request getRequestById(String did) {
		Request request = null;
		try {
			request = RequestDao.getRequestDao().getRequestById(did);
			}
		catch(Exception e) {
			System.out.println(e);
		}
		return request;
		}

	public String update(Request request) {
		String msg = "";
		try {
			msg = (RequestDao.getRequestDao().update(request) > 0) ? "Successfully Added" : "Failed";
			System.out.println(msg);
		}
		catch (Exception e) {
			msg = Constant.getMessage(e);
		}
		return msg;
	}
}
