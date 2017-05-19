package com.kosta.j0410;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class JDBCTest {
	
	Connection conn;
	Statement stmt;
	//-------------------DML ����(insert, delete, update)------------------------
	
	ResultSet rs;
	//-------------------DQL ����(select)----------------------------------------
	
	//30�� �μ��� �ٹ��ϴ� ����� �����ȣ, �����, �Ի����� ����Ͻÿ�.
	
	public JDBCTest() {
		
		try {
			
		//1. ����̹� �ε�(driver loading) - ��ǰ�� ����
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
		//2. Connection ��ü ����
			String url = "jdbc:oracle:thin:@//localhost:1521/orcl";
			String user = "scott2";
			String password = "tiger";
			
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("DB���Ἲ��!");
			
		//3. Statement ��ü ����
			stmt = conn.createStatement();
			int deptno = 30;
			String sql = "select empno, ename, hiredate from emp where deptno ="+deptno;
			
			
		//4. ResultSet ��ü ���� (����� ������ ----> �� ������ ���)
			rs = stmt.executeQuery(sql);
			ResultSetMetaData rsmd = rs.getMetaData();
			
			System.out.println("<<" + deptno + "�μ��� �������>>");
			
			for(int i = 1; i <= rsmd.getColumnCount(); i++){
				if(i <= rsmd.getColumnCount() -1) System.out.print(rsmd.getColumnLabel(i) + " / ");
				else System.out.print(rsmd.getColumnLabel(i));
			}
			System.out.println();
			
			while(rs.next()){
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				Date hiredate = rs.getDate("hiredate");
				System.out.println(empno + ", " + ename + ", " + hiredate);
			}
			
			
		} catch (Exception e) {
			System.out.println("#SQL �����߻�!");
			e.printStackTrace();
		} 
		
	}
	
	public static void main(String[] args) {
		new JDBCTest();
	}

}
