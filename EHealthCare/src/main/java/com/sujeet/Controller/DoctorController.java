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
import com.sujeet.Dao.DoctorDao;
import com.sujeet.Model.Doctor;
import com.sujeet.Service.DoctorService;

@WebServlet("/doctor")
public class DoctorController extends HttpServlet {
	private List<Doctor> doctors;
	
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
				insertOrupdateDoctor(req, resp);
				break;
			case 2:
				imageUpload(req, resp);
				break;
			case 3:
				searchDoctorByName(req, resp);
				break;
			case 4:
				getAllDoctor(req, resp);
				break;
			case 5:
				deleteDoctor(req, resp);
				break;
			}
		}
		
	}

	private void deleteDoctor(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("delete command sent by admin");
		String id = req.getParameter("did");
		System.out.println(id);
		//Doctor doctor = DoctorService.getDoctorService().getDoctorById(id);
		//resp.getWriter().print(DoctorService.getDoctorService().delete(id));
		String doctor = (String) DoctorService.getDoctorService().delete(id);
		resp.getWriter().print(doctor);
		HttpSession hs=req.getSession(false);
		hs.removeAttribute(doctor);
	}

	private void insertOrupdateDoctor(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(req.getParameter("id"));
		System.out.println(req.getParameter("name"));
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String mobile = req.getParameter("mobile");
		String email = req.getParameter("email");
		String exp = req.getParameter("exp");
		String qual = req.getParameter("qual");
		String spec = req.getParameter("spec");
		System.out.println(id);
		Doctor doctor = DoctorService.getDoctorService().getDoctorById(id);
		System.out.println(doctor);
		if (doctor != null) {
			//update
			System.out.println("update controller");
			doctor.setName(name);
			doctor.setMobile(mobile);
			doctor.setEmail(email);
			doctor.setExp(exp);
			doctor.setQual(qual);
			doctor.setSpec(spec);
			System.out.println("doctor update");
			resp.getWriter().print(DoctorService.getDoctorService().update(doctor));
			HttpSession hs=req.getSession(false);
			hs.setAttribute("doctor", doctor);
		}
		else {
			//insert	
		doctor = new Doctor(id, name, mobile, email, exp, qual, spec, "");
		System.out.println("doctor insert");
		resp.getWriter().print(DoctorService.getDoctorService().insert(doctor));
		HttpSession hs=req.getSession(false);
		hs.setAttribute("doctor", doctor);
	}
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
						Doctor doctor = (Doctor) hs.getAttribute("doctor");
						String rootlocation = req.getServletContext().getRealPath("/");
						//File folder = new File(rootlocation, "profileimages/doctor");
						
						
						File folder = new File(rootlocation, "profileimages/doctor");
						File file = new File(folder, doctor.getId() + ".jpg");
						if (!file.exists()) {
						fi.write(file);
						}
						else {
							file.delete();
							fi.write(file);
						}
						doctor.setImage(doctor.getId() + ".jpg");
						//hs.setAttribute("doctor", doctor);
						
						
						//String id = req.getParameter(doctor.getId());
						//String image = id+.j
						//Doctor doc = DoctorService.getDoctorService().getDoctorById(id);
						System.out.println(doctor.getId());
						System.out.println(doctor.getImage());
						if (doctor.getImage() != null||doctor.getImage() != "") {
							//update image
							System.out.println("image update controller");
							//doctor.setImage(id);
							System.out.println("doctor update");
							resp.getWriter().print(DoctorService.getDoctorService().updateProfileImage(doctor.getId(),doctor.getImage()));
							hs=req.getSession(false);
							hs.setAttribute("doctor", doctor);
						}
						else {
							//insert image
						//doctor = new Doctor(id, name, mobile, email, exp, qual, spec, "");
						System.out.println("doctor insert");
						//resp.getWriter().print(DoctorService.getDoctorService().insertimage(doctor));
						hs=req.getSession(false);
						hs.setAttribute("doctor", doctor);
						}
					}
				}
			}
				catch (Exception e) {
					resp.getWriter().print(e.getMessage());
				}
		}
	}

	private void searchDoctorByName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("check point 1");
		resp.setContentType("application/json");
		String name = req.getParameter("term");
		doctors = DoctorService.getDoctorService().searchByName();
		System.out.println(doctors);
		List<String> searchdoctors = search(name);
		System.out.println(searchdoctors);
		Gson g = new Gson();
		
		String jsondata = g.toJson(searchdoctors);
		System.out.println(jsondata);
		resp.getWriter().write(jsondata);
		System.out.println("check point final");
	}
	
	private List<String> search(String name) {
		List<String> names = new ArrayList();
		for (Doctor item : doctors) {
			if (item.getName().toLowerCase().startsWith(name)) {
				names.add(item.getName() + ":" + item.getId());
			}
		}
		return names;
	}

	private void getAllDoctor(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("get all doc start");
		List<Doctor> doctors = DoctorService.getDoctorService().getAllDoctor();
		HttpSession hs=req.getSession(false);
		hs.setAttribute("doctors", doctors);
		System.out.println("controller "+doctors);
	}
}