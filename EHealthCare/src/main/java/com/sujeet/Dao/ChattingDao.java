package com.sujeet.Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sujeet.Model.Chatting;
import com.sujeet.Model.Doctor;

public class ChattingDao {

	private static ChattingDao chattingDao=new ChattingDao();
	
	public static ChattingDao getChattingDao() {
		return chattingDao;
	}
	
	private ChattingDao() {
	}
	
	public int insert(Chatting chatting) throws ClassNotFoundException, SQLException {
		PreparedStatement ps = Dao.getConnection().prepareStatement("insert into chatting values(?)");
		ps.setString(1, chatting.getMessage());
		System.out.println("chatting insert");
		return ps.executeUpdate();
	}

	public List<Chatting> getAllChatting() throws ClassNotFoundException, SQLException {
		List<Chatting> chattings = new ArrayList<>();
		PreparedStatement ps = Dao.getConnection().prepareStatement("select * from chatting");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			chattings.add(new Chatting(rs.getString(1)));
			
		}
		System.out.println("database "+chattings);
		return chattings;
	}
}
