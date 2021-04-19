package com.sujeet.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sujeet.Model.Doctor;
import com.sujeet.Model.Patient;
import com.sujeet.Model.Request;
import com.sujeet.Service.DoctorService;
import com.sujeet.Service.PatientService;
import com.sujeet.Service.RequestService;

@WebServlet("/request")
public class RequestController extends HttpServlet{
	private List<Request> requests;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req , resp);
	}

	private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String opt = req.getParameter("opt");
		System.out.println(opt);
		if(opt != null) {
			int choice = Integer.parseInt(opt);
			switch (choice) {
			case 1:
				insert(req, resp);
				break;
			case 2:
				getAllRequest(req, resp);
				break;
			case 3:
				updateStatus(req, resp);
				break;
			case 4:
				removeRequest(req, resp);
				break;
			}
		}
	}

	private void updateStatus(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pid = req.getParameter("pid");
		String did = req.getParameter("did");
		String status = req.getParameter("status");
		System.out.println(pid +"\t" + did + "\t" + status);
		Request request = new Request(pid, did, status);
		System.out.println("request update");
		HttpSession hs=req.getSession(false);
		hs.setAttribute("request", request);
		resp.getWriter().print(RequestService.getRequestService().update(request));
	}

	private void removeRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("patient request remove");
		String pid = req.getParameter("pid");
		String did = req.getParameter("did");
		String status = req.getParameter("status");
		System.out.println(pid +"\t" + did + "\t" + status);
		//Doctor doctor = DoctorService.getDoctorService().getDoctorById(id);
		//resp.getWriter().print(DoctorService.getDoctorService().delete(id));
		Request request = new Request(pid, did, status);
		HttpSession hs=req.getSession(false);
		hs.setAttribute("request", request);
		resp.getWriter().print(RequestService.getRequestService().remove(request));
	}

	private void getAllRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("get all request");
		String did = req.getParameter("did");
		System.out.println(did);
		//Request requests[] = {RequestService.getRequestService().getRequestById(did)};
		List<Request> requests = RequestService.getRequestService().getAllRequest(did);
		HttpSession hs=req.getSession(false);
		hs.setAttribute("requests", requests);
		System.out.println("controller "+requests);
		resp.getWriter().print("Requests");
	}

	private void insert(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pid = req.getParameter("pid");
		String did = req.getParameter("did");
		String status = req.getParameter("status");
		System.out.println(pid +"\t" + did + "\t" + status);
		Request request = new Request(pid, did, status);
		System.out.println("request insert");
		HttpSession hs=req.getSession(false);
		hs.setAttribute("request", request);
		resp.getWriter().print(RequestService.getRequestService().insert(request));
	}
}
