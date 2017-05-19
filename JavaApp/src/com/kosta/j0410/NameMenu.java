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
	
	
	public boolean insert(String addName){ //이름 추가
		try {
			
			connect();
			stmt = conn.createStatement();
			
			String sql = "insert into names values('"+addName+"')";
			stmt.executeUpdate(sql);
			
			return true;
			
		} catch (SQLException e) {
			System.out.println("insert에러발생!");
			e.printStackTrace();
			
		} finally{
			
			//DB자원 반환!!
			disconnect();

		}//finally
		
		return false;
	}
	
	@SuppressWarnings("finally")
	public Vector<String> select(){ // 이름 저장소를 화면 출력; 모든이름 출력
		//----> DB조회된 결과를 NameMenuTest에게 전달!
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
	

	public boolean update(String oldName, String newName){ // 이름 변경
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
	

	public boolean delete(String delName){ // 이름 삭제
		
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
