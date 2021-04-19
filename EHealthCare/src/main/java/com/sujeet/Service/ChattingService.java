package com.sujeet.Service;

import java.util.ArrayList;
import java.util.List;

import com.sujeet.Dao.ChattingDao;
import com.sujeet.Dao.DoctorDao;
import com.sujeet.Model.Chatting;
import com.sujeet.Model.Doctor;
import com.sujeet.Utility.Constant;

public class ChattingService {
	private static ChattingService chattingService = new ChattingService();
	
	public static ChattingService getChattingService() {
		return chattingService;
	}
	
	private ChattingService() {
	}
	
	public String insert(Chatting chatting) {
		String msg = "";
		try {
			msg = (ChattingDao.getChattingDao().insert(chatting) > 0) ? "send" : "failed";
			System.out.println(msg);
		}
		catch (Exception e) {
			msg = Constant.getMessage(e);
		}
		return msg;
	}

	public List<Chatting> getAllChatting() {
		try {
			return ChattingDao.getChattingDao().getAllChatting();
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return new ArrayList<>();
	}
}
