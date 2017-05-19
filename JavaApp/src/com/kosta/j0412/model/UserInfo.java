package com.kosta.j0412.model;

import java.util.Calendar;

public class UserInfo {
	
	private String id;
	private String pass;
	private String name;
	private int ssn1;
	private int ssn2;
	private String tel;
	private String addr;
	private String job;
	
	public UserInfo() {
		// TODO Auto-generated constructor stub
	}
	

	public UserInfo(String id, String pass, String name, int ssn1, int ssn2, String tel, String addr, String job) {
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.ssn1 = ssn1;
		this.ssn2 = ssn2;
		this.tel = tel;
		this.addr = addr;
		this.job = job;
	}
	

	public UserInfo(String id, String name, int ssn1, int ssn2, String tel, String addr) {
	
		this.id = id;
		this.name = name;
		this.ssn1 = ssn1;
		this.ssn2 = ssn2;
		this.tel = tel;
		this.addr = addr;
	}
	
	public UserInfo(String id, String name, int ssn1, int ssn2, String tel, String addr, String job) {
	
		this.id = id;
		this.name = name;
		this.ssn1 = ssn1;
		this.ssn2 = ssn2;
		this.tel = tel;
		this.addr = addr;
		this.job = job;
	}
	
	public UserInfo(String pass, String tel, String addr, String job){
		this.pass = pass;
		this.tel = tel;
		this.addr = addr;
		this.job = job;
	}


	public Object[] toObjectArray(){
		
		Object row[] = {id, name, age(ssn1), gender(ssn2), tel, addr};
		
		return row;
		
	}
	
	public int age(int ssn1){
		
		Calendar c = Calendar.getInstance();
		//객체 c에는 날짜에 관련된 모든 정보가 저장되어 있음!

		int cyear = c.get(Calendar.YEAR);
		int fullyear = 0;

		String ssn_1 = String.valueOf(ssn1);
		if(ssn_1.length() < 6){
			ssn_1 = "0" + ssn_1;
		}
		
		String ap = ssn_1.substring(0, 2);
		
		int ap_jari = Integer.parseInt(ap);
		if(ap_jari < 10){
			fullyear = 2000 + ap_jari;
		} else {
			fullyear = 1900 + ap_jari;
		}
		
		int age = cyear - fullyear + 1;
		
		return age;
	}
	
	public String gender(int ssn2){
		
		String gender = "";
		String back = String.valueOf(ssn2);
		String ap = back.substring(0,1);
		int g = Integer.parseInt(ap);
		
		if(g == 1 || g == 3 || g == 5 || g == 7){gender = "남자";}
		else if(g == 2 || g == 4 || g == 6 || g == 8){gender = "여자";}
		
		return gender;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getPass() {
		return pass;
	}


	public void setPass(String pass) {
		this.pass = pass;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getSsn1() {
		return ssn1;
	}


	public void setSsn1(int ssn1) {
		this.ssn1 = ssn1;
	}


	public int getSsn2() {
		return ssn2;
	}


	public void setSsn2(int ssn2) {
		this.ssn2 = ssn2;
	}


	public String getTel() {
		return tel;
	}


	public void setTel(String tel) {
		this.tel = tel;
	}


	public String getAddr() {
		return addr;
	}


	public void setAddr(String addr) {
		this.addr = addr;
	}


	public String getJob() {
		return job;
	}


	public void setJob(String job) {
		this.job = job;
	}
	
	

}
