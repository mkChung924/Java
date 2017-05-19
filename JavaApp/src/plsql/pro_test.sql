--pro_test.sql

--<저장프로시저> ★ Stored Procedure
-- 자주 사용되는 DML, DQL을 모듈화시켜서 DB에 저장하였다가 필요할 때 호출해서 사용!!
-- JAVA의 메소드와 같음

--형식)
	--create [or replace] PROCEDURE 프로시저명(변수명1 [IN|OUT] 자료형, 변수명2 자료형)
	--IS
	--BEGIN
		--실행할 문장1;
		--실행할 문장1;
		--실행할 문장1;
		--초기화, SQL문, 함수호출, 절차적요소(조건문, 반복문)
	--END;
	--/
	
--실행방법) EXECUTE 프로시저명();

--참고)
	/*
	void hello(String name){
		System.out.println("안녕" + name);
	}
		----> stored procedure(리턴없고)
		
	String hi(){
		return "hello~";
	}
		----> Stored Function(리턴있고)
	*/	
	
/*
문제) dept03에서 40번 부서를 삭제하는 프로시저

drop table dept03;
create table dept03 as select * from dept;

	*/

create or replace procedure del_dept(vdeptno number)
is
begin
	delete from dept03 where deptno = vdeptno;
	DBMS_OUTPUT.PUT_LINE(vdeptno||'번 부서를 삭제하였습니다.');
	
		
end;
/	

--////////////////////////////////////////////////////////
/*
 * Stored Function
 * 실행(함수호출) 후 결과를 되돌려 받을 수 있는 return 데이터; 를 반드시 명시해야 함.
 * 
 * 형식)
 *  create or replace function 함수명(매개변수)
 *  return 자료형
 *  is
 * 		변수선언
 * 	begin
 * 		실행할 SQL문;
 * 		return 데이터;
 * end;
 *
 * 사용법)
 * variable 바인드변수명 자료형; -- 변수선언
 * exec[ute] :바인드변수 := 함수명();
 */
/*
 * 
 * 문제) 특정사원에게 보너스를 지급하려고 하는데 급여의 200%에 해당하는 비용을 지급하려 한다. 이 보너스 금액을 function을 통해 구하시오.
 * fun_test.sql
 * 함수명 : call_bonus('SMITH')
 * 
 */

create or replace procedure 

	
