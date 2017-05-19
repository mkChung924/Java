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
 * print :바인드변수
 */
/*
 * 
 * 문제) 특정사원에게 보너스를 지급하려고 하는데 급여의 200%에 해당하는 비용을 지급하려 한다. 이 보너스 금액을 function을 통해 구하시오.
 * fun_test.sql
 * 함수명 : call_bonus('SMITH')
 * 
 */

create or replace function call_bonus(vename emp.ename%type)
return varchar2
is
	bonus number;
	vsal emp.sal%type;
begin
	select sal into vsal from emp where ename = vename;
	bonus := vsal*2;
	--return bonus;
	return vename ||'사원의 보너스는 '|| bonus ||'입니다.';
end;
/


