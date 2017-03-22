package com.kosta.calc.control;

import com.kosta.calc.view.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.kosta.calc.model.*;

public class CalcController implements ActionListener {
	/*
	 * Controller - ���α׷��� ��ü���� �帧 ����!
	 * 			<<��Ʈ�ѷ��� ����>>
	 * 1. �����(����)�� ��û(�䱸) �м�
	 * 		- ��ư1�� Ŭ���ߴ���, ��ư2�� Ŭ���ߴ���
	 * 2. ����ڰ� �Է��� �����͸� ������
	 * 3. **��Ŭ���� ��ü����!!
	 * 		----> �޼ҵ� ȣ��
	 * 		----> ����� ����
	 * 4. �̵��� ������(������)�� ����(������ �̵� ����)
	 * 
	 * 				<�߰��ɼ�>
	 * 5. ��ȿ�� �˻�(view)
	 * 		- ����ڰ� �Է��� �����Ͱ� ���α׷��� ���ϴ� �����Ͱ� �´���
	 */
	
	//�����ġ
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
