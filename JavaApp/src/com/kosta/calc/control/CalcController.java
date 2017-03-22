package com.kosta.calc.control;

import com.kosta.calc.view.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.kosta.calc.model.*;

public class CalcController implements ActionListener {
	/*
	 * Controller - 프로그램의 전체적인 흐름 제어!
	 * 			<<컨트롤러의 역할>>
	 * 1. 사용자(유저)의 요청(요구) 분석
	 * 		- 버튼1을 클릭했는지, 버튼2를 클릭했는지
	 * 2. 사용자가 입력한 데이터를 얻어오기
	 * 3. **모델클래스 객체생성!!
	 * 		----> 메소드 호출
	 * 		----> 결과값 저장
	 * 4. 이동할 페이지(프레임)를 선택(페이지 이동 제어)
	 * 
	 * 				<추가옵션>
	 * 5. 유효성 검사(view)
	 * 		- 사용자가 입력한 데이터가 프로그램이 원하는 데이터가 맞는지
	 */
	
	//멤버위치
	CalcView view;
	
	public CalcController() {
		view = new CalcView();
		eventUp();
	
	}
	
	private void eventUp(){
		view.button.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		
		if(ob == view.button){
			int x = Integer.parseInt(view.tf1.getText().trim());
			int y = Integer.parseInt(view.tf2.getText().trim());
			int operator = view.comboBox.getSelectedIndex();
			String oper = view.comboBox.getItemAt(operator);
			//Object oper2 = view.comboBox.getSelectedItem();
			//String oper3 = view.comboBox.getSelectedItem().toString();
			//String oper4 = (String) view.comboBox.getSelectedItem();
			
			//Calculator model = new Calculator(x,y,oper);
			//String result2 = model.getResult();
			String result = new Calculator(x,y,oper).getResult();
			view.label.setText(result);
		}
		
	}

	public static void main(String[] args) {
		new CalcController();
		
	}


}
