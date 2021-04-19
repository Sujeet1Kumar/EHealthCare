package com.sujeet.Chatting;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sujeet.Model.Chatting;
import com.sujeet.Model.Doctor;
import com.sujeet.Service.ChattingService;
import com.sujeet.Service.DoctorService;

@WebServlet("/chatting")
public class ChattingController extends HttpServlet {

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}
	
	private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("chat hit");
		String opt = req.getParameter("opt");
		System.out.println(opt);
		if(opt != null) {
			int choice = Integer.parseInt(opt);
			switch (choice) {
			case 1:
				insert(req, resp);
				break;
			case 2:
				fetch(req, resp);
			}
		}
	}

	private void insert(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("insert hit");
		String message = req.getParameter("chatarea");
		System.out.println(message);
			
		Chatting chatting = new Chatting(message);
		System.out.println("chat insert");
		//resp.getWriter().print(ChattingService.getChattingService().insert(chatting));
		ChattingService.getChattingService().insert(chatting);
		HttpSession hs=req.getSession(false);
		hs.setAttribute("chattings", chatting);
		//System.out.println(ChattingService.getChattingService().insert(chatting));
		System.out.println("inserted");
	}
	
	private void fetch(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("fetch hit");
		List<Chatting> chattings = ChattingService.getChattingService().getAllChatting();
		HttpSession hs=req.getSession(false);
		hs.setAttribute("chattings", chattings);
		//resp.getWriter().print(ChattingService.getChattingService().getAllChatting());
		System.out.println("controller "+chattings);
	}

}
