package com.kosta.vending.model;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.text.View;

import com.kosta.vending.view.*;

public class Model implements Serializable{
	
	FileOutputStream fos;
	ObjectOutputStream oos;
	
	FileInputStream fis;
	ObjectInputStream ois; 
	
	public Vector<Product> productV;
	public Change change;
	public Profit profit;
	boolean state;
	public boolean threadRunning = false;

	
	public Model() {
	
		productV = new Vector<>();
		change = new Change();
		profit = new Profit();
	
	}
	

	public void saveProfit(int NewProfit){
		
		profit.setTotal(profit.getTotal() + NewProfit);
	}
	
	public int getProfit(){
		
		int accumProfit = profit.getTotal();
		return accumProfit;
	}
	
	public int getFiveCoins(){
		int five = change.getFive();
		return five;
	}
	
	public int getOneCoins(){
		int one = change.getOne();
		return one;
	}
	
	public void insertProduct(String pName, int pPrice, int pCount){
		
		productV.add(new Product(pName, pPrice, pCount));
	}
	
	public void clearProductV(){
		
		productV.clear();
	}
	
	public void insertChange(int fiveCoin, int oneCoin){
		change.setFive(fiveCoin);
		change.setOne(oneCoin);
		
	}
	
	public void resetProfit(){
		profit.setTotal(0);
	}
	

	public void setProductCount(int idx, int count){
		
		productV.get(idx).setpCount(count);
		
	}
	
	public Object[] getProductV2(int index){
		
		Object a[] = new Object[3];
		
		a[0] = productV.get(index).getpName();
		a[1] = productV.get(index).getpPrice();
		a[2] = productV.get(index).getpCount();
		
		return a;
	}
	

	
	public boolean checkAvailability(int idx){
		
		if(productV.get(idx).getpCount() == 0) return false;
			
		return true;
	}
	
	public int recharge(int money){
        
	       while(money>0)
	         {
	             if(change.getFive() >0 && money/500>0)
	            {
	               money-=500;
	               change.setFive(change.getFive()-1);
	            }else if(change.getOne() >0 && money/100>0)
	           {   money-=100;
	              change.setOne(change.getOne()-1);
	           }
	            else
	            {return money;}
	         }
	       return money;
	    }
	

	public void vendingStarted(boolean starting){
		
		try{
		fos = new FileOutputStream("vending.state");
		oos = new ObjectOutputStream(fos);
		
		state = starting;
		oos.writeBoolean(state);
		System.out.println("vending.state 저장 완료.");
		oos.close();
		fos.close();
		
		} catch(FileNotFoundException fe){
			fe.printStackTrace();
		} catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public boolean vendingStartedState(){
		
		try{
			fis = new FileInputStream("vending.state");
			ois = new ObjectInputStream(fis); 
			
			state = ois.readBoolean();
			
			ois.close();
			fis.close();
			
		} catch(IOException e){
			//e.printStackTrace();
			state = true;
			System.out.println("state = "+state);
			return state;
		}
		return state;
	}
	
	public void saveVedningState(){
		
		try {
		fos = new FileOutputStream("productV.product");
		oos = new ObjectOutputStream(fos);
		
		oos.writeObject(productV);
		System.out.println("productV.product 저장 완료.");
		oos.close();
		fos.close();
		
		fos = new FileOutputStream("remainChange.change");
		oos = new ObjectOutputStream(fos);
		
		oos.writeInt(change.getFive());
		oos.writeInt(change.getOne());
		System.out.println("remainChange.change 저장 완료.");
		oos.close();
		fos.close();
		
		fos = new FileOutputStream("myProfit.profit");
		oos = new ObjectOutputStream(fos);
		
		oos.writeInt(profit.getTotal());
		System.out.println("myProfit.profit 저장 완료.");
		oos.close();
		fos.close();
		
		System.out.println("객체쓰기 성공!");
		} catch(FileNotFoundException fe){
			fe.printStackTrace();
		} catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public void getVendingState(){
		try{
		fis = new FileInputStream("productV.product");
		ois = new ObjectInputStream(fis); 
		productV = (Vector<Product>) ois.readObject();
		
		ois.close();
		fis.close();
		
		fis = new FileInputStream("remainChange.change");
		ois = new ObjectInputStream(fis); 
		
		int five = ois.readInt();
		int one = ois.readInt();
		
		change.setFive(change.getFive()+five);
		change.setOne(change.getOne()+one);
		
		ois.close();
		fis.close();
		
		fis = new FileInputStream("myProfit.profit");
		ois = new ObjectInputStream(fis); 
		
		int prof = ois.readInt();
		profit.setTotal(profit.getTotal() + prof);
		
		ois.close();
		fis.close();
		
		} catch(FileNotFoundException fe){
			fe.printStackTrace();
		} catch(ClassNotFoundException ce){
			ce.printStackTrace();
		} catch(IOException e){
			e.printStackTrace();
		}
	}
	

	public void printVector(){
		for(int i = 0; i < productV.size(); i++){
			System.out.println(productV.get(i).getpName() + ", " + productV.get(i).getpPrice() + ", " + productV.get(i).getpCount());
		}
	}

}
