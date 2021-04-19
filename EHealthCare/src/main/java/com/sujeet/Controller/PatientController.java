package com.sujeet.Controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.google.gson.Gson;
import com.sujeet.Model.Doctor;
import com.sujeet.Model.Patient;
import com.sujeet.Service.DoctorService;
import com.sujeet.Service.PatientService;

@WebServlet("/patient")
public class PatientController extends HttpServlet {
	private List<Patient> patients;
	
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
				insertOrupdatePatient(req, resp);
				break;
			case 2:
				imageUpload(req, resp);
				break;
			case 3:
				getAllPatient(req, resp);
				break;	
			case 4:
				deleteAllPatient(req, resp);
			}
		}
		
	}

	private void deleteAllPatient(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("delete command sent by admin");
		String id = req.getParameter("pid");
		System.out.println(id);
		//Doctor doctor = DoctorService.getDoctorService().getDoctorById(id);
		//resp.getWriter().print(DoctorService.getDoctorService().delete(id));
		String patient = (String) PatientService.getPatientService().delete(id);
		resp.getWriter().print(patient);
		HttpSession hs=req.getSession(false);
		hs.removeAttribute(patient);
	}
	
	private void getAllPatient(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("get all pat start");
		List<Patient> patients = PatientService.getPatientService().getAllPatient();
		HttpSession hs=req.getSession(false);
		hs.setAttribute("patients", patients);
		System.out.println("controller "+patients);
	}

	private void insertOrupdatePatient(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(req.getParameter("id"));
		System.out.println(req.getParameter("name"));
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String mobile = req.getParameter("mobile");
		String email = req.getParameter("email");
		String address = req.getParameter("address");
		String gender = req.getParameter("gender");
		String issue = req.getParameter("issue");
		System.out.println(id);
		Patient patient = PatientService.getPatientService().getPatientById(id);
		System.out.println(patient);
		if (patient != null) {
			//update
			System.out.println("update controller");
			patient.setName(name);
			patient.setMobile(mobile);
			patient.setEmail(email);
			patient.setAddress(address);
			patient.setGender(gender);
			patient.setIssue(issue);
			System.out.println("patient update");
			resp.getWriter().print(PatientService.getPatientService().update(patient));
			HttpSession hs=req.getSession(false);
			hs.setAttribute("patient", patient);
		}
		else {
			//insert	
		patient = new Patient(id, name, mobile, email, address, gender, issue, "");
		System.out.println("patient insert");
		HttpSession hs=req.getSession(false);
		hs.setAttribute("patient", patient);
		resp.getWriter().print(PatientService.getPatientService().insert(patient));
	}
	}
/*
	private void searchPatientByName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		String name = req.getParameter("term");
		patients = PatientService.getPatientService().searchByName();
		System.out.println(doctors);
		List<String> searchpatients = search(name);
		System.out.println(searchpatients);
		Gson g = new Gson();
		
		String jsondata = g.toJson(searchpatients);
		System.out.println(jsondata);
		resp.getWriter().write(jsondata);
	}
	*/
	private List<String> search(String name) {
		List<String> names = new ArrayList();
		for (Patient item : patients) {
			if (item.getName().toLowerCase().startsWith(name)) {
				names.add(item.getName() + ":" + item.getId());
			}
		}
		return names;
	}

	private void imageUpload(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setFileSizeMax(50 * 1024 * 1024);
		upload.setSizeMax(100 * 1024 * 1024);
		upload.setHeaderEncoding("uft-8");
		if (ServletFileUpload.isMultipartContent(req)) {
			try {
				List<FileItem> list = upload.parseRequest(req);
				Iterator<FileItem> it = list.iterator();
				while (it.hasNext()) {
					FileItem fi = it.next();
					if (!fi.isFormField()) {
						HttpSession hs = req.getSession(false);
						Patient patient = (Patient) hs.getAttribute("patient");
						String rootlocation = req.getServletContext().getRealPath("/");
						//File folder = new File(rootlocation, "profileimages/doctor");
						
						
						File folder = new File(rootlocation, "profileimages/patient");
						File file = new File(folder, patient.getId() + ".jpg");
						if (!file.exists()) {
						fi.write(file);
						}
						else {
							file.delete();
							fi.write(file);
						}
						patient.setImage(patient.getId() + ".jpg");
						
						//String id = req.getParameter(doctor.getId());
						//String image = id+.j
						//Doctor doc = DoctorService.getDoctorService().getDoctorById(id);
						System.out.println(patient.getId());
						System.out.println(patient.getImage());
						if (patient.getImage() != null||patient.getImage() == "") {
							//update image
							System.out.println("image update controller");
							//doctor.setImage(id);
							System.out.println("patient update");
							hs=req.getSession(false);
							hs.setAttribute("patient", patient);
							resp.getWriter().print(PatientService.getPatientService().updateProfileImage(patient.getId(),patient.getImage()));
						}
						else {
							//insert image
						//doctor = new Doctor(id, name, mobile, email, exp, qual, spec, "");
						System.out.println("patient insert");
						//hs=req.getSession(false);
						//hs.setAttribute("patient", patient);
						resp.getWriter().println("Cannot invoke \"com.sujeet.Model.Patient.getId()\" because \"patient\" is null mine");
						}
					}
				}
			}
				catch (Exception e) {
					resp.getWriter().print(e.getMessage());
					System.out.println(e.getMessage());
				}
		}
	}
}
