package com.kosta.vending.control;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.lang.Thread.State;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.kosta.vending.model.*;
import com.kosta.vending.view.AdminView;
import com.kosta.vending.view.MainView;
import com.kosta.vending.view.RamenDrop;

public class Control implements ActionListener, Runnable {
	
	MainView mainView;
	AdminView adminView;
	Model model;
	
	String pName;
	String money;
	int pPrice;
	int pCount;
	
	int accum; // 누적된 돈
	
	Object getRamenInfo[];
	
	boolean starting; //자판기 최초 설정
	
	RamenDrop drop;
		
	Thread t;
	Thread t2;
	
	public Control() {
		
		t2 = new Thread(this);
		
		model = new Model();
		mainView = new MainView();
		adminView = new AdminView();
		drop = new RamenDrop();
		
		starting = model.vendingStartedState();
		
		if(starting){
			adminView.setVisible(true);
		} else {
			model.getVendingState();
			adminView.setVisible(false);
			mainView.setVisible(true);
			setLabelsName();
			setLabelImage();
			
		}
		t2.start();
		getRamenInfo = new Object[3];
		//productV = model.productV;
		//profit = model.profit;
		//change = model.change;
		
		eventUp();
		
	}
	
	public void run()
	{
		try {
			while(true){
				
				Thread.sleep(500);
				System.out.println("100원 : "+ model.getOneCoins());
				System.out.println("500원 : "+ model.getFiveCoins());
				if(model.getOneCoins() < 10 && model.getFiveCoins() < 10){
				      
				   mainView.bill.setEnabled(false);
				   mainView.coin5.setEnabled(false);
				   mainView.coin1.setEnabled(false);
				   //mainView.returnMoney.setEnabled(false);
				   mainView.noChange.setIcon(new ImageIcon(new ImageIcon("image/vendingmachine/noMoney.png").getImage().getScaledInstance(130, 45, Image.SCALE_DEFAULT)));

				   return;
				} else {
					 mainView.bill.setEnabled(true);
					 mainView.coin5.setEnabled(true);
					 mainView.coin1.setEnabled(true);
					 mainView.returnMoney.setEnabled(true);
					 mainView.noChange.setIcon(new ImageIcon(new ImageIcon("image/vendingmachine/noMoney_ro.png").getImage().getScaledInstance(130, 45, Image.SCALE_DEFAULT)));

				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new Control();
	}
	
	public void eventUp(){
		
		mainView.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				model.saveProfit(Integer.parseInt(mainView.tf.getText()));
				model.saveVedningState();
			}
		});
		
		//동전투입구
		mainView.coinEnter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mainView.bill.setVisible(false);
				mainView.coin5.setVisible(true);
				mainView.coin1.setVisible(true);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				mainView.coinEnter.setIcon(new ImageIcon(new ImageIcon("image/vendingmachine/putCoin.png").getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT)));
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				mainView.coinEnter.setIcon(new ImageIcon(new ImageIcon("image/vendingmachine/putCoin_ro.png").getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT)));

			}

			@Override
			public void mouseExited(MouseEvent e) {
				mainView.coinEnter.setIcon(new ImageIcon(new ImageIcon("image/vendingmachine/putCoin.png").getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT)));

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				mainView.coinEnter.setIcon(new ImageIcon(new ImageIcon("image/vendingmachine/putCoin.png").getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT)));

			}
	
		});
		
		//반환버튼(라벨로 구현)
		mainView.returnMoney.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				money = mainView.tf.getText().trim();
				accum = Integer.parseInt(money);
				int remain = 0;
				
				if(mainView.tf.getText().trim().equals("0")){
					
				} else {
					remain = model.recharge(accum);
					mainView.tf.setText(remain+"");
					mainView.returnedCoins.setVisible(true);
					//mainView.returnedCoins.setEnabled(false);
					
				}
				
				System.out.println("잔돈: 500 -> "+ model.getFiveCoins() + ", 100 -> " + model.getOneCoins());
				setItEnable(remain);
				setItDisable(remain);
				accum = remain;
			}

			@Override
			public void mousePressed(MouseEvent e) {
				mainView.returnMoney.setIcon(new ImageIcon(new ImageIcon("image/vendingmachine/returnMoney_pressed.png")
						.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT)));
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				mainView.returnMoney.setIcon(new ImageIcon(new ImageIcon("image/vendingmachine/returnMoney_ro.png")
						.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT)));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				mainView.returnMoney.setIcon(new ImageIcon(new ImageIcon("image/vendingmachine/returnMoney.png")
						.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT)));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				mainView.returnMoney.setIcon(new ImageIcon(new ImageIcon("image/vendingmachine/returnMoney_ro.png")
						.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT)));
			}
			
	
		});
		
		//반환된 동전 클릭
		mainView.returnedCoins.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				mainView.returnedCoins.setVisible(false);
			}

			public void mousePressed(MouseEvent e) {
				mainView.returnedCoins.setEnabled(true);
			}

			public void mouseEntered(MouseEvent e) {
				mainView.returnedCoins.setEnabled(false);
			}

			public void mouseExited(MouseEvent e) {
				mainView.returnedCoins.setEnabled(true);
			}

		});
		
		
		//라면 JLabel Array 마우스 이벤트 등록
		for(int i = 0; i < mainView.labels.length; i++){
			int j = i;
			
			//mainView.labels[i].addMouseListener(new MyMouseListener(i));
			mainView.labels[i].addMouseListener(new MouseAdapter() {
				
				public void mouseClicked(MouseEvent e){

					if(model.productV.get(j).getpCount() != 0){
		            	
		            	getRamenInfo = model.getProductV2(j);
		            	
		            	pName = getRamenInfo[0].toString();
		            	pPrice = (int) getRamenInfo[1];
		            	pCount = (int) getRamenInfo[2];
		    			
		    			if(accum >= pPrice){
		    				
		    				model.saveProfit(pPrice);
		    				model.setProductCount(j, --pCount);
		    				
		    				if(drop.threadRunning){
		    					
		    				} else {
		    					
		    					drop.getXY(mainView.labels[j]);
		    					drop.getDimension(mainView.getContentPane().getSize());
		    					
		    					if(t == null || t.getState() == State.TERMINATED){
		    						t = new Thread(drop);
		    						t.start();
	    						
		    						System.out.println(pName);
		    						System.out.println("남은 수량: "+pCount);
			    					System.out.println("가격: "+pPrice + ", 총 수익: " + model.getProfit());
			    					
			    					accum -= pPrice;
			    					mainView.tf.setText(accum+"");
			    								    					
//			    					try {
//										t.join();
//									} catch (InterruptedException e1) {
//										e1.printStackTrace();
//									}
			    					setItDisable(accum);
			    					
		    					}							
		    				}
		    				
		    			} else {
		    	
		    				JOptionPane.showMessageDialog(mainView, "금액이 부족합니다.");
		    				
		    			}
		        	} else {
		        		JOptionPane.showMessageDialog(mainView, "매진되었습니다.");
		        	}
	
				}
				
				public void mouseEntered(MouseEvent e){
					
					mainView.labels[j].setEnabled(false);
					
				}
				
				public void mousePressed(MouseEvent e){
					
					mainView.labels[j].setEnabled(true);
				}
				
				public void mouseExited(MouseEvent e){
					mainView.labels[j].setEnabled(true);
				}
			});
		}
		
		//자판기&관리자뷰 내 버튼 이벤트 등록
		mainView.bill.addActionListener(this);
		mainView.coin5.addActionListener(this);
		mainView.coin1.addActionListener(this);
		mainView.admin.addActionListener(this);
		mainView.billEnter2.addActionListener(this);
		
		adminView.submit.addActionListener(this);
		adminView.cancel.addActionListener(this);
		adminView.getProfit.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		money = mainView.tf.getText().toString();
		
		//지폐 투입구
		if(ob == mainView.billEnter2){
			mainView.bill.setVisible(true);
			mainView.coin5.setVisible(false);
			mainView.coin1.setVisible(false);
		}
		//천원버튼
		else if(ob == mainView.bill){
			if(money.length() == 0){
				mainView.tf.setText("1000");
			} else {
				int intMoney = Integer.parseInt(money);
				if(intMoney > 4000 && intMoney < 5000){
					JOptionPane.showMessageDialog(mainView, "최대로 투입할 수 있는 금액은 5,000원 입니다.\n500원 또는 100원 동전을 넣어주세요.");
				} else if(intMoney == 5000){
					JOptionPane.showMessageDialog(mainView, "최대로 투입할 수 있는 금액은 5,000원 입니다.");
				} else{
				accum = intMoney + 1000;
				mainView.tf.setText(accum+"");
				setItEnable(accum);
				
				}
			}
			
			
		}
		//500원 버튼
		else if(ob == mainView.coin5){
			if(money.length() == 0){
				mainView.tf.setText("500");
			} else {
				
				int intMoney = Integer.parseInt(money);
				if(intMoney > 4500 && intMoney < 5000){
					JOptionPane.showMessageDialog(mainView, "최대로 투입할 수 있는 금액은 5,000원 입니다.\n100원짜리 동전을 넣어주세요.");
				} else if(intMoney == 5000){
					JOptionPane.showMessageDialog(mainView, "최대로 투입할 수 있는 금액은 5,000원 입니다.");
				} else{
				
					accum = intMoney + 500;
					mainView.tf.setText(accum+"");
					setItEnable(accum);
				}
			}
		} 
		//100원 버튼
		else if(ob == mainView.coin1){
			if(money.length() == 0){
				mainView.tf.setText("100");
			} else {
				int intMoney = Integer.parseInt(money);
				if(intMoney > 4900){
					JOptionPane.showMessageDialog(mainView, "최대로 투입할 수 있는 금액은 5,000원 입니다.");
				} else {
					accum = intMoney + 100;
					mainView.tf.setText(accum+"");
					setItEnable(accum);
				}
			}
		} 
		//관리자 페이지 버튼
		else if(ob == mainView.admin){
			
			t2.stop();
			
			mainView.setVisible(false);
			adminView.setVisible(true);
			adminView.tf_profit.setEnabled(false);
			adminView.tf_profit.setEditable(false);
			
			model.vendingStartedState();
				
			adminView.ramen1.setSelectedItem(model.getProductV2(0)[0].toString());
			adminView.price1.setSelectedItem(model.getProductV2(0)[1].toString());
			adminView.tf1c.setText(model.getProductV2(0)[2]+"");
			adminView.ramen2.setSelectedItem(model.getProductV2(1)[0].toString());
			adminView.price2.setSelectedItem(model.getProductV2(1)[1].toString());
			adminView.tf2c.setText(model.getProductV2(1)[2]+"");
			adminView.ramen3.setSelectedItem(model.getProductV2(2)[0].toString());
			adminView.price3.setSelectedItem(model.getProductV2(2)[1].toString());
			adminView.tf3c.setText(model.getProductV2(2)[2]+"");
			adminView.ramen4.setSelectedItem(model.getProductV2(3)[0].toString());
			adminView.price4.setSelectedItem(model.getProductV2(3)[1].toString());
			adminView.tf4c.setText(model.getProductV2(3)[2]+"");
			adminView.ramen5.setSelectedItem(model.getProductV2(4)[0].toString());
			adminView.price5.setSelectedItem(model.getProductV2(4)[1].toString());
			adminView.tf5c.setText(model.getProductV2(4)[2]+"");
			adminView.ramen6.setSelectedItem(model.getProductV2(5)[0].toString());
			adminView.price6.setSelectedItem(model.getProductV2(5)[1].toString());
			adminView.tf6c.setText(model.getProductV2(5)[2]+"");
			adminView.ramen7.setSelectedItem(model.getProductV2(6)[0].toString());
			adminView.price7.setSelectedItem(model.getProductV2(6)[1].toString());
			adminView.tf7c.setText(model.getProductV2(6)[2]+"");
			adminView.ramen8.setSelectedItem(model.getProductV2(7)[0].toString());
			adminView.price8.setSelectedItem(model.getProductV2(7)[1].toString());
			adminView.tf8c.setText(model.getProductV2(7)[2]+"");
			
			
			adminView.tf_five.setText(model.getFiveCoins()+"");
			adminView.tf_one.setText(model.getOneCoins()+"");
			adminView.tf_profit.setText(model.getProfit()+"");
			
		} 
		//관리자뷰 수익금 챙기는 버튼
		else if(ob == adminView.getProfit){
			
			adminView.tf_profit.setText("0");
			model.resetProfit();
			
		} 
		
		else if(ob == adminView.cancel){
			
			if(model.vendingStartedState()){
				System.exit(0);
			} else {
				adminView.setVisible(false);
				mainView.setVisible(true);
				
				if(t2 == null || t2.getState() == State.TERMINATED){
					t2 = new Thread(this);
					t2.start();
				}
			}
			
		}
		//관리자뷰 확인 버튼
		else if(ob == adminView.submit){
			
			String p1 = adminView.ramen1.getSelectedItem().toString();
			String p1p = adminView.price1.getSelectedItem().toString();
			String p1c = adminView.tf1c.getText().trim();
			String p2 = adminView.ramen2.getSelectedItem().toString();
			String p2p = adminView.price2.getSelectedItem().toString();
			String p2c = adminView.tf2c.getText().trim();
			String p3 = adminView.ramen3.getSelectedItem().toString();
			String p3p = adminView.price3.getSelectedItem().toString();
			String p3c = adminView.tf3c.getText().trim();
			String p4 = adminView.ramen4.getSelectedItem().toString();
			String p4p = adminView.price4.getSelectedItem().toString();
			String p4c = adminView.tf4c.getText().trim();
			String p5 = adminView.ramen5.getSelectedItem().toString();
			String p5p = adminView.price5.getSelectedItem().toString();
			String p5c = adminView.tf5c.getText().trim();
			String p6 = adminView.ramen6.getSelectedItem().toString();
			String p6p = adminView.price6.getSelectedItem().toString();
			String p6c = adminView.tf6c.getText().trim();
			String p7 = adminView.ramen7.getSelectedItem().toString();
			String p7p = adminView.price7.getSelectedItem().toString();
			String p7c = adminView.tf7c.getText().trim();
			String p8 = adminView.ramen8.getSelectedItem().toString();
			String p8p = adminView.price8.getSelectedItem().toString();
			String p8c = adminView.tf8c.getText().trim();
			String fiveC = adminView.tf_five.getText().trim();
			String oneC = adminView.tf_one.getText().trim();
			
			//올바른 입력값 체크
			if(!p1c.isEmpty() || !p2c.isEmpty() || !p3c.isEmpty() ||
					!p4c.isEmpty() || !p5c.isEmpty() || !p6c.isEmpty() ||
					!p7c.isEmpty() || !p8c.isEmpty() ||
					!fiveC.isEmpty() || !oneC.isEmpty()){
				
				if(p1c.matches("[0-9]+") && p2c.matches("[0-9]+") && 
						p3c.matches("[0-9]+") && p4c.matches("[0-9]+") && 
						p5c.matches("[0-9]+") && p6c.matches("[0-9]+") && 
						p7c.matches("[0-9]+") && p8c.matches("[0-9]+") &&
						fiveC.matches("[0-9]+") && oneC.matches("[0-9]+")){
					
					if((p1c.length() < 3) &&
							(p2c.length() < 3) &&
							(p3c.length() < 3) &&
							(p4c.length() < 3) &&
							(p5c.length() < 3) &&
							(p6c.length() < 3) &&
							(p7c.length() < 3) &&
							(p8c.length() < 3)){
						
						if(fiveC.length() < 4 && oneC.length() < 4){
							model.clearProductV();
				
							//vector에 라면정보 빈즈를 담는 것.
							model.insertProduct(p1, Integer.parseInt(p1p), Integer.parseInt(p1c));
							model.insertProduct(p2, Integer.parseInt(p2p), Integer.parseInt(p2c));
							model.insertProduct(p3, Integer.parseInt(p3p), Integer.parseInt(p3c));
							model.insertProduct(p4, Integer.parseInt(p4p), Integer.parseInt(p4c));
							model.insertProduct(p5, Integer.parseInt(p5p), Integer.parseInt(p5c));
							model.insertProduct(p6, Integer.parseInt(p6p), Integer.parseInt(p6c));
							model.insertProduct(p7, Integer.parseInt(p7p), Integer.parseInt(p7c));
							model.insertProduct(p8, Integer.parseInt(p8p), Integer.parseInt(p8c));
							model.insertChange(Integer.parseInt(fiveC), Integer.parseInt(oneC));
									
							adminView.setVisible(false);
							mainView.setVisible(true);
							mainView.tf.setText("0");
												
							//입력한 값 프린트
							model.printVector();
							//입력한 정보를 JLabel Array에 등록함.
							//라면이름과 프로그램 내에서 설정한 경로를 비교하여 같은 이름을 가진 사진 설정.
							setLabelsName();
							setLabelImage();
							
							//자판기의 최초 구동 state 변경. 최초 true -> false
							if(starting){
							model.vendingStarted(false);
							}
							model.saveVedningState();

							if(t2 == null || t2.getState() == State.TERMINATED){
								t2 = new Thread(this);
								t2.start();
							}
						} else {
							JOptionPane.showMessageDialog(adminView, "거스름 돈은 1000개를 넘을 수 없습니다.");
						}
					} else {
						JOptionPane.showMessageDialog(adminView, "물품을 100개 이상 넣을 수 없습니다.");
					}
				} else {
					JOptionPane.showMessageDialog(adminView, "가격과 수량은 숫자만 입력 가능합니다.");
				}
			} else {
				JOptionPane.showMessageDialog(adminView, "빈칸은 존재할 수 없습니다.");
			}
			
			
		} 

		
		
	}
	
	//메소드
	public void setLabelImage(){
		File folder = new File("image/dark2");
		File[] listOfFiles = folder.listFiles();
		
		for(int i = 0 ; i < mainView.labels_1.length; i++){
			for(int j = 0 ; j < listOfFiles.length; j++){
				if(listOfFiles[j].getName().contains(mainView.labels[i].getName())){
					mainView.labels[i].setIcon(new ImageIcon(new ImageIcon("image/dark2/" + mainView.labels[i].getName()+".png")
							.getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT)));
				}
			}
		}

	}
	
	public void setLabelsName(){
		
		for(int i = 0; i < mainView.labels_1.length; i++){
			mainView.labels[i].setName(model.productV.get(i).getpName());
			mainView.labels_1[i].setText(model.productV.get(i).getpPrice() + "원");
			if(model.productV.get(i).getpCount() != 0){
				mainView.labels_1[i].setIcon(new ImageIcon(new ImageIcon("image/state/disable_bt.png")
						.getImage().getScaledInstance(70, 25, Image.SCALE_DEFAULT)));
			} else {
				mainView.labels_1[i].setIcon(new ImageIcon(new ImageIcon("image/state/sold_bt.png")
						.getImage().getScaledInstance(70, 25, Image.SCALE_DEFAULT)));
			}
		}
	}
	
	public void setItEnable(int pPrice){
		File folder = new File("image/light2");
		File folder2 = new File("image/dark2");
		File[] listOfFiles = folder.listFiles();
		File[] listOfFiles2 = folder2.listFiles();
		String found = "";
		String ramen = "";
		for(int i = 0; i < model.productV.size(); i++){
			
			if(model.productV.get(i).getpCount() != 0){
				ramen = mainView.labels[i].getName();
				
				for(int j = 0; j < listOfFiles.length; j++){
					if(listOfFiles[j].getName().contains(ramen)){
						found = listOfFiles[j].getName();
					}
					
				}
				
				if(pPrice >= model.productV.get(i).getpPrice()){
					mainView.labels[i].setIcon(new ImageIcon(new ImageIcon("image/light2/" + found)
								.getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT)));
					mainView.labels_1[i].setIcon(new ImageIcon(new ImageIcon("image/state/choose_bt.png")
							.getImage().getScaledInstance(70, 25, Image.SCALE_DEFAULT)));
				}
				
			} else {
				ramen = mainView.labels[i].getName();
				for(int j = 0; j < listOfFiles2.length; j++){
					if(listOfFiles2[j].getName().contains(ramen)){
						found = listOfFiles2[j].getName();
					}
				}
				mainView.labels[i].setIcon(new ImageIcon(new ImageIcon("image/dark2/" + found)
						.getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT)));
				mainView.labels_1[i].setIcon(new ImageIcon(new ImageIcon("image/state/sold_bt.png")
						.getImage().getScaledInstance(70, 25, Image.SCALE_DEFAULT)));
			}
		}
		
	}
	
	public void setItDisable(int pPrice){
		
		
		File folder = new File("image/dark2");
		File[] listOfFiles = folder.listFiles();
		String found = "";
		
		for(int i = 0; i < model.productV.size(); i++){
			String ramen = mainView.labels[i].getName();
			
			for(int j = 0; j < listOfFiles.length; j++){
				if(listOfFiles[j].getName().contains(ramen)){
					found = listOfFiles[j].getName();
				}
				
			}
			
			if(pPrice < model.productV.get(i).getpPrice()){
				mainView.labels[i].setIcon(new ImageIcon(new ImageIcon("image/dark2/" + found)
							.getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT)));
				
				if(model.productV.get(i).getpCount() == 0){
					mainView.labels_1[i].setIcon(new ImageIcon(new ImageIcon("image/state/sold_bt.png")
							.getImage().getScaledInstance(70, 25, Image.SCALE_DEFAULT)));
				} else {
					mainView.labels_1[i].setIcon(new ImageIcon(new ImageIcon("image/state/disable_bt.png")
							.getImage().getScaledInstance(70, 25, Image.SCALE_DEFAULT)));
				}
			}
			

		}
		
	}
	

}



