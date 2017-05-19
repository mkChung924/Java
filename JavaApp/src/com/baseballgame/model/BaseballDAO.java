package com.baseballgame.model;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.kosta.j0412.model.UserInfo;

public class BaseballDAO {
	
	Connection conn;
	Statement stmt;
	ResultSet rs;
	
	Properties pro;
	
	public BaseballDAO() {
		try {
			pro = new Properties();
			pro.load(new FileReader("conn/conn.properties"));
			Class.forName(pro.getProperty("driver"));
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
	
	//회원가입
	public boolean insert(UserInfo userinfo){
		connect();
		

		return false;

	}
	//로그인
	
	
	
	
	
	//디비에서 점수불러오기
	
}
