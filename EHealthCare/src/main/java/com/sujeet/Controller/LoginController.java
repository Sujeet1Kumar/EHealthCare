package com.sujeet.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sujeet.Model.Doctor;
import com.sujeet.Model.Login;
import com.sujeet.Model.Patient;
import com.sujeet.Service.DoctorService;
import com.sujeet.Service.LoginService;
import com.sujeet.Service.PatientService;

@WebServlet("/login")
public class LoginController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		process(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		process(req, resp);
	}
	
	private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String opt=req.getParameter("opt");
		System.out.println(opt);
		if(opt!=null) {
			int choice=Integer.parseInt(opt);
			switch(choice) {
			case 1:
				login(req, resp);
				break;
			case 2:
				register(req, resp);
				break;
			//case 3:
				//up
			case 3:
				logout(req, resp);
				/*HttpSession hs=req.getSession(false);
				hs.removeAttribute("login");
				hs.invalidate();*/
				break;
			}
		}
	}
	
	private void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession hs=req.getSession(false);
		hs.removeAttribute("login");
		hs.invalidate();
		resp.getWriter().print("Successfully Logout");
		System.out.println("Controller Hit");
	}

	private void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("id");
		String password=req.getParameter("pwd");
		String role=req.getParameter("role");
		Login login=new Login(id,password,role);
		resp.getWriter().print(LoginService.getLoginService().addLogin(login));
		System.out.println("Controller Hit");
	}

	private void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(req.getSession(false)!=null) {
			String id=req.getParameter("id");
			String password=req.getParameter("pwd");
			String role=req.getParameter("role");
			
			//System.out.println(id+pwd+role);
			
			Login login=new Login(id,password,role);
			
			Login LoginAuth=LoginService.getLoginService().login(login);
			
			if(LoginAuth!=null) {
				HttpSession hs = req.getSession();
				hs.setAttribute("login", login);
				if (role.equalsIgnoreCase("Doctor")) {
					Doctor doctor = DoctorService.getDoctorService().getDoctorById(id);
					hs.setAttribute("doctor", doctor);
				}else if (role.equalsIgnoreCase("Patient")) {
					Patient patient = PatientService.getPatientService().getPatientById(id);
					hs.setAttribute("patient", patient);
				}
				resp.getWriter().print("Successfully Login");
				System.out.println("Controller Hit");
			}
			else {
				resp.getWriter().print("Invalid User Id Or Password");
				System.out.println("Controller Hit");
			}
		}
	}
}