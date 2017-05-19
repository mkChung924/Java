
-- if_elsif_test.sql

declare
	vempno emp.empno%type;
	vename emp.ename%type;
	vdeptno emp.deptno%type;
	vdname dept.dname%type;
	
begin

	select empno, ename, deptno into vempno, vename, vdeptno from emp where empno = 7777;
	--select dname into vdname from dept where deptno = vdeptno;
	if(vdeptno = 10)
	then
		vdname := 'ACCOUNTING';
	elsif(vdeptno = 20)
	then
		vdname := 'RESEARCH';
	elsif(vdeptno = 30)
	then
		vdname := 'SALES';
	else
		vdname := 'OPERATIONS';
	end if;


	DBMS_OUTPUT.PUT_LINE('사번'||vempno||'은 '||vename|| '사원이고 ' || vdname || '부서에서 근무합니다.');

	exception
	when
	no_data_found
	then
	DBMS_OUTPUT.PUT_LINE('존재하지 않는 사번입니다.');
end;
/