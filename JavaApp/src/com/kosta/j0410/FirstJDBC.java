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
			//JDBC : Java DataBase Connectivity (자바와 DB를 연결해주는 기술, 인터페이스)
		//1. 드라이버 로딩(제품군 선택)
			//Class.forName("드라이버 클래스명");
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
		//2. 연결 객체 생성 : Connection
			//Connection conn = DriverManager.getConnection(String url, String user, String password);
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orcl","scott2","tiger");
			
			System.out.println("DB연결 성공~!!");
			
		//3. statement 객체생성! ==> 이유: SQL문을 실행하기 위해서
			Statement stmt = conn.createStatement();
			
				//문제1) 테이블 dept_copy에서 10번, 30번 부서 삭제
			String sql = "delete from dept_copy where deptno in(20,30)";
			int t = stmt.executeUpdate(sql);
			//t : 수정 또는 삭제된 행의 갯수 리턴
			System.out.println("삭제된 행의 수: " + t);
			
				//문제2) 20번 부서의 부서번호, 부서명, 부서위치를 출력하시오.
			
		//4. ResultSet 객체생성 ==> 왜? 조회된 행열데이터를 담기 위해서!
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
