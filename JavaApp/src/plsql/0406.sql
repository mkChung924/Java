declare
	vempno number(4);
	vename varchar2(15);
	vsal  emp.sal%type;
begin
	select empno, ename, sal into vempno, vename, vsal from emp where empno = 7788;
	
	DBMS_OUTPUT.PUT_LINE('번 : '|| vempno);
	DBMS_OUTPUT.PUT_LINE('이름 : '|| vename || ', 월급: ' || vsal);


end;
/