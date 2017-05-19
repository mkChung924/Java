package com.kosta.j0412.model;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Vector;

public class UserInfoDao {
	
	Connection conn;
	Statement stmt;
	ResultSet rs;
	
	Properties pro;
	
	public UserInfoDao() {
		
		try {
			pro = new Properties();
			pro.load(new FileReader("conn/conn.properties"));
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private void connect(){
		try {
			conn = DriverManager.getConnection(pro.getProperty("url"), pro);
			System.out.println("DB연결 성공!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void disconnect(){
		try {
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();
			if(conn!=null)conn.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public boolean insert(UserInfo userinfo){
		connect();
		
		try {
			stmt = conn.createStatement();
			String sql = "insert into userinfo values('"+userinfo.getId()+"', '"+userinfo.getPass()+"', '"
			+userinfo.getName()+"', " +userinfo.getSsn1()+","+ userinfo.getSsn2()+", '"+userinfo.getTel()+"', '"
					+userinfo.getAddr()+"', '"+userinfo.getJob()+"')";
			
			System.out.println("sql : " + sql);
			stmt.executeUpdate(sql);
			
			return true;
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return false;

	}

	
	public Vector<UserInfo> selectAll(){
		connect();
		Vector<UserInfo> user = new Vector<>();
		try {
			stmt = conn.createStatement();
			String sql = "select id, name, ssn1, ssn2, tel, addr from userinfo";
			rs = stmt.executeQuery(sql);

			while(rs.next()){
				user.add(new UserInfo(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5), rs.getString(6)));
				
			}
			return user;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnect();
		}
		
		return user;

	}
	
	public boolean update(UserInfo userinfo){
		connect();
		
		try {
			stmt = conn.createStatement();
			String sql = "update userinfo set pass = '"+userinfo.getPass()+"', tel ='"+userinfo.getTel()+"', addr = '"+userinfo.getAddr()+"', job = '"+userinfo.getJob()+"'";
			System.out.println("sql :" + sql);
			
			stmt.executeUpdate(sql);
			return true;
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			disconnect();
		}
		
		return false;
	}
	
	public void delete(){
		connect();
		
		
		disconnect();
	}
	
	public Vector select4update(String id){
		Vector<UserInfo> v = new Vector<>();
		
		connect();
		
		try {
			stmt = conn.createStatement();
			String sql = "select id, name, ssn1, ssn2, tel, addr, job from userinfo where id = '"+id+"'";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				v.add(new UserInfo(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7)));
			}
					
			return v;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			disconnect();
		}
		return v;
	}
	
	public boolean selectId(String id){
		connect();
		
		try {
			stmt = conn.createStatement();
			String sql = "select id from userinfo where id = '"+id+"'";
			
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) return true;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return false;
	}
	
	public boolean select(String id, String pass){
		connect();
		
		try {
			stmt = conn.createStatement();
			String sql = "select * from userinfo where id = '"+id+"' and pass = '"+pass+"'";
			
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnect();
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		new UserInfoDao();
	}

}
