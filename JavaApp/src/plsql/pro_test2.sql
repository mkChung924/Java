
--ename_del.sql


create or replace procedure ename_del(vename emp.ename%type)
is
begin
	delete from emp03 where ename = vename;
	DBMS_OUTPUT.PUT_LINE(vename||'을 삭제하였습니다.');
end;
/
