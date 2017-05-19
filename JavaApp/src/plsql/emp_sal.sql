
--emp_sal.sql


--특정사원 한명의 사원번호, 사원명, 연봉을 출력하시오.
--(연봉계산은 급여*12+comm)
--예) 사번 7788은 SCOTT 사원이고 연봉은 3600입니다.

declare
	vempno emp.empno%type;
	vename emp.ename%type;
	vsal emp.sal%type;
	vcomm emp.comm%type;
	
	--연봉
	annsal number;
	
begin
	select empno, ename, sal, comm into vempno, vename, vsal, vcomm from emp where empno = 7839;
	
	if(vcomm is not null)
	then
		annsal := vsal*12 +vcomm;		
	else
		annsal := vsal*12;
		
	end if;
	
	dbms_output.put_line('사원 '|| vempno || '은 ' || vename || '사원이고 연봉은 ' || annsal || '입니다.');	
	
end;
/