package com.sujeet.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sujeet.Model.Doctor;
import com.sujeet.Model.Feedback;

public class FeedbackDao {
	
	private static FeedbackDao feedbackDao = new FeedbackDao();
	
	public static FeedbackDao getFeedBackDao() {
		return feedbackDao;
	}
	
	private FeedbackDao() {	
	}
	
	public int insert(Feedback feedback) throws ClassNotFoundException, SQLException {
		PreparedStatement ps = Dao.getConnection().prepareStatement("insert into feedback values(?,?,?,?,?,?,?,?)");
		ps.setString(1, feedback.getPid());
		ps.setString(2, feedback.getDid());
		ps.setString(3, feedback.getRate());
		ps.setString(4, feedback.getComment());
		ps.setString(5, feedback.getPname());
		ps.setString(6, feedback.getDname());
		ps.setString(7, feedback.getPimage());
		ps.setString(8, feedback.getDimage());
		System.out.println("feedback insert");
		System.out.println(feedback.getPid());
		return ps.executeUpdate();
		}
	
	public int update(Feedback feedback) throws ClassNotFoundException, SQLException {
		PreparedStatement ps = Dao.getConnection().prepareStatement("update feedback set did=?, rate=?, comment=?, pname=?, dname=?, pimage=?, dimage=? where pid=?");
		ps.setString(1, feedback.getDid());
		ps.setString(2, feedback.getRate());
		ps.setString(3, feedback.getComment());
		ps.setString(4, feedback.getPname());
		ps.setString(5, feedback.getDname());
		ps.setString(6, feedback.getPimage());
		ps.setString(7, feedback.getDimage());
		ps.setString(8, feedback.getPid());
		
		System.out.println("feedback update");
		System.out.println(feedback.getPid());
		return ps.executeUpdate();
	}

	public List<Feedback> getAllFeedback() throws ClassNotFoundException, SQLException {
		List<Feedback> feedbacks = new ArrayList<>();
		PreparedStatement ps = Dao.getConnection().prepareStatement("select * from feedback");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			feedbacks.add(new Feedback(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8)));
		}
		System.out.println("database "+feedbacks);
		return feedbacks;
	}

	public Feedback getFeedbackById(String pid) throws ClassNotFoundException, SQLException {
		Feedback feedback = null;
		PreparedStatement ps=Dao.getConnection().prepareStatement("select * from feedback where pid=?");
		ps.setString(1, pid);
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
			feedback = new Feedback(pid, rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8));
			System.out.println(pid);
			System.out.println("doctor dao if");
		}
		return feedback;
	}

	public int delete(String pid,String did) throws ClassNotFoundException, SQLException {
		
		PreparedStatement ps=Dao.getConnection().prepareStatement("delete from feedback where pid=? and did=?");
		ps.setString(1, pid);
		ps.setString(2, did);
		
		return ps.executeUpdate();
	}
}
