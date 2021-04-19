package com.sujeet.Service;

import java.util.ArrayList;
import java.util.List;

import com.sujeet.Dao.DoctorDao;
import com.sujeet.Dao.FeedbackDao;
import com.sujeet.Model.Doctor;
import com.sujeet.Model.Feedback;
import com.sujeet.Model.Patient;
import com.sujeet.Utility.Constant;

public class FeedbackService {
	
	private static FeedbackService feedbackService = new FeedbackService();
	
	public static FeedbackService getFeedbackService() {
		return feedbackService;
	}
	
	private FeedbackService() {
	}
	
	public String insert(Feedback feedback) {
		String msg = "";
		try {
			msg = (FeedbackDao.getFeedBackDao().insert(feedback) > 0) ? "Successfully inserted" : "Insertion Failed";
		}
		catch (Exception e) {
			msg = Constant.getMessage(e);
		}
		return msg;
	}
	
	public String update(Feedback feedback) {
		String msg = "";
		try {
			msg = (FeedbackDao.getFeedBackDao().update(feedback) > 0) ? "Successfully updated" : "Updation Failed";
		}
		catch (Exception e) {
			msg = Constant.getMessage(e);
		}
		return msg;
	}

	public List<Feedback> getAllFeedback() {
		try {
			return FeedbackDao.getFeedBackDao().getAllFeedback();
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return new ArrayList<>();
	}

	public Feedback getFeedbackByPatientId(String pid) {
		Feedback feedback = null;
		try {
			feedback = FeedbackDao.getFeedBackDao().getFeedbackById(pid);
			}
		catch(Exception e) {
			System.out.println(e);
		}
		return feedback;
		}

	public String delete(String pid,String did) {
		int i=0;
		try {
			i = (FeedbackDao.getFeedBackDao().delete(pid,did));
		}
		catch (Exception e) {
			System.out.println(e);
		}
		i = 1;
		System.out.println(i);
		return "i";
	}

}
