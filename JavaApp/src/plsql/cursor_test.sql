/*
문제) 부서테이블에 정보를 모두(모든 행) 출력하시오.
*/

/*
declare
	vdeptno DEPT.DEPTNO%TYPE;
	vdname DEPT.DNAME%TYPE;
	vloc DEPT.LOC%TYPE;
	
begin
	select deptno, dname, loc into vdeptno, vdname, vloc from dept;
	
	DBMS_OUTPUT.PUT_LINE('부서번호/부서명/부서위치');
	DBMS_OUTPUT.PUT_LINE(vdeptno || '/' || vdname || '/' || vloc);
	
end;
/

<cursor> 커서
 - select 의 결과가 2개행 이상일 때 명시적으로 사용.
 형식)
 	declare
		변수선언, 커서정의
		CURSOR 커서명 IS select 문장;
		begin
			open 커서명;
			fetch 커서명 into 변수명; -- 데이터 1행 인출
		close
	end;

*/

declare
	vdeptno DEPT.DEPTNO%TYPE;
	vdname DEPT.DNAME%TYPE;
	vloc DEPT.LOC%TYPE;
	
	vdept dept%rowtype; -- vdept타입으로 모든 컬럼을 참조하겠다!
	
	cursor cur is select deptno, dname, loc into vdeptno, vdname, vloc from dept;
	
begin
	open cur;
			
		DBMS_OUTPUT.PUT_LINE('부서번호/부서명/부서위치');
		
		loop
			fetch cur into  vdept;
			exit when cur%notfound;
			
			DBMS_OUTPUT.PUT_LINE(vdept.deptno || ' / ' || vdept.dname || ' / ' || vdept.loc);
					
		end loop;	
	close cur;	
end;
/















