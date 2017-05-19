

--특정 사원이 커미션을 받는지 안 받는지 구분해서 출력하시오.
--예1: 사번7788은 SCOTT사원이고 커미션을 받지 않습니다.
-- where empno = 7788;
--예2: 사번7654은 MARTIN사원이고 커미션을 1400 받습니다.
-- where empno = 7654;

declare
	vempno emp.empno%type;
	vename emp.ename%type;
	vcomm emp.comm%type;
	
begin

	select empno, ename, comm into vempno, vename, vcomm from emp where empno = 7844;

	if(vcomm is null)
	then
		DBMS_OUTPUT.PUT_LINE('사번'||vempno||'은 '|| vename || ' 사원이고 커미션을 받지 않습니다.');
	
	else
		DBMS_OUTPUT.PUT_LINE('사번'||vempno||'은 '|| vename || ' 사원이고 커미션 '|| vcomm || '을 받습니다.');
			
	end if;

	
	select empno, ename, comm into vempno, vename, vcomm from emp where empno = 7654;
	
	if (vcomm is null)
	then
		DBMS_OUTPUT.PUT_LINE('사번'||vempno||'은 '|| vename || ' 사원이고 커미션을 받지 않습니다.');
	else
		DBMS_OUTPUT.PUT_LINE('사번'||vempno||'은 '|| vename || ' 사원이고 커미션 '|| vcomm || '을 받습니다.');
		
	end if;
	
end;
/