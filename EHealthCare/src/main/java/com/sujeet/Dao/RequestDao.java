package com.sujeet.Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sujeet.Model.Doctor;
import com.sujeet.Model.Patient;
import com.sujeet.Model.Request;

public class RequestDao {

	private static RequestDao requestDao=new RequestDao();
	
	public static RequestDao getRequestDao() {
		return requestDao;
	}
	
	private RequestDao() {
		
	}
	
	public int insert(Request request) throws ClassNotFoundException, SQLException {
		PreparedStatement ps = Dao.getConnection().prepareStatement("insert into request values(?,?,?)");
		ps.setString(1, request.getPid());
		ps.setString(2, request.getDid());
		ps.setString(3, request.getStatus());
		System.out.println("request insert");
		System.out.println("request id "+request.getStatus());
		System.out.println(request.getPid() + "\t" + request.getDid() + "\t" + request.getStatus());
		return ps.executeUpdate();
	}
	
	public List<Request> getAllRequest(String did) throws ClassNotFoundException, SQLException {
		List<Request> requests = new ArrayList<>();
		PreparedStatement ps = Dao.getConnection().prepareStatement("select * from request where did=?");
		ps.setString(1, did);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			requests.add(new Request(rs.getString(1), rs.getString(2), rs.getString(3)));
			
		}
		System.out.println("database "+requests);
		return requests;
	}

	public int remove(Request request) throws ClassNotFoundException, SQLException {
		PreparedStatement ps=Dao.getConnection().prepareStatement("delete from request where pid=? and did=?");
		ps.setString(1, request.getPid());
		ps.setString(2, request.getDid());
		ps.executeUpdate();
		return ps.executeUpdate();
	}

	public Request getRequestById(String did) throws ClassNotFoundException, SQLException {
		Request request = null;
		PreparedStatement ps=Dao.getConnection().prepareStatement("select * from request where did=?");
		ps.setString(1, did);
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
			request = new Request(rs.getString(1), rs.getString(2), rs.getString(3));
		}
		return request;
	}

	public int update(Request request) throws ClassNotFoundException, SQLException {
		PreparedStatement ps = Dao.getConnection().prepareStatement("update request set status=? where pid=? and did=?");
		ps.setString(1, request.getStatus());
		ps.setString(2, request.getPid());
		ps.setString(3, request.getDid());
		System.out.println("request update");
		System.out.println("request status "+request.getStatus());
		System.out.println(request.getPid() + "\t" + request.getDid() + "\t" + request.getStatus());
		return ps.executeUpdate();
	}
}
