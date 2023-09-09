package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Consultant;

public class ConsultantDao {
	private Connection conn;

	public ConsultantDao(Connection conn) {
		super();
		this.conn = conn;
	}
	
	public boolean registerConsultant(Consultant c)
	{
		boolean f=false;
		
		try {
			String sql ="insert into consultant(full_name,dob,qualification,specialist,email,mobno,password) values(?,?,?,?,?,?,?)";
					PreparedStatement ps=conn.prepareStatement(sql);
					ps.setString(1, c.getFullName());
					ps.setString(2, c.getDob());
					ps.setString(3, c.getQualification());
					ps.setString(4, c.getSpecialist());
					ps.setString(5, c.getEmail());
					ps.setString(6, c.getMobNo());
					ps.setString(7, c.getPassword());
					
					int i =ps.executeUpdate();
					if(i==1)
					{
						f=true;
					}
		} catch (Exception e) {
		   e.printStackTrace();
		}
		
		return f;
	}
	
	public List<Consultant> getAllConsultant()
	{
		List<Consultant> list=new ArrayList<Consultant>();
		Consultant c =null;
		try {
			String sql="select * from consultant order by id desc";
			PreparedStatement ps=conn.prepareStatement(sql);
			
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				c =new Consultant();
				c.setId(rs.getInt(1));
				c.setFullName(rs.getString(2));
				c.setDob(rs.getString(3));
				c.setQualification(rs.getString(4));
				c.setSpecialist(rs.getString(5));
				c.setEmail(rs.getString(6));
				c.setMobNo(rs.getString(7));
				c.setPassword(rs.getString(7));
				list.add(c);
			}
		} catch (Exception e) {
			
		}
		return list;
	}
	public Consultant getConsultantById(int id)
	{
		
		Consultant c = null;
		try {
			String sql = "select * from consultant where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				c = new Consultant();
				c.setId(rs.getInt(1));
				c.setFullName(rs.getString(2));
				c.setDob(rs.getString(3));
				c.setQualification(rs.getString(4));
				c.setSpecialist(rs.getString(5));
				c.setEmail(rs.getString(6));
				c.setMobNo(rs.getString(7));
				c.setPassword(rs.getString(7));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return c;
	}
	
	public boolean updateConsultant(Consultant c)
	{
		boolean f=false;
		
		try {
			String sql ="update consultant set full_name=?,dob=?,qualification=?,specialist=?,email=?,mobno=?,password=? where id=?";
					PreparedStatement ps=conn.prepareStatement(sql);
					ps.setString(1, c.getFullName());
					ps.setString(2, c.getDob());
					ps.setString(3, c.getQualification());
					ps.setString(4, c.getSpecialist());
					ps.setString(5, c.getEmail());
					ps.setString(6, c.getMobNo());
					ps.setString(7, c.getPassword());
					ps.setInt(8, c.getId());
					
					int i =ps.executeUpdate();
					if(i==1)
					{
						f=true;
					}
		} catch (Exception e) {
		   e.printStackTrace();
		}
		
		return f;
	}
	
	public boolean deleteConsultant(int id)
	{
		boolean f=false;
		
		try {
			String sql="delete from consultant where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,id);
			
			int i =ps.executeUpdate();
		if(i==1) {
			f=true;
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
	public Consultant login(String email, String psw) {
		Consultant c = null;
		try {

			String sql = "select * from consultant where email=? and password=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, psw);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				c = new Consultant();
				c = new Consultant();
				c.setId(rs.getInt(1));
				c.setFullName(rs.getString(2));
				c.setDob(rs.getString(3));
				c.setQualification(rs.getString(4));
				c.setSpecialist(rs.getString(5));
				c.setEmail(rs.getString(6));
				c.setMobNo(rs.getString(7));
				c.setPassword(rs.getString(8));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return c;
	}
	
	public int countUser() {
		int i = 0;
		try {
			String sql = "select * from user_details";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				i++;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return i;
	}
	
	public int countSpecialist() {
		int i = 0;
		try {
			String sql = "select * from specialist";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				i++;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return i;
	}
	
	public int countConsultant() {
		int i = 0;
		try {
			String sql = "select * from consultant";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				i++;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return i;
	}
	public int countAppointment() {
		int i = 0;
		try {
			String sql = "select * from appointments";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				i++;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return i;
	}

	public int countAppointmentByConsultantId(int did) {
		int i = 0;
		try {
			String sql = "select * from appointments where consultant_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, did);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				i++;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return i;
	}
	
	public boolean checkOldPassword(int userid, String oldPassword) {
		boolean f = false;

		try {
			String sql = "select * from consultant where id=? and password=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userid);
			ps.setString(2, oldPassword);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}

	public boolean changePassword(int userid, String newPassword) {
		boolean f = false;

		try {
			String sql = "update consultant set password=? where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, newPassword);
			ps.setInt(2, userid);

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}

	public boolean editConsultantProfile(Consultant c) {
		boolean f = false;

		try {
			String sql = "update consultant set full_name=?,dob=?,qualification=?,specialist=?,email=?,mobno=? where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, c.getFullName());
			ps.setString(2, c.getDob());
			ps.setString(3, c.getQualification());
			ps.setString(4, c.getSpecialist());
			ps.setString(5, c.getEmail());
			ps.setString(6, c.getMobNo());
			ps.setInt(7, c.getId());
			int i = ps.executeUpdate();

			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}
}

