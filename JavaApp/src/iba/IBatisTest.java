package iba;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.kosta.j0516.Emp;

public class IBatisTest {
	
	public static void main(String[] args) {
		try {
			//empcopy테이블: 사원추가
			SqlMapClient smc = MySqlMapClient.getSqlMapInstance();
			
			//-----------------추가-------------------
			//smc.insert(String id);
			//smc.insert(String id, Object param);
			//smc.insert("empcopy.insertEmp"); //XML내의 <insert>태그 호출
			//smc.insert("empcopy.insertEmp2", "김주원");
			
			//Emp emp = new Emp(8006, "김유신", 3500, 30);
			//smc.insert("empcopy.insertEmp3", emp);
			
			//-----------------삭제--------------------
			int t = smc.delete("empcopy.deleteEmp");
			System.out.println("삭제된 행의 수: " + t);
			
			String delEname="김유신";
			int t2 = smc.delete("empcopy.deleteEmp2", delEname);
			if(t2==1){
				System.out.println("#["+delEname+"] 사원 삭제!");
			} else {
				System.out.println("#["+delEname+"]은 존재하지않는 사원입니다.");
			}
			
			//-----------------조회-----------------------
			//문제) 7788사번을 갖는 사원 이름 조회
			String ename = (String) smc.queryForObject("empcopy.selEname");
			System.out.println("조회결과: "+ename);
			
			//문제) 전달된 사번을 통해 사원명 조회
			int empno = 7876;
			String ename2 = (String) smc.queryForObject("empcopy.selEname2", empno);
			if(ename2!= null){
				System.out.println("조회결과: " + ename2);
			} else {
				System.out.println("조회결과: 존재하지 않는 사원번호");
			}
			
			//문제) 30번 부서에 근무하는 사원명 조회
			List list = smc.queryForList("emp.selEname");
			System.out.println("조회결과: " + list.size() +"명");
			for(int i = 0; i < list.size(); i++){
				System.out.print("["+list.get(i)+"] ");
			}
			
			//문제) 특정부서에 근무하는 사원의 사원번호, 사원명, 급여, 부서번호 출력
			int deptno = 50;
			List<Emp> list2 = smc.queryForList("emp.selDeptno",deptno);
			System.out.println();
			System.out.println("부서번호["+ deptno +"] 결과: " + list2.size() + "명");
			for(int i = 0; i < list2.size(); i++){
				Emp emp = list2.get(i);
				
				System.out.println("["+emp.getEmpno() +"] ["+ emp.getEname() +"] ["+ emp.getSal() +"] ["+ emp.getDeptno()+"]");
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
