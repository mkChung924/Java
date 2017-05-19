package com.kosta.j0410;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class NameMenu {
	Connection conn;
	Statement stmt;
	ResultSet rs;
	String url;
	String user;
	String password;
		
	public NameMenu() {
		
		try {
			getClass().forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		url = "jdbc:oracle:thin:@//localhost:1521/orcl";
		user = "scott2";
		password = "tiger";
		
	}
	
	public void connect(){
		
		try{
			conn = DriverManager.getConnection(url, user, password);
		} catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public void disconnect(){
		try {
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();
			if(conn!=null)conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public boolean insert(String addName){ //�̸� �߰�
		try {
			
			connect();
			stmt = conn.createStatement();
			
			String sql = "insert into names values('"+addName+"')";
			stmt.executeUpdate(sql);
			
			return true;
			
		} catch (SQLException e) {
			System.out.println("insert�����߻�!");
			e.printStackTrace();
			
		} finally{
			
			//DB�ڿ� ��ȯ!!
			disconnect();

		}//finally
		
		return false;
	}
	
	@SuppressWarnings("finally")
	public Vector<String> select(){ // �̸� ����Ҹ� ȭ�� ���; ����̸� ���
		//----> DB��ȸ�� ����� NameMenuTest���� ����!
		Vector<String> v = new Vector<>();
		
		try {
			connect();
			stmt = conn.createStatement();
			String sql = "select name from names";
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				String name = rs.getString(1);
				v.add(name);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		
		} finally{
			disconnect();
			return v;
		}
			
	}
	

	public boolean update(String oldName, String newName){ // �̸� ����
		int change = 0;
		try {
			connect();
			stmt = conn.createStatement();
			String sql = "update names set name ='" +newName + "' where name ='" + oldName+ "'";
			
			change = stmt.executeUpdate(sql);
			if(change!=0) {
				return true;
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			disconnect();

		}
		return false;
	}
	

	public boolean delete(String delName){ // �̸� ����
		
		int change = 0;
		
		try {
			connect();
			stmt = conn.createStatement();
			String sql = "delete from names where name ='"+delName+"'";
			change = stmt.executeUpdate(sql);
			if(change!=0){
				return true;
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			
			disconnect();
		}
	return false;
	
	}
		


}
