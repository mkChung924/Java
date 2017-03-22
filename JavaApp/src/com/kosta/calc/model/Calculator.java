package com.kosta.calc.model;

import java.text.DecimalFormat;

public class Calculator {//두개의 수를 입력받아 연산 결과 데이터를 만들어주는 클래스
	private int x;
	private int y;
	private String operator;
	private int result;
	private double result2;
	private int mod;
	
	public Calculator(int x, int y, String operator) {
		this.x = x;
		this.y = y;
		this.operator = operator;
		
		choice();
	}//생성자
	
	private void choice(){//선택된 연산자에 따라 알맞은 메소드 호출!
	
		switch(operator){
		
		case "+" :
			plus();
			break;
			
		case "-" :
			minus();
			break;
		
		case "x" :
			multiply();
			break;
		
		case "/" :
			divide();
			break;
			
		default : break;
			
		}
	}
	
	public String getResult(){
		if(operator.equals("/")){
		return "결과값: " + x + operator + y + " = " + result2;
		} else {
			return "결과값: " + x + operator + y + " = " + result;
		}
	}
	
	private void plus(){
		result = x + y;
	}
	
	private void minus(){
		result = x - y;
	}
	
	private void multiply(){
		result = x * y;
	}
	
	private void divide(){
		DecimalFormat df = new DecimalFormat("#.##");
		result2 = Double.valueOf(df.format((x/(double)y)));
	}
}
