
declare
	a number;
	b number := 10;
	
begin
	
-- 	a := 3;
-- 		
-- 	if(a<b)
-- 	then dbms_output.put_line('a는 b보다 작다');
-- 	end if;
-- 
-- 	if(a>=b)
-- 	then DBMS_OUTPUT.PUT_LINE('a는 b보다 크거나 같다');
-- 	end if;

	a := 20;
	b := 10;
	
	if a<b
	then
		DBMS_OUTPUT.PUT_LINE(a||'는 b보다 작다');
	else
		DBMS_OUTPUT.PUT_LINE(a||'는 b보다 크거나 같다');
	end if;
	
end;
/