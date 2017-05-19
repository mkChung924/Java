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
	//-------------------DML 업무(insert, delete, update)------------------------
	
	ResultSet rs;
	//-------------------DQL 업무(select)----------------------------------------
	
	//30번 부서에 근무하는 사원의 사원번호, 사원명, 입사일을 출력하시오.
	
	public JDBCTest() {
		
		try {
			
		//1. 드라이버 로딩(driver loading) - 제품군 선택
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
		//2. Connection 객체 생성
			String url = "jdbc:oracle:thin:@//localhost:1521/orcl";
			String user = "scott2";
			String password = "tiger";
			
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("DB연결성공!");
			
		//3. Statement 객체 생성
			stmt = conn.createStatement();
			int deptno = 30;
			String sql = "select empno, ename, hiredate from emp where deptno ="+deptno;
			
			
		//4. ResultSet 객체 생성 (행단위 데이터 ----> 열 데이터 얻기)
			rs = stmt.executeQuery(sql);
			ResultSetMetaData rsmd = rs.getMetaData();
			
			System.out.println("<<" + deptno + "부서의 사원정보>>");
			
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
			System.out.println("#SQL 에러발생!");
			e.printStackTrace();
		} 
		
	}
	
	public static void main(String[] args) {
		new JDBCTest();
	}

}
