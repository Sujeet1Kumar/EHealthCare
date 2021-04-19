package com.sujeet.Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.sujeet.Dao.FeedbackDao;
import com.sujeet.Model.Doctor;
import com.sujeet.Model.Feedback;
import com.sujeet.Service.DoctorService;
import com.sujeet.Service.FeedbackService;

@WebServlet("/feedback")
public class FeedbackController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}

	private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String opt = req.getParameter("opt");
		System.out.println(opt);
		if(opt != null) {
			int choice = Integer.parseInt(opt);
			switch (choice) {
			case 1:
				insertOrUpdate(req, resp);
				break;
			case 2:
				getAllFeedBack(req, resp);
				break;
			case 3:
				deleteFeedBack(req, resp);
				break;
			}
		}
	}

	private void deleteFeedBack(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("delete command sent by admin");
		String pid = req.getParameter("pid");
		String did = req.getParameter("did");
		System.out.println(pid+"\t"+did);
		//Doctor doctor = DoctorService.getDoctorService().getDoctorById(id);
		//resp.getWriter().print(DoctorService.getDoctorService().delete(id));
		String feedback = (String) FeedbackService.getFeedbackService().delete(pid, did);
		resp.getWriter().print(feedback);
		HttpSession hs=req.getSession(false);
		hs.removeAttribute(feedback);
	}

	private void insertOrUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pid = req.getParameter("pid");
		//String did = req.getParameter("did");
		String rate = req.getParameter("rate");
		String comment = req.getParameter("comment");
		String pname = req.getParameter("pname");
		String dnameid = req.getParameter("dname");//sujeet kumar:0001
		String pimage = req.getParameter("pimage");
		String dimage = req.getParameter("dimage");
		String [] nameid = dnameid.split(":");
		String dname = nameid[0];
		String did = nameid[1];
		System.out.println(dname);
		System.out.println(did);
		System.out.println(pid + did + rate + comment + pname + dname + pimage + dimage);
		
		Feedback feedback = FeedbackService.getFeedbackService().getFeedbackByPatientId(pid);
		if(feedback != null) {
			//update
			feedback.setPid(pid);
			feedback.setDid(did);
			feedback.setDname(dname);
			feedback.setRate(rate);
			feedback.setComment(comment);
			feedback.setPname(pname);
			feedback.setPimage(pimage);
			feedback.setDimage(dimage);
			
			resp.getWriter().print(FeedbackService.getFeedbackService().update(feedback));
			System.out.println("Feedback Controller Hit if");
		}
		else {
			//insert
		//feedback = new Feedback(pid, did, rate, comment);
		resp.getWriter().print(FeedbackService.getFeedbackService().insert(new Feedback(pid, did, rate, comment, pname, dname, pimage, dimage)));
		System.out.println("Feedback Controller Hit else");
		}
	}
	
	private void getAllFeedBack(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("get all feedback");
		List<Feedback> feedbacks = FeedbackService.getFeedbackService().getAllFeedback();
		HttpSession hs = req.getSession(false);
		hs.setAttribute("feedbacks", feedbacks);
		System.out.println("controller "+feedbacks);
		
	}
}
