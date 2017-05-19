package com.kosta.j0411.model;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Vector;

public class PersonDAO {
	
	Connection conn;
	Statement stmt;
	ResultSet rs;
	
	Properties pro;
	
	Vector<PersonDTO> personv;
	
	public PersonDAO() {
		try {
			pro = new Properties();
			pro.load(new FileReader("conn/conn.properties"));
			Class.forName(pro.getProperty("driver"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		personv = new Vector<>();
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

	public boolean insert(PersonDTO person){
		connect();
		try {
			stmt = conn.createStatement();
			
			String sql = "insert into person values (person_seq.nextval, "+ "'"+person.getName()+"', "+person.getAge()+", '"+person.getJob()+"')";
			stmt.executeUpdate(sql);
			
			
			return true;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return false;
	}
	public boolean update(PersonDTO person){
		
		connect();
		
		try {
			stmt = conn.createStatement();
			
			String sql = "update person set name = "+"'"+person.getName()+"', age="+person.getAge()+", job = " +"'"+person.getJob()+"' where no =" +person.getNo(); 
			String sql2 = "update person set name = '"+person.getName()+"', age = "+person.getAge()+", job = '"+person.getJob()+"' where no ="+ person.getNo();
			stmt.executeUpdate(sql2);
			
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			disconnect();
		}
		
		return false;
	}
	public void delete(int no){}
	
	public Vector getinfo(int no){
		
		Vector dto = new Vector<>();
		int i = 0;
		for(i = 0; i <= personv.size(); i++){
			if(personv.get(i).getNo() == no){
				
				break;
			}
		}
		dto.add(personv.get(i).getNo());
		dto.add(personv.get(i).getName());
		dto.add(personv.get(i).getAge());
		dto.add(personv.get(i).getJob());
		
		return dto;
	}
	
	
	public PersonDTO select(){//find, 특정행 한개를 탐색
		return null;
		
	}
	
	public Vector<PersonDTO> selectAll(){
		
		connect();
		
		try {
			stmt = conn.createStatement();
			String sql = "select no, name, age, job from person";
			
			rs = stmt.executeQuery(sql);
			personv.clear();
			while(rs.next()){
				personv.add(new PersonDTO(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4)));
			}
			return personv;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			disconnect();
		}
		
		return personv;
	}
}
