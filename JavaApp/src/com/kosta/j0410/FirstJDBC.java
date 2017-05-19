package com.kosta.j0410;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class FirstJDBC {
	
	public static void main(String[] args) {
		try {
			//JDBC : Java DataBase Connectivity (�ڹٿ� DB�� �������ִ� ���, �������̽�)
		//1. ����̹� �ε�(��ǰ�� ����)
			//Class.forName("����̹� Ŭ������");
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
		//2. ���� ��ü ���� : Connection
			//Connection conn = DriverManager.getConnection(String url, String user, String password);
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orcl","scott2","tiger");
			
			System.out.println("DB���� ����~!!");
			
		//3. statement ��ü����! ==> ����: SQL���� �����ϱ� ���ؼ�
			Statement stmt = conn.createStatement();
			
				//����1) ���̺� dept_copy���� 10��, 30�� �μ� ����
			String sql = "delete from dept_copy where deptno in(20,30)";
			int t = stmt.executeUpdate(sql);
			//t : ���� �Ǵ� ������ ���� ���� ����
			System.out.println("������ ���� ��: " + t);
			
				//����2) 20�� �μ��� �μ���ȣ, �μ���, �μ���ġ�� ����Ͻÿ�.
			
		//4. ResultSet ��ü���� ==> ��? ��ȸ�� �࿭�����͸� ��� ���ؼ�!
			int deptno = 20;
			sql = "select deptno, dname, loc from dept where deptno in(10,20)";
			ResultSet rs = stmt.executeQuery(sql);
			ResultSetMetaData rsmd = rs.getMetaData();
			//System.out.println(rsmd.getColumnCount());
			
			for(int i = 1; i <= rsmd.getColumnCount(); i++){
				if( i <= rsmd.getColumnCount() - 1)
					System.out.print(rsmd.getColumnName(i) + " / ");
				else
					System.out.print(rsmd.getColumnName(i));	
			}
			System.out.println();
			while(rs.next()){

				for(int i = 1; i <= rsmd.getColumnCount(); i++){
					if(i <= rsmd.getColumnCount() - 1)
						System.out.print(rs.getString(i) +" / ");
					else
						System.out.print(rs.getString(i));
				}
				System.out.println();
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
